package com.se.order_service.controller;

import com.se.order_service.dto.request.AddOrderRequest;
import com.se.order_service.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {
    private final OrderService orderService;


    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@Valid @RequestBody AddOrderRequest request) {
        orderService.addOrder(request);
        return ResponseEntity.ok().build();
    }


}