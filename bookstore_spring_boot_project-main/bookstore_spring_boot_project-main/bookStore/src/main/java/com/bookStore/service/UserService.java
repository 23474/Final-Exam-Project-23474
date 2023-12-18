package com.bookStore.service;

import com.bookStore.entity.User;
import com.bookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public void save(User user){

        repo.save(user);
    }

    public User findUserByPassword(String password) {
        Optional<User> optionalUser = repo.findByPassword(password);
        return optionalUser.orElse(null);
    }
}
