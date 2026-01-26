package com.catalog.config;

import com.azure.cosmos.CosmosClient;
import com.azure.cosmos.CosmosContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CosmosClientConfig {

    @Bean(name = "productContainer")
    public CosmosContainer productContainer(CosmosClient client) {
        return client.getDatabase("CatalogDB").getContainer("Product");
    }
}
