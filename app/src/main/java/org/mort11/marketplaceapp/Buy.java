package org.mort11.marketplaceapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Buy extends Fragment {

    View view;
    ListView productListView;
    ListViewAdapterBuy listViewAdapterBuy;

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("Buy");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.buying_tab, container, false);
        initListView();
        registerForContextMenu(productListView);
        return view;
    }

    public void initListView(){
        productListView = view.findViewById(R.id.listview);
        listViewAdapterBuy = new ListViewAdapterBuy(getContext());
        productListView.setAdapter(listViewAdapterBuy);
        //registerForContextMenu(productListView);
    }

    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Product product = ProductHolder.productsToBuy.get(info.position);
        switch (item.getTitle().toString()) {
            case "Buy":
                product.buy();
                Toast.makeText(getContext(), "Congratulations! Item bought!", Toast.LENGTH_LONG).show();
                listViewAdapterBuy.remove(product);
                break;
        }
        return super.onContextItemSelected(item);
    }

}
