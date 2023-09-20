package dev.arif.productservice.models;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Setter
@Getter
public class Product extends BaseModel{

    private String title;
    private String description;

    private String image; //image url

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "category")
    private Category category;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private  Price price;
}
