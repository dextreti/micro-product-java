package com.catalog.feignClient;

import com.catalog.dtos.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "order-service", url = "${order.service.url}")
public interface IOrderFeignClient {

    @GetMapping("/api/orders/{id}")
    OrderResponse getOrderById(@PathVariable("id") String id);

}
