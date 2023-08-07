package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.Post.PostRepository;
import com.messagingapp.demo.messapeapp.Post.PostService;
import com.messagingapp.demo.messapeapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    public CommentController(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/{id}/comment")
    public void addCommentToPost(@PathVariable Long id, CommentDTO commentDTO){
        commentService.addCommentToPost(id, commentDTO);
    }

}
