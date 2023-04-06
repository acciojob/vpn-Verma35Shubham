package com.example.vpn.Service;

import com.example.vpn.Model.Transaction;
import com.example.vpn.Model.User;
import com.example.vpn.Repository.TransactionRepository;
import com.example.vpn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
     @Autowired
    UserRepository userRepository;

    public void addTransaction(int userId, long amount, long amount_deducted){
        User user = userRepository.findById(userId).get();

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setAmountdeducted(amount_deducted);
        transaction.setTransactionStatus(true);
        transaction.setUser(user);

        user.getTransactionList().add(transaction);

        userRepository.save(user);
    }

    public void deleteFail(int userId){
        User user = userRepository.findById(userId).get();

        List<Transaction> list = user.getTransactionList();


        for(Transaction trns : list){
            if(trns.isTransactionStatus() == false){
                list.remove(trns);
            }
        }

    }

}
