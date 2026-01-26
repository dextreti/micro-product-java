package com.catalog.usecases.createproduct;

import org.springframework.stereotype.Service;

import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.Result;
import lombok.RequiredArgsConstructor;
import com.catalog.ports.out.IProductRepository;

@Service
@RequiredArgsConstructor
public class CreateProductHandler implements ICreateProductUseCase {

    private final IProductRepository productRepository;
    

    @Override
    public Result<String> execute(CreateProductCommand cmd) {
       
        Result<ProductDomain> productResult = ProductDomain.create(
            cmd.name(),          
            cmd.price(),         
            cmd.description(),   
            cmd.stock(),         
            cmd.imageUrl(),      
            cmd.categoryId()
        );

        
        if (!productResult.isSuccess()) {
            return Result.failure(productResult.getError());
        }

        
        ProductDomain product = productResult.getValue();
        productRepository.save(product);

        
        return Result.success(product.getId());
    }

}
