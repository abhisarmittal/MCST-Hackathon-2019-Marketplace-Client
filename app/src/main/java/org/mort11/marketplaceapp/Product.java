package org.mort11.marketplaceapp;

public class Product {
    public String name;
    public double price;
    public String description;

    public Product (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product (String name, double price) {
        this.name = name;
        this.price = price;
        this.description = null;
    }
}
