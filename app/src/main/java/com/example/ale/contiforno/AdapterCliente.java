package com.example.ale.contiforno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ale on 05/04/2017.
 */

public class AdapterCliente extends ArrayAdapter<Cliente> {
    ArrayList<Cliente> arrayList;

    public AdapterCliente(Context context, ArrayList<Cliente> Items) {
        super(context, 0, Items);
        arrayList = Items;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente item = arrayList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_cliente, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.item_cliente_nome);
        TextView importo = (TextView) convertView.findViewById(R.id.item_importo);
        name.setText(item.getNome());
        String data_stringa = "Importo dovuto : " + item.getImporto();
        importo.setText(data_stringa);
        // new LoadImageTask().execute(item.getIcon());
        // Return the completed view to render on screen
        return convertView;
    }
}
