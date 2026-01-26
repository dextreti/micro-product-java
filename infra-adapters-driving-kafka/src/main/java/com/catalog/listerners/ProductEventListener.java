package com.catalog.listerners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.catalog.usecases.UpdateStockProduct.IUpdateStockProductUseCase;
import com.catalog.usecases.UpdateStockProduct.UpdateStockProductCommand;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductEventListener {

    //private final IUpdateStockProductUseCase updateStockUseCase;

    @KafkaListener(
            topics = "purchase-order-topic",
            groupId = "product-inventory-group"
    )
    public void listen(UpdateStockProductCommand eventJson) {

        log.info("Received Kafka message: {}", eventJson);
        try {

            //updateStockUseCase.execute(eventJson);

        } catch (Exception e) {
            log.error("Failed to process Kafka message", e);

        }

    }
}