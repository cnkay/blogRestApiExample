package com.koleftiflabs.hackerinresidence.Service.User;

import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateCommentRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreatePostRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateUserRequest;
import com.koleftiflabs.hackerinresidence.DTO.UserDTO;
import com.koleftiflabs.hackerinresidence.Entity.Comment;
import com.koleftiflabs.hackerinresidence.Entity.Post;
import com.koleftiflabs.hackerinresidence.Entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(CreateUserRequest request);
    User getUserById(Long id);
    User updateUserById(Long id, CreateUserRequest request);
    void deleteUserById(Long id);
    List<Comment> getAllCommentsByUserId(Long id);
    List<Post> getAllPostsByUserId(Long id);
    User savePost(Long id, CreatePostRequest request);
    User saveComment(Long id, CreateCommentRequest request);
}
