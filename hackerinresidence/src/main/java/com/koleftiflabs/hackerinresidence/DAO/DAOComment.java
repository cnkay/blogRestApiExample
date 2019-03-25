package com.koleftiflabs.hackerinresidence.DAO;

import com.koleftiflabs.hackerinresidence.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DAOComment extends JpaRepository<Comment,Long> {
}
