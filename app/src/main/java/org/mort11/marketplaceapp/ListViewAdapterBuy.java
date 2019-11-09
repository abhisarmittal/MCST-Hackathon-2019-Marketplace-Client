package org.mort11.marketplaceapp;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

public class ListViewAdapterBuy extends ArrayAdapter<Product> {

    public ListViewAdapterBuy(@NonNull Context context) {
        super(context, R.layout.product_layout_buy, ProductHolder.productsToBuy);
    }

    private static class ViewHolder {
        TextView product_name, product_price, product_description;

    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        Product product = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.product_layout_buy, parent, false);
            viewHolder.product_name = convertView.findViewById(R.id.listViewProductName);
            viewHolder.product_price = convertView.findViewById(R.id.listViewProductPrice);
            viewHolder.product_description = convertView.findViewById(R.id.listViewProductDescription);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.product_name.setText("Product Name: " + product.name);
        viewHolder.product_price.setText("Product Price: " + product.price);
        viewHolder.product_description.setText("Product Price: " + product.description);
        return convertView;
    }
}
