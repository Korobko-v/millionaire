package ru.sk.millionaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sk.millionaire.model.User;
import ru.sk.millionaire.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public List<User> index() {
        return userRepository.findAll();
    }

    @Transactional
    public void save (User user) {
        userRepository.save(user);
    }

    @Transactional
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        User toUpdate = show(id);
        toUpdate.setUsername(updatedUser.getUsername());
        toUpdate.setRole(updatedUser.getRole());
        toUpdate.setStatus(updatedUser.getStatus());
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public User show(int id) {
        return userRepository.getById(id);
    }

    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
}
