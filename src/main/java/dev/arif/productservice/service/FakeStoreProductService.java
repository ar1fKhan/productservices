package dev.arif.productservice.service;

import dev.arif.productservice.dtos.FakeStoreProductDto;
import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;


@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private  String createProductRequestUrl = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductDto getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class,id);

        //responseEntity.getStatusCode()
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        GenericProductDto product = new GenericProductDto();
        product.setImage(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());



        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl,genericProductDto,GenericProductDto.class);

        return  response.getBody();
    }
}
