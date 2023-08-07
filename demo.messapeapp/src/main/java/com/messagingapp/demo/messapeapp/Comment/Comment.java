package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.Post.*;
import com.messagingapp.demo.messapeapp.User.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long id;

    private String content;
    private LocalDateTime datePosted;
    @ManyToOne
    private User author;

    public Comment(){

    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post post(){
        return null;
    }


    public Comment(long id, String content, LocalDateTime datePosted, User author) {
        this.id = id;
        this.content = content;
        this.datePosted = datePosted;
        this.author = author;
    }


}
