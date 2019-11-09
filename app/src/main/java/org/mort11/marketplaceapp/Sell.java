package org.mort11.marketplaceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.DataOutputStream;

public class Sell extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selling_tab, container, false);
        return view;
    }

    public void sendProductToServer(){
        String productJSON = "";
        try {
            DataOutputStream socketOS = new DataOutputStream(MainActivity.getSocket().getOutputStream());
            socketOS.writeUTF(productJSON);
            socketOS.flush();
            socketOS.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
