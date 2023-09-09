package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService{

    @Override
    public GenericProductDto getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }
}
