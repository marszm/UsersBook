package com.example.demo.DAO;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {


    User user;
    //create user

    //show all ussers

    //get user by id
    public User findByIdOne(Long uid){
        return findByIdOne(uid);
    }

    //delete user
    public void deleteUser(User user){
        deleteUser(user);
    }

    public User create(User user) {
        return user;
    }

    public void findAll() {
        return ;
    }
}
