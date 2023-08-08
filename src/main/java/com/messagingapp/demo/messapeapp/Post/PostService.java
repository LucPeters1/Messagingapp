package com.messagingapp.demo.messapeapp.Post;

import com.messagingapp.demo.messapeapp.User.User;
import com.messagingapp.demo.messapeapp.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void createPost(PostDTO postDTO) {
        User author = userRepository.findById(postDTO.getAuthorId()) //makes a userobject of the author of the post
                .orElseThrow(() -> new IllegalArgumentException("Author not found"));

        Post post = new Post(); // make a new post
        post.setContent(postDTO.getContent()); //set the content of the post
        post.setAuthor(author);
        post.setDatePosted(LocalDateTime.now());

        postRepository.save(post); // save the post to the db
    }

}
