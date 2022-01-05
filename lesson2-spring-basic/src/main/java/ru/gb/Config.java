package ru.gb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.gb.repository.ProductRepository;
import ru.gb.repository.ProductRepositoryImpl;
import ru.gb.service.CartService;
import ru.gb.service.ProductService;

@ComponentScan("ru.gb")
@Configuration
public class Config {

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryImpl();
    }

    @Bean
    public ProductService productService() {
        return new ProductService();
    }

    @Bean
    @Scope("prototype")
    public CartService cartService() {
        return new CartService(productRepository());
    }
}