package com.catalog.ports.out;

import com.catalog.agregates.ProductDomain;
import com.catalog.common.abstractions.IGenericRepository;

import java.util.List;


public interface IProductRepository extends IGenericRepository<ProductDomain> {

    List<ProductDomain> findByCategoryId(String categoryId);
    

}

