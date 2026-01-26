package com.catalog.usecases.updateproduct;

import org.springframework.stereotype.Service;

import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.Result;
import lombok.AllArgsConstructor;
import com.catalog.ports.out.IProductRepository;

@Service
@AllArgsConstructor
public class UpdateProductHandler implements IUpdateProductUseCase {

    private final IProductRepository productRepository;
    
    @Override
    public Result<String> execute(UpdateProductCommand cmd, String id) {

        ProductDomain product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return Result.failure("Producto no encontrado");
        }                

        Result<Void> updateResult = product.update(
            cmd.name(),          
            cmd.price(),         
            cmd.description(),   
            cmd.stock(),         
            cmd.imageUrl(),      
            cmd.categoryId()     
        );

        if (!updateResult.isSuccess()) {
            return Result.failure(updateResult.getError());
        }

        productRepository.save(product);

        return Result.success(id);
        

    }
    
}
