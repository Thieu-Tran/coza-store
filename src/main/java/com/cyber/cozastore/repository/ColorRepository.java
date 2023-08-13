package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity,Integer> {

    @Query(value = "SELECT * FROM color c, product p WHERE p.name =?1 AND p.color_id =c.id",nativeQuery = true)
    List<ColorEntity> getColorByProductName(String name);
}
