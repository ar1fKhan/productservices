package dev.arif.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter

public class GenericSelfProdductDto {

    private UUID id;

    private  String title;
    private  double price;

    private String Category;

    private String description;
    private String image;
}
