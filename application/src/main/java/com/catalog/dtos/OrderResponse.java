package com.catalog.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID customerId,
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]X")
        OffsetDateTime createdAt,
        BigDecimal totalAmount,
        String purchaseOrderStatus,
        List<OrderItemResponse> purchaseOrderItems
) {
}
