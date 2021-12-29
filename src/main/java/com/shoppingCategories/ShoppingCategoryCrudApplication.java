package com.shoppingCategories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ShoppingCategoryCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCategoryCrudApplication.class, args);
    }

}
