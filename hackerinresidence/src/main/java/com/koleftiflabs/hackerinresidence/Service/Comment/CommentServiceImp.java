package com.koleftiflabs.hackerinresidence.Service.Comment;

import com.koleftiflabs.hackerinresidence.Controller.Exception.ResourceNotFoundException;
import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateCommentRequest;
import com.koleftiflabs.hackerinresidence.DAO.DAOComment;
import com.koleftiflabs.hackerinresidence.DTO.CommentDTO;
import com.koleftiflabs.hackerinresidence.Entity.Comment;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
@Service
public class CommentServiceImp implements CommentService{

    @Autowired
    private DAOComment daoComment;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Comment> getAllComments() {
        return daoComment.findAll();
    }

    @Override
    public Comment getCommentById(Long id) {
        if(isCommentExist(id)){
            return daoComment.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Comment updateCommentById(Long id) {
        return null;
    }

    @Override
    public void deleteCommentById(Long id) {
        if(isCommentExist(id)){
            daoComment.deleteById(id);
        }
    }

    private Boolean isCommentExist(Long id){
        if(!daoComment.existsById(id)){
            throw new ResourceNotFoundException("Comment with id "+id+" not found!");
        }
        return true;
    }

    @Override
    public CommentDTO getCommentDTOFromRequest(CreateCommentRequest request) {
        return new CommentDTO(request.getComment());
    }

    @Override
    public Comment convertToCommentEntity(CommentDTO commentDTO) {
        return modelMapper.map(commentDTO, Comment.class);
    }

    @Override
    public CommentDTO convertToCommentDTO(Comment comment) {
        return modelMapper.map(comment,CommentDTO.class);
    }
}
