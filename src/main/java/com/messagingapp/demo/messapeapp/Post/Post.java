package com.messagingapp.demo.messapeapp.Post;


import com.messagingapp.demo.messapeapp.Comment.*;
import com.messagingapp.demo.messapeapp.User.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;

    private String content;

    private LocalDateTime datePosted;

    @ManyToOne
    private User author;

    //This arraylist keeps track of all the comments on a post
    @OneToMany(cascade = CascadeType.ALL) // One post can have many comments
    public List<Comment> comments = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

}
