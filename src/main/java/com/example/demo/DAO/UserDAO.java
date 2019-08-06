package com.example.demo.DAO;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    public List<User> findAll() {
        return new ArrayList<User>();
    }
}
