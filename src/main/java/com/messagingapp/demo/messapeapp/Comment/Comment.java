package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.Post.*;
import com.messagingapp.demo.messapeapp.User.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Comment {

    @Id //Change to UUID --> CREATE THESE ON THE CONSTRUCTOR
    @GeneratedValue
    private long id;

    @ManyToOne //Each comment is associated with a single post
    @JoinColumn(name = "post_id") // post_id holds the foreign key to the post table
    private Post post;
    private String content;
    private LocalDateTime datePosted;
    @ManyToOne // each comment is associated with a single user
    // the user_id column in the Comment table holds the foreign key to the User table
    @JoinColumn(name = "user_id") //foreign key
    private User author;

    @ManyToOne
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> childComments = new ArrayList<>();

    public Comment() {

    }

    public Comment(long id, String content, LocalDateTime datePosted, User author) {
        this.id = id;
        this.content = content;
        this.datePosted = datePosted;
        this.author = author;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post post() {
        return null;
    }

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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
