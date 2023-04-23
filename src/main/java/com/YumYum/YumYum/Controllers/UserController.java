package com.YumYum.YumYum.Controllers;

import com.YumYum.YumYum.Models.User;

import com.YumYum.YumYum.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    // @PostMapping("/register")
    // public ResponseEntity<?> registerUser(@RequestBody User user) {
    //     if (userService.emailExists(user.getEmail())) {
    //         return ResponseEntity.badRequest().body("Email already exists");
    //     }
    //     User newUser = userService.registerUser(user);
    //     return ResponseEntity.ok(newUser);
    // }

     @PutMapping("/{password}")
     public ResponseEntity<User> updateUser(@RequestBody User user) {
         User updatedUser = userService.updateUser(user);
         return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
     }

    @GetMapping
    public ResponseEntity<List<User>> getallUsers(){
        return new ResponseEntity<List<User>>(userService.findallUsers(), HttpStatus.OK);
    }

    @GetMapping("/{password}")//{email}
    public ResponseEntity<Optional<User>> getSingleUser(@PathVariable String password) {
        //User user = userService.getUserByEmail(email);
        return new ResponseEntity<Optional<User>>(userService.findUserByEmail(password), HttpStatus.OK);
    }

    // @DeleteMapping("/{_id}")
    // public ResponseEntity<Void> deleteUser(@RequestBody User user) {
    //     userService.deleteUser(user);
    //     return new ResponseEntity<Void>(HttpStatus.OK);
    // }
}
