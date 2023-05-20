package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.User;
import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    void save(User user);

    List<User> findAll();

    void deleteById(int id);

    User getById(int id);

    void update(User user);
}
