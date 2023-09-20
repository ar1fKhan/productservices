package dev.arif.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category extends  BaseModel{

    private  String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<>();
}
