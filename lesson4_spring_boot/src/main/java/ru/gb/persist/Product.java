package ru.gb.persist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class Product {

    private Long id;

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private int price;

    public Product() {
    }

    public Product(Long id, String name, String description, int price) {
        this.id = id;
        this.name = name;
        this.description=description;
        this.price=price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
