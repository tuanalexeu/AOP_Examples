package com.example.aop.aspectjAdvice;

public class Guitar {
    public String play() {
        return "Some guitar music";
    }

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
