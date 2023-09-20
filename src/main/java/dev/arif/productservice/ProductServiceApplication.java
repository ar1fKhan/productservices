package dev.arif.productservice;



import dev.arif.productservice.models.Category;
import dev.arif.productservice.models.Price;
import dev.arif.productservice.models.Product;
import dev.arif.productservice.repository.CategoryRepository;
import dev.arif.productservice.repository.PriceRepository;
import dev.arif.productservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	ProductRepository productRepository;
	CategoryRepository categoryRepository;
	PriceRepository priceRepository;

	public ProductServiceApplication(ProductRepository productRepository, CategoryRepository categoryRepository,
									 PriceRepository priceRepository)
	{
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
		this.priceRepository = priceRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category category = new Category();
		category.setName("Apple Devices");

		Price price = new Price("Rupee", 10);

		Product product = new Product();
		product.setTitle("iPhone 15 Pro");
		product.setDescription("The best iPhone Ever");
		product.setCategory(category);
		product.setPrice(price);

		productRepository.save(product);

		//productRepository.deleteById(UUID.fromString("dfdfd"));




	}

}
