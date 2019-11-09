package org.mort11.marketplaceapp;
import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.core.content.res.TypedArrayUtils;

public class ProductHolder {
    public static ArrayList<Product> products;
    static{
        products = new ArrayList<Product>();
    }

    public static Product addProduct(String productJSON)
    {
        //CONVERT
        return null;
    }

    public static void addProduct(Product product)
    {
        products.add(product);
    }
}
