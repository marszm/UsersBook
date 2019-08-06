package com.example.demo.Controller;

import com.example.demo.DAO.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class UserController {

    @Autowired
    UserDAO userDAO;
    List<User> userList = new ArrayList<>();
    //save user
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userDAO.create(user);

    }

    //get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        User user = new User();
        user.getId();
        user.getName();
        user.getAge();
        return userList(user.getId(),user.getName(),user.getAge());

    }

    private List<User> userList(int id, String name, int age) {
        return new ArrayList<User>();
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
