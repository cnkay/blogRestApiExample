package com.koleftiflabs.hackerinresidence.Controller.RequestBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreatePostRequest {
    private String title;
    private String content;

}
