package com.catalog.usecases.UpdateStockProduct;

import com.catalog.common.abstractions.Result;
import com.catalog.dtos.OrderResponse;

public interface IUpdateStockProductUseCase {
    Result<String> execute(OrderResponse command);
}
