package com.catalog.usecases.updateproduct;

import com.catalog.common.abstractions.Result;


public interface IUpdateProductUseCase {
    Result<String> execute(UpdateProductCommand command, String id);

}
