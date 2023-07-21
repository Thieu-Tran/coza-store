package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<SizeEntity,Integer> {

}
