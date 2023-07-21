package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.BannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<BannerEntity,Integer> {

}
