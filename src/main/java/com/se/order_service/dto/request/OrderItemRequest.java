package com.se.order_service.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class OrderItemRequest {

    @NotBlank(message = "Product Id is mandatory")
    private String productId;

    @NotNull(message = "Quantity is mandatory")
    @Min(value = 0, message = "Quantity min value is 0")
    @Max(value = 10, message = "Quantity max value is 10")
    private Integer quantity;

}

