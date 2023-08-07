package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.Post.Post;
import com.messagingapp.demo.messapeapp.Post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,
                          PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public void addCommentToPost(Long id, CommentDTO commentDTO) {
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This post with the given id does not exist"));
        Comment comment = new Comment(commentDTO.getId(), commentDTO.getContent(), commentDTO.getDatePosted(), commentDTO.getAuthor());
        commentRepository.save(comment);
    }
}
