package com.koleftiflabs.hackerinresidence.Controller;

import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateCommentRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreatePostRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateUserRequest;
import com.koleftiflabs.hackerinresidence.DTO.UserDTO;
import com.koleftiflabs.hackerinresidence.Entity.Comment;
import com.koleftiflabs.hackerinresidence.Entity.Post;
import com.koleftiflabs.hackerinresidence.Entity.User;
import com.koleftiflabs.hackerinresidence.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.saveUser(createUserRequest);
    }

    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping(value = "/{id}")
    public User updateUserById(@PathVariable(value = "id") Long id,@RequestBody CreateUserRequest request){
        return userService.updateUserById(id,request);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUserById(@PathVariable(value = "id") Long id){
        userService.deleteUserById(id);
    }

    @GetMapping(value = "/{id}/comments")
    public List<Comment> getAllCommentsByUserId(@PathVariable(value = "id") Long id){
        return userService.getAllCommentsByUserId(id);
    }

    @GetMapping(value = "/{id}/posts")
    public List<Post> getAllPostsByUserId(@PathVariable Long id){
        return userService.getAllPostsByUserId(id);
    }


    //Create Post /w User
    //Create Comment /w User

    @PostMapping(value = "/{id}/posts")
    public User savePost(@PathVariable(value = "id") Long id, @RequestBody CreatePostRequest postRequest){
        return userService.savePost(id,postRequest);
    }
    @PostMapping(value = "/{id}/comments")
    public User saveComment(@PathVariable(value = "id") Long id, @RequestBody CreateCommentRequest commentRequest){
        return userService.saveComment(id,commentRequest);
    }

}
