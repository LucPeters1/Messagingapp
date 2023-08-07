package com.messagingapp.demo.messapeapp.User;

import com.messagingapp.demo.messapeapp.Post.*;
import jakarta.persistence.*;
import org.hibernate.annotations.JoinColumnOrFormula;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    @OneToMany
    private List<Post> postList = new ArrayList<>();
    @ManyToMany
    public List<User> friendsList = new ArrayList<>();
    public User(){

    }

    public User(Long id, String name, String email, String password, List<Post> postList, List<User> friendsList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.postList = postList;
        this.friendsList = friendsList;
    }

    public void setFriendsList(List<User> friendsList) {
        this.friendsList = friendsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
}

