package com.cyber.cozastore.repository;

import com.cyber.cozastore.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    @Query(value = "SELECT * FROM orders o WHERE user_id =?1 ORDER BY id DESC LIMIT 1",nativeQuery = true)
    OrderEntity getLastOrderByUserId(int id);
}
