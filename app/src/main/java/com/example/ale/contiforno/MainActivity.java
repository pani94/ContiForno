package com.example.ale.contiforno;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.database.DatabaseUtilsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView aggiungi_cliente;
    private ListView lista_clienti;
    private ButtonListener listener;
    private DataBase db;
    private ArrayList <Cliente> arrayList ;
    private AdapterCliente adapterCliente;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aggiungi_cliente = (TextView) findViewById(R.id.aggiungi_cliente);
        lista_clienti = (ListView) findViewById(R.id.lista_clienti);
        arrayList = new ArrayList<>();
        db = new DataBase(this);
        arrayList = db.getClienti();
        adapterCliente = new AdapterCliente(this,arrayList);
        adapterCliente.notifyDataSetChanged();
        lista_clienti.setAdapter(adapterCliente);
        listener = new ButtonListener();
        aggiungi_cliente.setOnClickListener(listener);
        lista_clienti.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent  = new Intent(this,GestioneConto.class);
        intent.putExtra("cliente",arrayList.get(position).getNome());
        startActivity(intent);
    }

    public class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Title");

// Set up the input
            final EditText input = new EditText(MainActivity.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

// Set up the buttons
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String nome = input.getText().toString();
                    Cliente cliente = new Cliente(nome,0);
                    db = new DataBase(MainActivity.this);
                    db.insertCliente(cliente);
                    arrayList.add(cliente);
                    adapterCliente.notifyDataSetChanged();

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    }
}
