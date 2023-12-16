package dev.arif.productservice.repository;

import dev.arif.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.UUID;
@Repository

public interface ProductRepository extends JpaRepository<Product, UUID> {


    //List<Product> findAll(Pageable pageable);

   // List<Product>  getAll(Pageable pageable);

    Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice_PriceOrderByPrice_price(String title, double price);

    List<Product> findAllByPrice_Currency(String currency);

    @Override
    void delete(Product entity);

    long countAllByPrice_Currency(String currency);

    List<Product> findAllByTitleLike(String titleRegex);

    List<Product> readAllByTitleLike(String titleRegex);


    Page<Product> findAllByTitleContaining(String title, Pageable pageable);




}
