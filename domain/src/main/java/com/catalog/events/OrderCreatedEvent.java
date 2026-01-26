package com.catalog.events;

public record OrderCreatedEvent(
        String orderId,
        String productId,
        int quantity
){}
