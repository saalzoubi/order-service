package com.se.order_service.entity;

import com.se.order_service.dto.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "app_order")
@Table(name = "app_order")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class OrderEntity {
    @Id
    private String id;
    @Column(name = "user_id",nullable = false)
    private String userId;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private double tax;
    @Column(nullable = false)
    private int discount;
    @Column(name = "total_price",nullable = false)
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private OrderStatus status;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "order")
    private List<OrderItemEntity> orderItemEntities;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID().toString();
    }
}
