package com.example.hemapriya.domain.Model;

public class Food {
    String dish;
    String price,desc;

    public Food(String dish, String price, String desc) {
        this.dish= dish;
        this.price = price;
        this.desc=desc;
    }

    public Food(String dish, String price) {
        this.dish = dish;
        this.price = price;
    }


    public Food() {
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String desc) {
        this.dish= dish;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
