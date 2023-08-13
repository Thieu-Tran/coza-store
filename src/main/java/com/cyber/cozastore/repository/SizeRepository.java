package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity,Integer> {
    @Query(value = "SELECT * FROM size s, product p WHERE p.name =?1 AND p.size_id = s.id",nativeQuery = true)
    List<SizeEntity> getSizeByProductName(String name);
}
