package dev.arif.productservice.controllers;

import dev.arif.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/product")
public class ProductController {


    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }
    @GetMapping
    public  void getAllProduct()
    {

    }

    //localhost:8080/products/123
    @GetMapping("{id}")
    public  String getProductById(@PathVariable("id") Long id)
    {
        return "Here is product id: " +id;
    }
    //Path variable is used for getting resouse by Id
    @DeleteMapping("{id}")
    public String deleteProductById(@PathVariable("id") Long id)
    {
        return "Here is product id: " +id;
    }

    @PostMapping
    public String  createProduct()
    {
        return "Create a new productss with id :"+ UUID.randomUUID();
    }


    @PutMapping("{id}")
    public String updateProductById()
    {
        return "this is used for adding production in database with id : "+UUID.randomUUID();
    }
}
