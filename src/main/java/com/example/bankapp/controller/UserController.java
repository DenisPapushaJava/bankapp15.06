package com.example.bankapp.controller;

import com.example.bankapp.models.User;
import com.example.bankapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable("id") Long id) {
        return userService.getUserById(id);

    }
    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getListUsers();
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @PostMapping("/block/{id}")
    public void blockUser(@PathVariable("id") Long id) {
        userService.blockUser(id);
    }

    @PostMapping("/close/{id}")
    public void closeUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/change")
    public void changePassword(@RequestBody User user) {
        userService.changePassword(user.getId(), user.getPassword());
    }


}
