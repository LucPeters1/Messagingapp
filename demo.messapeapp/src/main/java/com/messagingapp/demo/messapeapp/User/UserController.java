package com.messagingapp.demo.messapeapp.User;

import com.messagingapp.demo.messapeapp.Post.Post;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void addUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getPostList(), userDTO.getFriendsList());
        userService.createUser(user);
    }

    @GetMapping("/userlist")
    public List<User> getUsersList() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteuser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/updateuser/{id}")
    public void updateUserById(@PathVariable Long id, UpdatedUserDTO updatedUserDTO) {
        userService.updateUser(id, updatedUserDTO);
    }

    @PutMapping("/deleteUserById/{id}")
    public void deleteFriendById(@PathVariable Long id, @RequestBody User friend) {
        userService.deleteFriend(id, friend);
    }

    @PostMapping("/addfriend/{id}")
    public void addFriendById(@PathVariable Long id, Long friendId) {
        userService.addFriend(id, friendId);
    }



}
