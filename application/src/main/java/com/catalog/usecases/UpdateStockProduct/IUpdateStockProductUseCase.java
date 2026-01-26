package com.catalog.usecases.UpdateStockProduct;

import com.catalog.common.abstractions.Result;

public interface IUpdateStockProductUseCase {
    Result<String> execute(UpdateStockProductCommand command);
}
