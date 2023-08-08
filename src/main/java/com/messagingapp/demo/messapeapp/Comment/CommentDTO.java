package com.messagingapp.demo.messapeapp.Comment;

public class CommentDTO {
    private long id;
    private String content;
    private Long authorId;

    public CommentDTO( String content,  Long authorId) {
        this.content = content;
        this.authorId = authorId;

    }

    public Long getAuthorId() {
        return authorId;
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

}
