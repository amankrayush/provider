package com.Learning.learnapi.controller;

import com.Learning.learnapi.data.UserRepository;
import com.Learning.learnapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email) {

        User user = new User();
        user.setFirstname(name);
        user.setLastname(name);
        user.setEmail(email);

        userRepository.save(user);

        return user;
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody User addNewUser(@RequestBody User user) {

        userRepository.save(user);

        return user;
    }

    @GetMapping(path = "/getUser/{email}")
    public User getUserByEmail(@PathVariable String email) {

        Optional<User> user = userRepository.findByEmail(email);

        return user.orElse(null);
    }

    public @GetMapping(path = "/getUser")
    User getUser(@RequestParam String email) {

        Optional<User> user = userRepository.findByEmail(email);

        return user.orElse(null);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
