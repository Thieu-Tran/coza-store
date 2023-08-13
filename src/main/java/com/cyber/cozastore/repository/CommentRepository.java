package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.CommentEntity;
import com.cyber.cozastore.payload.response.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity,Integer> {
    List<CommentEntity> findByBlogId(int id);
}
