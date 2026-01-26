package com.catalog.usecases.UpdateStockProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.Result;
import lombok.AllArgsConstructor;
import com.catalog.ports.out.IProductRepository;


@Service
@AllArgsConstructor
public class UpdateStockProductHandler implements IUpdateStockProductUseCase {

    private final IProductRepository productRepository;

    @Override
    public Result<String> execute(UpdateStockProductCommand command) {

        ProductDomain product = productRepository.findById(command.productId()).orElse(null);

        if (product == null) {
            return Result.failure("Producto no encontrado");
        }

        Result<Void> validationResult = product.updateStock(command.quantity());

        if (!validationResult.isSuccess()) {
            return Result.failure(validationResult.getError());
        }

        productRepository.save(product);

        return Result.success(product.getId());

    }

}

//@Service
//// Quitamos @AllArgsConstructor para controlar la inyección manualmente
//public class UpdateStockProductHandler implements IUpdateStockProductUseCase {
//
//    private final IProductRepository productRepository;
//
//    // Adaptación: Inyectamos el repositorio pero le decimos a Spring que NO es obligatorio
//    public UpdateStockProductHandler(@Autowired(required = false) IProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public Result<String> execute(UpdateStockProductCommand command) {
//        // Validación de seguridad: si no hay repositorio, no podemos hacer nada
//        if (productRepository == null) {
//            System.out.println("LOG: No hay un adaptador de base de datos configurado.");
//            return Result.failure("Servicio de persistencia no disponible");
//        }
//
//        ProductDomain product = productRepository.findById(command.productId()).orElse(null);
//
//        if (product == null) {
//            return Result.failure("Producto no encontrado");
//        }
//
//        Result<Void> validationResult = product.updateStock(command.quantity());
//
//        if (!validationResult.isSuccess()) {
//            return Result.failure(validationResult.getError());
//        }
//
//        productRepository.save(product);
//
//        return Result.success(product.getId());
//    }
//}
