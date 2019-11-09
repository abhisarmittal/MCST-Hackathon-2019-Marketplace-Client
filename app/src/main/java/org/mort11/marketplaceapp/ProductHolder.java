package org.mort11.marketplaceapp;
import java.lang.reflect.Array;
import java.util.ArrayList;

import androidx.core.content.res.TypedArrayUtils;

public class ProductHolder {
    public static ArrayList<Product> productsToBuy;
    public static ArrayList<Product> productsBought;
    static{
        productsToBuy = new ArrayList<Product>();
        productsBought = new ArrayList<Product>();
    }

    public static Product addProductToBuy(String productJSON)
    {
        //CONVERT
        return null;
    }

    public static void addProductToBuy(Product product)
    {
        productsToBuy.add(product);
    }

    public static void addProductBought(Product product) //change
    {
        productsBought.add(product);
    }
}
