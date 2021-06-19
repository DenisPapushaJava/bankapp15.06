package com.example.bankapp.service;

import com.example.bankapp.models.User;
import com.example.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id) {
        return getUser(id);
    }

    public void blockUser(Long id) {
        User user = getUser(id);
        user.setAvalible(false);
        userRepository.save(user);
    }

    private User getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return user;
    }

    public void changePassword(Long id, String password) {
        User user = getUser(id);
        user.setPassword(password);
        userRepository.save(user);


    }

    public void deleteUser(Long id) {
        userRepository.delete(getUser(id));
    }

}
