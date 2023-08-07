package com.messagingapp.demo.messapeapp.Post;

import com.messagingapp.demo.messapeapp.User.UpdatedUserDTO;
import com.messagingapp.demo.messapeapp.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {



    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/createpost")
    public void createPost(@RequestBody PostDTO postDTO){
        postService.createPost(postDTO);

    }

}
