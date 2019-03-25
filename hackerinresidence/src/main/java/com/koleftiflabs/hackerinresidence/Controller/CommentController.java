package com.koleftiflabs.hackerinresidence.Controller;

import com.koleftiflabs.hackerinresidence.Entity.Comment;
import com.koleftiflabs.hackerinresidence.Service.Comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping(value = "/{id}")
    public Comment getCommentById(@PathVariable(value = "id") Long id){
        return commentService.getCommentById(id);

    }

    @PutMapping(value = "/{id}")
    public Comment updateCommentById(@PathVariable(value = "id") Long id){
        return commentService.updateCommentById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCommentById(@PathVariable(value = "id") Long id){
        commentService.deleteCommentById(id);
    }
}
