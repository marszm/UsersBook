package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserService extends CrudRepository<User, Integer> {
}
