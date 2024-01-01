package com.self.service;

import com.self.dao.UserRepo;
import com.self.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
   private UserRepo userRepo;

    public User creteUser(User user){
        return userRepo.save(user);
    }

    public List<User> creteUsers(List<User> users){
        return userRepo.saveAll(users);
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User updateUser(User user){
        User oldUser = null;
        Optional<User> optionalUser = userRepo.findById(user.getId());
        if (optionalUser.isPresent()){
             oldUser = optionalUser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            userRepo.save(oldUser);
        }else {
            return new User();
        }
        return oldUser;
    }

    public String deleteUserById(Long id){
         userRepo.deleteById(id);
         return "user got deleted";
    }
}
