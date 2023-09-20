package dev.arif.productservice.repository;

import dev.arif.productservice.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
