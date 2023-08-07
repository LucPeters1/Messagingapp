package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.User.User;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class CommentDTO {
    private long id;
    private String content;
    private LocalDateTime datePosted;
    private User author;

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
}
