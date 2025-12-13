package com.picpaySimplificado.picpaysimplificado.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.picpaySimplificado.picpaysimplificado.domain.user.User;
import com.picpaySimplificado.picpaysimplificado.domain.user.UserType;
import com.picpaySimplificado.picpaysimplificado.repository.UserRepository;

public class UserService {
    @Autowired
    private UserRepository repository;
    public void validateTransaction(User sender, BigDecimal amount) throws Exception{

        if(sender.getUserType() == UserType.MERCHANT) 
                throw new Exception("Merchants are not allowed to make transactions.");
        
        if(sender.getBalance().compareTo(amount) < 0)
                throw new Exception("Insufficient balance for the transaction.");


        var balance = sender.getBalance();
       

    }
}
