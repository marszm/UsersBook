package com.example.demo.Controller;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class UserController {

//    @Autowired
    UserDAO userDAO;

    //save user
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){

        return userDAO.create(user);

    }

    //get all user
    @GetMapping("/users")
    public List<User> getAllUsers(){

        return userDAO.findAll();

    }

    //get user by id
    @GetMapping("/notes{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long uid){

        User user = userDAO.findByIdOne(uid);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> upadateUser(@PathVariable(value = "id") Long uid, @Valid @RequestBody User userDetails){

        User user = userDAO.findByIdOne(uid);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());

        User updateUser = userDAO.create(user);
        return ResponseEntity.ok().body(updateUser);

    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long uid){

        User user = userDAO.findByIdOne(uid);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        userDAO.deleteUser(user);
        return ResponseEntity.ok().build();

    }
}
