package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.Post.PostRepository;
import com.messagingapp.demo.messapeapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;
    public CommentController( UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @PostMapping("/{id}/comment")
    public void addCommentToPost(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
        commentService.addCommentToPost(id, commentDTO);
    }

    @DeleteMapping("/post/{postId}/comment/{commentId}")
    public void deleteCommentFromPost(@PathVariable Long postId, @PathVariable Long commentId){
        commentService.deleteCommentFromPost(postId,commentId);
    }
}
