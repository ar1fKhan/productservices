package dev.arif.productservice.controllers;

import dev.arif.productservice.dtos.GenericSelfProductDto;
import dev.arif.productservice.exception.NotFoundException;
import dev.arif.productservice.service.SelfProductServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/selfproducts")
public class SelfProductController {

    private SelfProductServiceInterface selfProductServiceInterface;
    public SelfProductController(SelfProductServiceInterface selfProductServiceInterface)
    {
        this.selfProductServiceInterface = selfProductServiceInterface;
    }

    @GetMapping
    public List<GenericSelfProductDto> getAllProduct()
    {
        return selfProductServiceInterface.getAllProducts();
    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericSelfProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return selfProductServiceInterface.getProductById(id) ;
    }
    //Path variable is used for getting resouse by Id
    @DeleteMapping("{id}")
    public ResponseEntity<GenericSelfProductDto> deleteProductById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(
                selfProductServiceInterface.deleteProductById(id),
                HttpStatus.OK  // here we are return response code base on our requirement we can change it.
        );
    }


    @PostMapping
    public GenericSelfProductDto createProduct(@RequestBody GenericSelfProductDto productDto)
    {

        return selfProductServiceInterface.createProduct(productDto);
    }

}
