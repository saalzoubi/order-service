package com.se.order_service.dto.request;

import lombok.*;

import jakarta.validation.constraints.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AddOrderRequest {

    @NotEmpty(message = "Order Items List is mandatory")
    private List<OrderItemRequest> orderItemList;

    @NotBlank(message = "User Id is mandatory")
    private String userId;
}

