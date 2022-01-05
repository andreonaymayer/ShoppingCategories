package com.shoppingCategories.Entities;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category", schema = "entities")
public class Category {
    @Id
    private String id;
    private String name;

    public Category() {

    }

    public String getId() {
        return id;//.toString();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
