package dev.arif.productservice.dtos;

import dev.arif.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class GenericSelfProductDto {

    private UUID id;

    private  String title;
    private  double price;

    private String Category;

    private String description;
    private String image;

    static  public GenericSelfProductDto fromProductDto(Product product){
        GenericSelfProductDto genericSelfProductDto = new GenericSelfProductDto();
        genericSelfProductDto.setId(product.getId());
        genericSelfProductDto.setTitle(product.getTitle());
        genericSelfProductDto.setPrice(product.getPrice().getPrice());
        genericSelfProductDto.setCategory(product.getCategory().getName());
        genericSelfProductDto.setDescription(product.getDescription());
        genericSelfProductDto.setImage(product.getImage());
        return genericSelfProductDto;
    }
}
