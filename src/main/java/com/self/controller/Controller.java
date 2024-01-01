package com.self.controller;

import com.self.entity.User;
import com.self.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return service.creteUser(user);
    }

    @PostMapping("/addUsers")
    public List<User> addUsers(@RequestBody List<User> users){
        return service.creteUsers(users);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @GetMapping("/getUsers")
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@PathVariable Long id){
        return service.deleteUserById(id);
    }

}
