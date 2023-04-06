package com.example.vpn;


import com.example.vpn.Model.Transaction;
import com.example.vpn.Service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Refund")
public class RefunController {

    @Autowired
    RefundService refundService;

    public List<Transaction> getAllSuccessTransaction(int userId){
        return refundService.getAllSuccessTrnsc(userId);
    }
}
