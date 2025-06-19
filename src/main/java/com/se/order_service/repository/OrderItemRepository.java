package com.se.order_service.repository;

import com.se.order_service.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, String> {

    boolean existsByProductId(String id);
    Optional<OrderItemEntity> findByProductId(String id);
}
