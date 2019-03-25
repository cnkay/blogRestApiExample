package com.koleftiflabs.hackerinresidence.Controller;

import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreatePostRequest;
import com.koleftiflabs.hackerinresidence.Entity.Post;
import com.koleftiflabs.hackerinresidence.Service.Post.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping(value = "/{id}")
    public Post getPostById(@PathVariable(value = "id") Long id){
        return postService.getPostById(id);
    }

    @PutMapping(value = "/{id}")
    public Post updatePostById(@PathVariable(value = "id") Long id,@RequestBody CreatePostRequest request){
        return postService.updatePostById(id,request);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePostById(@PathVariable(value = "id") Long id){
        postService.deletePostById(id);
    }
}
