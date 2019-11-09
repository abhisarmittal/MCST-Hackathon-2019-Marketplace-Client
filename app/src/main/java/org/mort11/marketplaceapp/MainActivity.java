package org.mort11.marketplaceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity{

    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        initTabs();

        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                TextInputEditText productNameField = findViewById(R.id.product_name);
                TextInputEditText productPriceField = findViewById(R.id.product_price);
                TextInputEditText productDescriptionField = findViewById(R.id.product_description);

                String productName = productNameField.getText().toString();
                double productPrice = Double.parseDouble(productPriceField.getText().toString());
                String productDescription = productDescriptionField.getText().toString();

                Product userProduct = new Product(productName, productPrice, productDescription);
                
            }
        });
    }

    public void initTabs() {
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        PageAdapter tabAdapter = new PageAdapter(getSupportFragmentManager(), new Buy(), new Sell());
        Log.d("Custom", "Tabs: " + tabs);
        Log.d("Custom", "ViewPager: " + viewPager);
        Log.d("Custom", "PageAdapter: " + tabAdapter);
        viewPager.setAdapter(tabAdapter);
        tabs.setupWithViewPager(viewPager);
    }



}
