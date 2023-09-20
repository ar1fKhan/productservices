package dev.arif.productservice.service;

import dev.arif.productservice.dtos.GenericSelfProdductDto;
import dev.arif.productservice.models.Category;
import dev.arif.productservice.models.Price;
import dev.arif.productservice.models.Product;
import dev.arif.productservice.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements SelfProductServiceInterface{

    private GenericSelfProdductDto convertSimpleProductIntoGenericProduct(Optional<Product> optproduct) {

        GenericSelfProdductDto productDto = new GenericSelfProdductDto();
        if (optproduct.isPresent()) {
            Product product = optproduct.get();
            productDto.setId(product.getId());
            productDto.setTitle(product.getTitle());
            productDto.setDescription(product.getDescription());
            productDto.setImage(product.getImage());

            productDto.setPrice(product.getPrice().getPrice());

            productDto.setCategory(product.getCategory().getName());


            return productDto;
        }
        return null;
    }



    ProductRepository productRepository;
    public SelfProductServiceImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    @Override
    public GenericSelfProdductDto getProductById(UUID id) {
        return convertSimpleProductIntoGenericProduct(productRepository.findById(id));
    }

    @Override
    public GenericSelfProdductDto createProduct(GenericSelfProdductDto genericProductDto) {

        Price price = new Price();
        Category category = new Category();

        Product product = new Product();

        price.setPrice(genericProductDto.getPrice());
        price.setCurrency("Rupee");

        category.setName(genericProductDto.getCategory());

        product.setTitle(product.getTitle());
        product.setDescription(product.getDescription());

        product.setCategory(category);

        product.setPrice(price);

        productRepository.save(product);

        return genericProductDto;

    }

    @Override
    public GenericSelfProdductDto deleteProductById(UUID id) {
        GenericSelfProdductDto product = convertSimpleProductIntoGenericProduct(productRepository.findById(id));
       productRepository.deleteById(id);
       return product;

    }

    @Override
    public List<GenericSelfProdductDto> getAllProducts() {
        List<Product>  products = productRepository.findAll();
        List<GenericSelfProdductDto> genericSimpleDtos = new ArrayList<>();
        for(Product product : products)
        {
            genericSimpleDtos.add(convertSimpleProductIntoGenericProduct(Optional.ofNullable(product)));
        }
        return genericSimpleDtos;
    }

    @Override
    public GenericSelfProdductDto updateProductById(UUID Id, GenericSelfProdductDto genericProductDto) {
        return null;
    }
}
