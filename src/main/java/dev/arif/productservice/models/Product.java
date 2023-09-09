package dev.arif.productservice.models;

public class Product extends BaseModel{

    private String title;
    private String description;

    private String image; //image url

    private Category category;

    private  double price;
}
