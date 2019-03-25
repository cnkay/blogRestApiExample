package com.koleftiflabs.hackerinresidence.Service.User;

import com.koleftiflabs.hackerinresidence.Controller.Exception.IdentityException;
import com.koleftiflabs.hackerinresidence.Controller.Exception.ResourceNotFoundException;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateCommentRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreatePostRequest;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateUserRequest;
import com.koleftiflabs.hackerinresidence.DAO.DAOComment;
import com.koleftiflabs.hackerinresidence.DAO.DAOPost;
import com.koleftiflabs.hackerinresidence.DAO.DAOUser;
import com.koleftiflabs.hackerinresidence.DTO.UserDTO;
import com.koleftiflabs.hackerinresidence.Entity.Comment;
import com.koleftiflabs.hackerinresidence.Entity.Post;
import com.koleftiflabs.hackerinresidence.Entity.User;
import com.koleftiflabs.hackerinresidence.Service.Comment.CommentService;
import com.koleftiflabs.hackerinresidence.Service.Post.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private DAOPost daoPost;

    @Autowired
    private DAOComment daoComment;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private DAOUser daoUser;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<User> getAllUsers() {
        return daoUser.findAll();
    }

    @Override
    public User saveUser(CreateUserRequest request) {
        UserDTO userDTO=getUserDTOFromRequest(request);
        if(checkIdentity(userDTO)){
            String check="Username or Mail already exist!";
            throw new IdentityException(check);
        }

        try {
            return daoUser.save(convertToUserEntity(userDTO));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkIdentity(UserDTO userDTO){
        if(daoUser.findByUsername(userDTO.getUsername())!=null || daoUser.findByMail(userDTO.getMail())!=null){
            return true;
        }
        return false;
    }

    private User convertToUserEntity(UserDTO userDTO) throws ParseException {
        return modelMapper.map(userDTO, User.class);

    }

    private UserDTO convertToUserDTO(User user){
        return modelMapper.map(user, UserDTO.class);
    }
    private UserDTO getUserDTOFromRequest(CreateUserRequest request){
        return new UserDTO(request.getMail(),request.getUsername(),request.getPassword());
    }

    @Override
    public User getUserById(Long id) {
        return daoUser.findById(id).orElse(null);
    }

    @Override
    public User updateUserById(Long id, CreateUserRequest request) {
        if(daoUser.findById(id).isPresent()){
            try{
                User user = convertToUserEntity(getUserDTOFromRequest(request));
                user.setUser_id(id);
                return daoUser.save(user);
            }catch (ParseException ex){
                ex.printStackTrace();
            }
        }else {
            throw new ResourceNotFoundException("User with id "+id+" not found!");
        }
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        daoUser.deleteById(id);
    }

    @Override
    public List<Comment> getAllCommentsByUserId(Long id) {
        return daoUser.getAllCommentsByUserId(id);
    }


    @Override
    public List<Post> getAllPostsByUserId(Long id) {
        return daoUser.getAllPostsByUserId(id);
    }




    @Override
    public User savePost(Long id, CreatePostRequest request) {
        Post post = postService.convertToPostEntity(postService.getPostDTOFromRequest(request));
        User user = daoUser.findById(id).get();
        post.setUser(user);
        Post postWithId=daoPost.save(post);
        Set<Post> postSet=user.getPost();
        postSet.add(postWithId);
        user.setPost(postSet);
        return daoUser.save(user);
    }

    @Override
    public User saveComment(Long id, CreateCommentRequest request) {
        Comment comment = commentService.convertToCommentEntity(commentService.getCommentDTOFromRequest(request));
        User user = daoUser.findById(id).get();
        comment.setUser(user);
        Comment commentWithId = daoComment.save(comment);
        Set<Comment> commentSet = user.getComment();
        commentSet.add(commentWithId);
        user.setComment(commentSet);
        return daoUser.save(user);
    }
}
