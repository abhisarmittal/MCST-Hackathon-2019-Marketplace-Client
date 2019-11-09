package org.mort11.marketplaceapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Sell extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.selling_tab, container, false);

        Button submit = view.findViewById(R.id.submitButton);
        Log.d("Custom", "" + submit);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextInputEditText productNameField = view.findViewById(R.id.product_name);
                TextInputEditText productPriceField = view.findViewById(R.id.product_price);
                TextInputEditText productDescriptionField = view.findViewById(R.id.product_description);

                String productName = productNameField.getText().toString();
                double productPrice = Double.parseDouble(productPriceField.getText().toString());
                String productDescription = productDescriptionField.getText().toString();

                Product userProduct = new Product(productName, productPrice, productDescription);

            }
        });
        return view;
    }

}
