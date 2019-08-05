package com.example.demo.DAO;

import com.example.demo.repositpry.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserDAO {

    @Autowired
    UserRepository userRepository;

    //create user
    public User cerate(User user){
        return userRepository.create(user);
    }

    //show all ussers
    public List<User> findAll(){
        return userRepository.findAll();
    }

    //get user by id
    public User findByIdOne(Long uid){
        return userRepository.findByIdOne(uid);
    }

    //delete user
    public void deleteUser(User user){
        userRepository.deleteUser(user);
    }

}
