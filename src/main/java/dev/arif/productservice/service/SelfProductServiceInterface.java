package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericSelfProdductDto;
import dev.arif.productservice.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface SelfProductServiceInterface {


        GenericSelfProdductDto getProductById(UUID id)throws NotFoundException;

        GenericSelfProdductDto createProduct(GenericSelfProdductDto genericProductDto);

        GenericSelfProdductDto deleteProductById(UUID id);

        List<GenericSelfProdductDto> getAllProducts();

        GenericSelfProdductDto updateProductById(UUID Id, GenericSelfProdductDto genericProductDto);
}
