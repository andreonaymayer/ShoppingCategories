package com.shoppingCategories.Entities;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Category {
    @Id
    private UUID id;
    private String name;

    public Category(String id, String name) {
        this.name = name;
        this.id = UUID.randomUUID();
    }

    public String getId() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
