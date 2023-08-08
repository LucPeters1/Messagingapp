package com.messagingapp.demo.messapeapp.Comment;

import com.messagingapp.demo.messapeapp.Post.Post;
import com.messagingapp.demo.messapeapp.Post.PostRepository;
import com.messagingapp.demo.messapeapp.User.User;
import com.messagingapp.demo.messapeapp.User.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private UserRepository userRepository;

    public CommentService(PostRepository postRepository,
                          UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    public void addCommentToPost(@PathVariable Long id, @RequestBody CommentDTO commentDTO) {

        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This post with the given id does not exist")); //fetch post from db
        User author = userRepository.findById(commentDTO.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("Author not found")); //fetch author from db
        Comment comment = new Comment(); //create new comment object
        comment.setContent(commentDTO.getContent()); // and sets the content from the DTO
        comment.setAuthor(author); // --> Sets the  comment's author to the commenter's User objects
        comment.setDatePosted(LocalDateTime.now());

        comment.setPost(post); // sets the comment to the comment list on the post object
//        comment = commentRepository.save(comment); // Deprecated
        post.getComments().add(comment); // Retrieves comment list from the post and adds the comment to the list

        postRepository.save(post); // post gets saved back to the db

    }


    // /post/{id}/comment
    public void deleteCommentFromPost(Long postId, Long commentId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Cannot find the post with the corresponding postId")); //finds the post that needs to have a comment deleted
        Comment removeComment = null; // placeholder for the comment that needs to be removed

        for (Comment comment : post.getComments()){ //loops through the comment list associated to the post
            if (comment.getId() == commentId){ //if the comment list contains an id that matches the commendId that is passed in
                removeComment = comment; // sets that comment to be the removeComment
                break; // break out of the loop once it found the matching comment
            }
        }

        post.getComments().remove(removeComment); // remove the comment from the comments list from the post object
        postRepository.save(post); // save the object back to the db
    }

}
