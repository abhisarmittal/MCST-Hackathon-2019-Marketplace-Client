package org.mort11.marketplaceapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.DataOutputStream;

public class Sell extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.selling_tab, container, false);

        Button submit = view.findViewById(R.id.submitButton);
        Log.d("Custom", "" + submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View viewer) {
                TextInputLayout productNameLayout = view.findViewById(R.id.productNameLayout);
                TextInputLayout productPriceLayout = view.findViewById(R.id.productPriceLayout);
                TextInputLayout productDescriptionLayout = view.findViewById(R.id.productDescriptionLayout);

                //get user inputs
                String productName = productNameLayout.getEditText().getText().toString();
                double productPrice = Double.parseDouble(productPriceLayout.getEditText().getText().toString());
                String productDescription = productDescriptionLayout.getEditText().getText().toString();

                Product userProduct = new Product(productName, productPrice, productDescription);
                //SEND PRODUCT TO SERVER
                sendProductToServer(userProduct);

                //clear user inputs
                productNameLayout.getEditText().getText().clear();
                productPriceLayout.getEditText().getText().clear();
                productDescriptionLayout.getEditText().getText().clear();

            }
        });
        return view;
    }

    public void sendProductToServer(Product product){
        product.sendToServer();
    }

}
