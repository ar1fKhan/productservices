package dev.arif.productservice.service;

import dev.arif.productservice.models.Product;
import org.springframework.stereotype.Service;


@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductById(Long id) {
        return null;
    }
}
