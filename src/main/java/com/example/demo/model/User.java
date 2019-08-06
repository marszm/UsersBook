package com.example.demo.model;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
public class User {


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @NotBlank
    private String name;
//    @NotBlank
    private int age;


//    public List<User> getUserList() {
//        return userList;
//    }

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
