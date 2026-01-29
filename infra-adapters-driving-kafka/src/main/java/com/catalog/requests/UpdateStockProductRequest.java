package com.catalog.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UpdateStockProductRequest(
        @JsonProperty("orderId") String orderId
) {
}
