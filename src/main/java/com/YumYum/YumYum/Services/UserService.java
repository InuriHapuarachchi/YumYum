package com.YumYum.YumYum.Services;

import com.YumYum.YumYum.Models.User;
import com.YumYum.YumYum.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<User> findallUsers(){
        return repository.findAll();
    }
    public Optional<User> findUserByEmail(String password){
        return repository.findUserByEmail(password);
    }
    // public User getUserByEmail(String email) {
    //     return null;
    // }

    // public void deleteUser(User user) {
    // }

     public User updateUser(User user) {
         return repository.save(user);
     }

     public User createUser(User user) {
         repository.save(user);
         return user;
     }

    // public User registerUser(User user) {
    //     String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    //     user.setPassword(encodedPassword);
    //     return repository.save(user);
    // }

    // public boolean emailExists(String email) {
    //     return repository.findUserByEmail(email) != null;
    // }
}
