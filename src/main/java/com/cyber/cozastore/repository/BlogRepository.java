package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer> {
    BlogEntity findById(int id);
}
