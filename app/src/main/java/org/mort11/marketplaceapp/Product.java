package org.mort11.marketplaceapp;

import android.util.Log;

import com.google.gson.Gson;

import java.io.DataOutputStream;

public class Product {
    public String name;
    public double price;
    public String description;

    public Product (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void sendToServer(){
        Gson gson = new Gson();
        String productJSON = gson.toJson(this);
        try {
            DataOutputStream socketOS = new DataOutputStream(MainActivity.getSocket().getOutputStream());
            socketOS.writeUTF(productJSON);
            socketOS.flush();
            socketOS.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        Log.d("Custom", "Data sent to server!");
    }

}
