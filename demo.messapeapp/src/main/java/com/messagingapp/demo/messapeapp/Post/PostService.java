package com.messagingapp.demo.messapeapp.Post;

import com.messagingapp.demo.messapeapp.Comment.CommentRepository;
import com.messagingapp.demo.messapeapp.User.UpdatedUserDTO;
import com.messagingapp.demo.messapeapp.User.User;
import com.messagingapp.demo.messapeapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public void createPost(PostDTO postDTO) {
        User author = userRepository.findById(postDTO.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Post post = new Post();
        post.setContent(postDTO.getContent());
        post.setAuthor(author);
        post.setDatePosted(LocalDateTime.now());

        postRepository.save(post);
    }

}
