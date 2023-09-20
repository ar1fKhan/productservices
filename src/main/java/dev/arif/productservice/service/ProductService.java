package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.exception.NotFoundException;
import dev.arif.productservice.models.Product;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductById(Long id)throws NotFoundException;

     GenericProductDto createProduct(GenericProductDto genericProductDto);

     GenericProductDto deleteProductById(Long id);

     List<GenericProductDto> getAllProducts();

     GenericProductDto updateProductById(Long Id, GenericProductDto genericProductDto);



}
