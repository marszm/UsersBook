package com.example.demo.repositpry;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User create(User user);

    void deleteUser(User user);

    User findByIdOne(Long uid);
}
