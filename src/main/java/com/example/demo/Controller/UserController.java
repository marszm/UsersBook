package com.example.demo.Controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/company")
public class UserController {

    @Autowired
    UserService userService;

    //save user
    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user){
        return userService.save(user);

    }

    //get all users
    @GetMapping("/userall")
    Iterable<User> read(){
        return userService.findAll();
    }

    //update
    @PutMapping("/update")
    User update(@RequestBody User user){
        return userService.save(user);
    }

    //delete by id
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id){
        userService.deleteById(id);
    }

}
