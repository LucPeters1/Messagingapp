package com.messagingapp.demo.messapeapp.User;

import com.messagingapp.demo.messapeapp.Post.Post;
import com.messagingapp.demo.messapeapp.Post.PostRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserService(UserRepository userRepository,
                       PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }
//    Takes a User object as a param and saves to db
    public void createUser(User user) {
        userRepository.save(user);
    }
//    Takes the id of the user to be deleted as a param and deletes usr from db
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
//    Takes user from db based on the id of the user
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This userId does not exist in the repository"));
    }
//    finds all in the user repo and returns it as a list
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
//    updates the user info with a DTO object for https safety
//    gets all values from the DTO and sets them in the existing user
//    then saves the user back to the user repository
    public void updateUser(Long id, UpdatedUserDTO updatedUserDTO) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This userId does not exist in the repository"));

        existingUser.setName(updatedUserDTO.getName());
        existingUser.setPassword(updatedUserDTO.getPassword());
        existingUser.setPostList(updatedUserDTO.getPostList());
        existingUser.setEmail(updatedUserDTO.getEmail());
        existingUser.setFriendsList(updatedUserDTO.getFriendsList());

        userRepository.save(existingUser);
    }
//    Fetches the user from the database by userId
//    Fetches the friend from the database by friendId
//    Gets the current list of friends (friendsList) of the user
//    Adds the friend object to the list of friends
//    UserRepository.save pushes the updated user back to the database

    public void addFriend(Long userId, Long friendId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Cannot find the userId"));
        User friend = userRepository.findById(friendId).orElseThrow(() -> new IllegalArgumentException("Cannot find friendId"));
        List<User> friendsList = user.getFriendsList();
        friendsList.add(friend);
        userRepository.save(user);
    }
//    Fetch the user from the database using the provided userId
//    Get the current list of friends of the user
//    Remove the User object representing the friend to be deleted from the list of friends
//    Persist the updated user entity back to the database by calling userRepository.save(user)
    public void deleteFriend(Long userId, User friend) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Cannot find the userId"));
        List<User> friendsList = user.getFriendsList();
        friendsList.remove(friend);
        userRepository.save(user);
    }

    public void deleteAllUsersFromDb(){
        userRepository.deleteAll();
    }

}