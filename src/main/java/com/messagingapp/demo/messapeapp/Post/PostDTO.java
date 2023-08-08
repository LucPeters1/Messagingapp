package com.messagingapp.demo.messapeapp.Post;

import com.messagingapp.demo.messapeapp.Comment.Comment;
import com.messagingapp.demo.messapeapp.User.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
    private long authorId;
    private String content;

    public long getAuthorId() {
        return authorId;
    }

    public PostDTO(){

    }
    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
