package org.mort11.marketplaceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Socket;

public class MainActivity extends AppCompatActivity{

    private static DialogFragment connectingDialogFragment;
    private static Socket socket;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabs();
        connectingDialogFragment = new ConnectingDialogFragment();
        connectingDialogFragment.show(getSupportFragmentManager(), "Connecting to Sever");
        connectToServer();
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

    public static void connectToServer(){
        Log.d("Custom", "RUNNING!!!");
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Log.d("Custom", "Attempting to connect on port 4006");
                    socket = new Socket(Inet4Address.getByName("192.168.43.154"), 4039);
                    Log.d("Custom", "Connection established!!");
                    connectingDialogFragment.dismiss();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static Socket getSocket(){
        return socket;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        try {
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
