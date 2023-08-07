package com.messagingapp.demo.messapeapp.User;

import com.messagingapp.demo.messapeapp.Post.Post;
import com.messagingapp.demo.messapeapp.Post.PostRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository,
                       PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.getReferenceById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void updateUser(Long id, UpdatedUserDTO updatedUserDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This userId does not exist in the repository"));

        existingUser.setName(updatedUserDTO.getName());
        existingUser.setPassword(updatedUserDTO.getPassword());
        existingUser.setPostList(updatedUserDTO.getPostList());
        existingUser.setEmail(updatedUserDTO.getEmail());
        existingUser.setFriendsList(updatedUserDTO.getFriendsList());

        userRepository.save(existingUser);
    }

    public void addFriend(Long userId, Long friendId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Cannot find the userId"));
        User friend = userRepository.findById(friendId).orElseThrow(() -> new IllegalArgumentException("Cannot find friendId"));
        List<User> friendsList = user.getFriendsList();
        friendsList.add(friend);
        userRepository.save(user);
    }

    public void deleteFriend(Long userId, User friend) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Cannot find the userId"));
        List<User> friendsList = user.getFriendsList();
        friendsList.remove(friend);
        userRepository.save(user);
    }

}