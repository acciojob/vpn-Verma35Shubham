package com.example.vpn.Service;

import com.example.vpn.Model.Refund;
import com.example.vpn.Model.User;
import com.example.vpn.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(String name, String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);
    }

    public List<Refund> getAllRefund(int userId){
        User user = userRepository.findById(userId).get();

        return user.getRefundList();
    }
}
