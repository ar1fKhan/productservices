package dev.arif.productservice.thirdpartyclient.productservice.fakeStore;

import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Wrapper Over FakeStore API
 */

@Service
public class FakeStoreProductServiceClient {

    private RestTemplateBuilder restTemplateBuilder;

    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;

    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;

    private String specificProductRequestUrl ;
    private String productRequestsBaseUrl ;

    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder,
                                         @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestsBaseUrl  = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
    }


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




    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto> responseEntity =  restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class,id);

        //responseEntity.getStatusCode()
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null)
        {
            throw  new NotFoundException("product with id : "+ id + " does not exist.");
        }

        return fakeStoreProductDto;
    }


    public FakeStoreProductDto createProduct(GenericProductDto fakeStoreProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(productRequestsBaseUrl,fakeStoreProductDto,FakeStoreProductDto.class);

        return  response.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //Due to erase of generics at run time took the  array instead of List
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(productRequestsBaseUrl, FakeStoreProductDto[].class);

        List<GenericProductDto> answer = new ArrayList<>();

        return Arrays.stream(response.getBody()).toList();
    }


    public FakeStoreProductDto deleteProductById(Long id)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =  restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }
    public FakeStoreProductDto updateProductById(Long Id, GenericProductDto genericProductDto)
    {
        RestTemplate restTemplate = restTemplateBuilder.build();


        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductRequestUrl,HttpMethod.PUT,requestCallback,responseExtractor,Id,genericProductDto);

        return  response.getBody();
    }
}
