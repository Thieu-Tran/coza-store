package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByCategoryId(int idCategory);
    ProductEntity findById(int id);
}
