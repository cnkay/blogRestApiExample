package com.koleftiflabs.hackerinresidence.Controller.RequestBody;

import com.koleftiflabs.hackerinresidence.Entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserRequest {
    private String mail;
    private String username;
    private String password;

}
