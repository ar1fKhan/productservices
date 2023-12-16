package dev.arif.productservice.controllers;

import dev.arif.productservice.dtos.GenericSelfProductDto;
import dev.arif.productservice.dtos.SearchRequestDto;
import dev.arif.productservice.service.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
}
    @PostMapping
    public Page<GenericSelfProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto, Pageable pageable) {
        return searchService.searchProduct(searchRequestDto.getQuery(),
                 searchRequestDto.getPageNumber(), searchRequestDto.getSize()
                );
    }
}
