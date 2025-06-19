package com.se.order_service.service;

import com.se.order_service.dto.enums.OrderStatus;
import com.se.order_service.dto.request.AddOrderRequest;
import com.se.order_service.entity.OrderEntity;
import com.se.order_service.entity.OrderItemEntity;
import com.se.order_service.exception.OrderServiceException;
import com.se.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void addOrder(AddOrderRequest request) {
        boolean exists = orderRepository.existsByUserIdAndStatusIn(request.getUserId(), List.of(OrderStatus.CREATED, OrderStatus.PAYMENT_PROCESSING));
        if (exists) {
            throw new OrderServiceException("Order already In processing");
        }
        List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
        request.getOrderItemList().forEach(orderItem -> {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setQuantity(orderItem.getQuantity());
            orderItemEntity.setPrice(orderItemEntity.getPrice());
            orderItemEntity.setTotalPrice(orderItem.getQuantity() * orderItemEntity.getPrice());
            orderItemEntity.setProductId(orderItem.getProductId());
            orderItemEntityList.add(orderItemEntity);
        });

        double totalPrice = orderItemEntityList.stream().mapToDouble(OrderItemEntity::getTotalPrice).sum();
        OrderEntity order = new OrderEntity();
        order.setUserId(request.getUserId());
        order.setTax(0.15);
        order.setDiscount(0);
        order.setStatus(OrderStatus.CREATED);
        order.setOrderItemEntities(orderItemEntityList);
        order.setPrice(totalPrice);
        order.setTotalPrice(
                order.getTotalPrice()
                        - (order.getTotalPrice() * order.getDiscount())
                        +(order.getTotalPrice() * order.getTax()));


        orderRepository.save(order);
    }
}
