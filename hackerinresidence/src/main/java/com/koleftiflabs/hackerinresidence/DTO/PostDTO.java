package com.koleftiflabs.hackerinresidence.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO implements Serializable {
    private Long id;
    private String title;
    private String content;
    public PostDTO(String title,String content){
        this.title=title;
        this.content=content;
    }
}
