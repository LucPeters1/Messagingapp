package com.messagingapp.demo.messapeapp.User;

import com.messagingapp.demo.messapeapp.Post.Post;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public class UserDTO {
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Post> postList;
    public List<User> friendsList;
    public UserDTO(){

    }

    public UserDTO(Long id, String name, String email, String password, List<Post> postList, List<User> friendsList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = postList;
        this.friendsList = friendsList;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<User> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
        this.friendsList = friendsList;
    }

}
