package com.catalog.usecases.createproduct;

import com.catalog.common.abstractions.Result;

public interface ICreateProductUseCase {
    Result<String> execute(CreateProductCommand command);
}
