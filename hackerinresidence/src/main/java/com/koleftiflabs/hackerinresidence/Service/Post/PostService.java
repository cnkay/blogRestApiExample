package com.koleftiflabs.hackerinresidence.Service.Post;

import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreatePostRequest;
import com.koleftiflabs.hackerinresidence.DTO.PostDTO;
import com.koleftiflabs.hackerinresidence.Entity.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post updatePostById(Long id,CreatePostRequest request);
    void deletePostById(Long id);
    PostDTO getPostDTOFromRequest(CreatePostRequest request);
    Post convertToPostEntity(PostDTO postDTO);
}
