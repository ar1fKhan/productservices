package dev.arif.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchRequestDto {

    private String query;
    private int pageNumber;
    private int size;


}
