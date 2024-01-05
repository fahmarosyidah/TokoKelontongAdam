/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paw.tokokelontongadam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paw.tokokelontongadam.entity.User;
import paw.tokokelontongadam.repo.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User user(String username, String password) {
        User user = repo.findByUsernameAndPassword(username, password);
        return user;
    }
    
//    public User getUserByUsername(String username) {
//        return repo.findByUsername(username);
//    }
    
    public User registerUser(User user) {
        try {
            return repo.save(user);
        } catch (Exception e) {
            // Log pengecualian untuk pemecahan masalah
            e.printStackTrace();
            throw e; 
        }
    }
}

