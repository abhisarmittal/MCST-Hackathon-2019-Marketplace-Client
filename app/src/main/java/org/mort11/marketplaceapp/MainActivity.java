package org.mort11.marketplaceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity{

    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        initTabs();
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
