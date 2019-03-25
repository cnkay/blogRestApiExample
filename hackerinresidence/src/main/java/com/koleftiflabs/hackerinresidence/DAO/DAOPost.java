package com.koleftiflabs.hackerinresidence.DAO;

import com.koleftiflabs.hackerinresidence.Entity.Post;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DAOPost extends JpaRepository<Post,Long> {
    Post findByTitle(String title);
}
