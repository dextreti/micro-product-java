package com.catalog.usecases.createcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.agregates.CategoryDomain;
import com.catalog.common.abstractions.Result;
import lombok.RequiredArgsConstructor;
import com.catalog.ports.out.ICategoryRepository;


@Service
@RequiredArgsConstructor
public class CreateCategoryHandler implements ICreateCategoryUseCase {

    private final ICategoryRepository categoryRepository;

    public Result<String> execute(CreateCategoryCommand command) {

        Result<CategoryDomain> categoryResult = CategoryDomain.create(
                command.name(),
                command.description()
        );


        if (!categoryResult.isSuccess()) {
            return Result.failure(categoryResult.getError());
        }


        CategoryDomain category = categoryResult.getValue();
        categoryRepository.save(category);


        return Result.success(category.getId());
    }
}

