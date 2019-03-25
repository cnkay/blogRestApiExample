package com.koleftiflabs.hackerinresidence.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class CommentDTO implements Serializable {
    private Long id;
    private String comment;
    public CommentDTO(String comment){
        this.comment=comment;
    }
}
