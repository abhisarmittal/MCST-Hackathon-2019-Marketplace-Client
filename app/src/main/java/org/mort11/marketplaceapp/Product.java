package org.mort11.marketplaceapp;

import android.util.Log;

import android.util.Log;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Product {
    public String name;
    public double price;
    public String description;

    public Product (String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        if(name == null || name.isEmpty()){
            name = "";
        }
        if(description == null || description.isEmpty()){
            description = "";
        }
    }

    public void sendToServer(){
        Gson gson = new Gson();
        final String productJSON = gson.toJson(this);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Log.d("Custom", productJSON);
                    DataOutputStream socketOS = new DataOutputStream(MainActivity.getSocket().getOutputStream());
                    socketOS.writeUTF(productJSON);
                    socketOS.flush();
                }catch(IOException e){
                    Log.d("Custom", "Connection to server: " + MainActivity.getSocket().isConnected());
                    Log.d("Custom", "Crashed!!!");
                    //Log.d("Custom", e.getLocalizedMessage());
                }
                Log.d("Custom", "Data sent to server!");
            }
        }).start();
    }

    public void buy(){
        ProductHolder.productsToBuy.remove(this);
        ProductHolder.productsBought.add(this);
    }


}
