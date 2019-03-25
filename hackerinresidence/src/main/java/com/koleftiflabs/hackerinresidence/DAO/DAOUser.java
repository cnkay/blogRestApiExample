package com.koleftiflabs.hackerinresidence.DAO;

import com.koleftiflabs.hackerinresidence.Entity.Comment;
import com.koleftiflabs.hackerinresidence.Entity.Post;
import com.koleftiflabs.hackerinresidence.Entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface DAOUser extends JpaRepository<User,Long> {
    //JPQL
    @Query("select u.comment from User u where u.user_id=:id")
    List<Comment> getAllCommentsByUserId(@Param("id") Long id);

    @Query("select u.post from User u where u.user_id=:id")
    List<Post> getAllPostsByUserId(@Param("id") Long id);

    User findByUsername(String username);

    User findByMail(String mail);

}
