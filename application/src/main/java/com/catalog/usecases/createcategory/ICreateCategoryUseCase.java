package com.catalog.usecases.createcategory;

import com.catalog.common.abstractions.Result;

public interface ICreateCategoryUseCase {
    Result<String> execute(CreateCategoryCommand command);

}