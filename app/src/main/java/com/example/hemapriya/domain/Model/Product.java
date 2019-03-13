package com.example.hemapriya.domain.Model;

public class Product {

    String dish;
    String price;

    public Product() {
    }

    public String getDish() {

        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Product(String dish, String price) {

        this.dish = dish;
        this.price = price;
    }
}
