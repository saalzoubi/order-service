package com.se.order_service.entity;

import com.se.order_service.dto.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "order_item")
@Table(name = "order_item")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class OrderItemEntity {
    @Id
    private String id;
    @Column(name = "product_id",nullable = false)
    private String productId;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @Column(name = "total_price",nullable = false)
    private double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private OrderEntity order;


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
