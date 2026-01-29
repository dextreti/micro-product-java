package com.catalog.listerners;

import com.catalog.dtos.OrderResponse;
import com.catalog.feignClient.IOrderFeignClient;
import com.catalog.requests.UpdateStockProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.catalog.usecases.UpdateStockProduct.IUpdateStockProductUseCase;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductEventListener {

    private final IUpdateStockProductUseCase updateStockUseCase;
    private final IOrderFeignClient orderFeignClient;

    @KafkaListener(
            topics = "purchase-order-topic",
            groupId = "product-inventory-group"
    )
    public void listen(UpdateStockProductRequest request) {

        log.info("Kafka Event received for Order: {}", request.orderId());

        try {

            OrderResponse orderData = orderFeignClient.getOrderById(request.orderId());
            var resp = updateStockUseCase.execute(orderData);
            if (resp.isSuccess()) {
                log.info("Order {} processed successfully in Catalog Service", request.orderId());
            } else {
                log.warn("Order {} rejected: {}", request.orderId(), resp.getError());
            }

        } catch (Exception e) {
            log.error("Technical error processing Order {}", request.orderId(), e);
            throw e;
        }

    }
}


//public record OrderStockResultMessage(
//        UUID orderId,
//        String status,      // "APPROVED" o "REJECTED"
//        String reason,      // "INSUFFICIENT_STOCK", "PRODUCT_NOT_FOUND", etc.
//        OffsetDateTime processedAt
//) {}