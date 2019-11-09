package org.mort11.marketplaceapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Inventory extends Fragment {

    View view;
    ListViewAdapterBuy listViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.inventory_tab, container, false);
        initListView();
        return view;
    }

    public void initListView(){
        ListView productListView = view.findViewById(R.id.listview);
        listViewAdapter = new ListViewAdapterBuy(getContext());
        productListView.setAdapter(listViewAdapter);
        //registerForContextMenu(productListView);
    }



}
