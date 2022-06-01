package ru.sk.millionaire.service;

import org.springframework.stereotype.Service;
import ru.sk.millionaire.model.User;

import java.util.List;

public interface UserService {

    List<User> index();

    void save (User user);

    void insert(User user);

    void update(int id, User updatedUser);

    void delete(int id);

    User show(int id);

    User findByUsername(String username);
}
