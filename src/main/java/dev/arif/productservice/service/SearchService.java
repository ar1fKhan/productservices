package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericSelfProductDto;
import dev.arif.productservice.models.Product;
import dev.arif.productservice.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<GenericSelfProductDto> searchProduct(String query, int pageNumber, int size) {

        Page<Product> productPage = productRepository.findAllByTitleContaining(query, PageRequest.of(pageNumber, size));

        List<Product> products = productPage.get().toList();

        List<GenericSelfProductDto > genericSelfProductDtos = new ArrayList<>();

        for(Product product : products)
        {
            genericSelfProductDtos.add(GenericSelfProductDto.fromProductDto(product));
        }

        Page<GenericSelfProductDto> genericProductsPage = new PageImpl<>(
                genericSelfProductDtos ,productPage.getPageable(), productPage.getTotalElements());
        return  genericProductsPage;
    }

}
