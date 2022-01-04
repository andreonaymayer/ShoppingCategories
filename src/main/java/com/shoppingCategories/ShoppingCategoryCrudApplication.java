package com.shoppingCategories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

//@EnableAutoConfiguration
@SpringBootApplication
public class ShoppingCategoryCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCategoryCrudApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

}
