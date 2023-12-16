package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericSelfProductDto;
import dev.arif.productservice.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface SelfProductServiceInterface {


        GenericSelfProductDto getProductById(UUID id)throws NotFoundException;

        GenericSelfProductDto createProduct(GenericSelfProductDto genericProductDto);

        GenericSelfProductDto deleteProductById(UUID id);

        List<GenericSelfProductDto> getAllProducts();

        GenericSelfProductDto updateProductById(UUID Id, GenericSelfProductDto genericProductDto);
}
