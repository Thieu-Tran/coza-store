package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity,Integer> {
    CountryEntity findById(int id);
}
