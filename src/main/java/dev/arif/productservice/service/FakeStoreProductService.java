package dev.arif.productservice.service;

import dev.arif.productservice.thirdpartyclient.productservice.fakeStore.FakeStoreProductDto;
import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.exception.NotFoundException;
import dev.arif.productservice.thirdpartyclient.productservice.fakeStore.FakeStoreProductServiceClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Primary
@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private  String productRequestBaseUrl = "https://fakestoreapi.com/products";

    private GenericProductDto convertFakeStoreProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto) {

        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());

        // if you want to return more info then we can return
        //Response Entity as wel here

        return product;
    }
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient)
    {
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {

       return  convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(genericProductDto));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts())
        {
            genericProductDtos.add(convertFakeStoreProductIntoGenericProduct(fakeStoreProductDto));
        }
        return  genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id)
    {
       return convertFakeStoreProductIntoGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }
}
