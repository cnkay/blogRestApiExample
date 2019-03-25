package com.koleftiflabs.hackerinresidence.Service.Post;

import com.koleftiflabs.hackerinresidence.Controller.Exception.IdentityException;
import com.koleftiflabs.hackerinresidence.Controller.Exception.ResourceNotFoundException;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateCommentRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreatePostRequest;
import com.koleftiflabs.hackerinresidence.DAO.DAOComment;
import com.koleftiflabs.hackerinresidence.DAO.DAOPost;
import com.koleftiflabs.hackerinresidence.DTO.CommentDTO;
import com.koleftiflabs.hackerinresidence.DTO.PostDTO;
import com.koleftiflabs.hackerinresidence.DTO.UserDTO;
import com.koleftiflabs.hackerinresidence.Entity.Comment;
import com.koleftiflabs.hackerinresidence.Entity.Post;
import com.koleftiflabs.hackerinresidence.Entity.User;
import com.koleftiflabs.hackerinresidence.Service.Comment.CommentService;
import io.swagger.models.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

@Service
public class PostServiceImp implements PostService{
    //Edit Update
    @Autowired
    private DAOPost daoPost;

    @Autowired
    private DAOComment daoComment;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Post> getAllPosts() {
        return daoPost.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        if(isPostExist(id)){
            return daoPost.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Post updatePostById(Long id,CreatePostRequest request) {
        if(isPostExist(id)){
            Post post = convertToPostEntity(getPostDTOFromRequest(request));
            post.setPost_id(id);
            return daoPost.save(post);
        }
        return null;
    }

    @Override
    public void deletePostById(Long id) {
        if(isPostExist(id)){
            daoPost.deleteById(id);
        }
    }
    @Override
    public Post convertToPostEntity(PostDTO postDTO) {
        return modelMapper.map(postDTO, Post.class);
    }

    public PostDTO convertToPostDTO(Post post){
        return modelMapper.map(post, PostDTO.class);
    }
    @Override
    public PostDTO getPostDTOFromRequest(CreatePostRequest request){
        return new PostDTO(request.getTitle(),request.getContent());
    }
    private Boolean isPostExist(Long id){
        if(!daoPost.existsById(id)){
            throw new ResourceNotFoundException("Post with id "+id+" not found!");
        }
        return true;
    }


}
