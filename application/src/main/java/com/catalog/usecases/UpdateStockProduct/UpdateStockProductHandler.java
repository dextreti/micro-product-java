package com.catalog.usecases.UpdateStockProduct;

import com.catalog.dtos.OrderItemResponse;
import com.catalog.dtos.OrderResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.Result;
import lombok.AllArgsConstructor;
import com.catalog.ports.out.IProductRepository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


@Service
@AllArgsConstructor
public class UpdateStockProductHandler implements IUpdateStockProductUseCase {

    private final IProductRepository productRepository;

    @Override
    @Transactional
    public Result<String> execute(OrderResponse order) {

        for (OrderItemResponse item : order.purchaseOrderItems()) {

            ProductDomain product = productRepository.findById(item.productId().toString()).orElseThrow();

            if (product == null ) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                //aqui se deberia implementar un notificationPort notificar a .net api  "Producto no encontrado: " + item.productId()
                return Result.failure("Orden cancelada");
            }

            Result<Void> result = product.updateStock(item.quantity());

            if (!result.isSuccess()) {
                //aqui se deberia implementar un notificationPort a la api de .net "Sin stock: " + result.getError()
                return Result.failure("Sin stock suficiente");
            }

            productRepository.save(product);
        }
        return Result.success(order.id().toString());

    }

}

//public record StockNotificationResponse(
//        UUID orderId,
//        String status,      // "SUCCESS" o "FAILURE"
//        String message,     // "Insufficient stock for product X"
//        String serviceName  // "catalog-service-java"
//) {}

