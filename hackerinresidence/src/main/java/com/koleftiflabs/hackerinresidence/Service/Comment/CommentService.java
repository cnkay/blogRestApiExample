package com.koleftiflabs.hackerinresidence.Service.Comment;

import com.koleftiflabs.hackerinresidence.Controller.RequestBody.CreateCommentRequest;
import com.koleftiflabs.hackerinresidence.DTO.CommentDTO;
import com.koleftiflabs.hackerinresidence.Entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    Comment updateCommentById(Long id);
    void deleteCommentById(Long id);
    CommentDTO getCommentDTOFromRequest(CreateCommentRequest request);
    Comment convertToCommentEntity(CommentDTO commentDTO);
    CommentDTO convertToCommentDTO(Comment comment);
}
