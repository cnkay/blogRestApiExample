package com.koleftiflabs.hackerinresidence.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    private Long id;
    private String mail;
    private String username;
    private String password;
    public UserDTO(String mail,String username,String password){
        this.mail=mail;
        this.username=username;
        this.password=password;
    }
}
