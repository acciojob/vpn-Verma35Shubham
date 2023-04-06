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
public class RefundService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllSuccessTrnsc(int userId){
        User user = userRepository.findById(userId).get();

        List<Transaction> list = user.getTransactionList();
        List<Transaction> ans = new ArrayList<>();

        for(Transaction trns : list){
            if(trns.isTransactionStatus() == true){
                ans.add(trns);
            }
        }

        return ans;
    }

}
