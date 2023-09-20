package dev.arif.productservice.controllers;

import dev.arif.productservice.dtos.ExceptionDto;
import dev.arif.productservice.dtos.GenericProductDto;
import dev.arif.productservice.exception.NotFoundException;
import dev.arif.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/products")
public class ProductController {


    // This is setter injection
  /* @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }*/

    private ProductService productService;

    //we inject wire field, setter and constructor

//    Could not autowire. There is more than one bean of 'ProductService' type
     // This issue we got because there is two implementation of product service, to resolve
    // we have to Qualify that product service we will Qualifier Keyword
    // we can add like this @Qualifier("FakeStoreProductService") ProductService but
    // if suppose we want to use other service then we have to change the code base to avoid that
    // we can add it in application.properties, and we can use variable name here.

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping
    public List<GenericProductDto> getAllProduct()
    {
         return productService.getAllProducts();
    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException
    {
         return productService.getProductById(id) ;
    }
    //Path variable is used for getting resouse by Id
    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(
                productService.deleteProductById(id),
                HttpStatus.OK  // here we are return response code base on our requirement we can change it.
        );
    }


    @PostMapping
    public GenericProductDto  createProduct(@RequestBody GenericProductDto productDto)
    {

        return productService.createProduct(productDto);
    }


    @PutMapping("{id}")
    public GenericProductDto updateProductById(@PathVariable Long id, @RequestBody GenericProductDto productDto )
    {
        return productService.updateProductById(id,productDto);
    }
}
