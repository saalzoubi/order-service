package com.se.order_service.repository;

import com.se.order_service.dto.enums.OrderStatus;
import com.se.order_service.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {

    boolean existsByUserIdAndStatusIn(String id, List<OrderStatus> status);
    Optional<OrderEntity> findByUserIdAndStatusIn(String id, List<OrderStatus> status);
}
