package com.shoppingCategories.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Category", schema = "entities")
public class Category {
    @Id
    //private UUID id;
    private String id;
    private String name;

//    public Category(String id, String name) {
//        this.name = name;
//        this.id = id;//UUID.randomUUID();
//    }

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
