package org.mort11.marketplaceapp;

import android.util.Log;

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

    public void buy(){
        ProductHolder.productsToBuy.remove(this);
        ProductHolder.productsBought.add(this);
    }

}
