package org.mort11.marketplaceapp;
import java.util.ArrayList;

public class ProductHolder {
    public static ArrayList<Product> products;
    static{
        products = new ArrayList<Product>();
    }

    public static Product addProduct(String productJSON)
    {
        return null;
    }

    public static void addProduct(Product product)
    {
        products.add(product);
    }
}
