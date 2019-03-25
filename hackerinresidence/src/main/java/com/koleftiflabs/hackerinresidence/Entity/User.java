package com.koleftiflabs.hackerinresidence.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "user_id"),
        @UniqueConstraint(columnNames = "mail")
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",unique = true,nullable = false)
    private Long user_id;

    @NotNull
    @Column(name = "mail",unique = true,nullable = false)
    private String mail;

    @NotNull
    @Column(name = "username",unique = true,nullable = false)
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @JsonManagedReference
    @OneToMany(targetEntity = Post.class,mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> post=new HashSet<Post>();
    @JsonManagedReference
    @OneToMany(targetEntity = Comment.class,mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Comment> comment=new HashSet<Comment>();

}
