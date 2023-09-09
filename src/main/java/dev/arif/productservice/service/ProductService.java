package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.models.Product;

public interface ProductService {
     GenericProductDto getProductById(Long id);

     GenericProductDto createProduct(GenericProductDto genericProductDto);


}
