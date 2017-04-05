package com.example.ale.contiforno;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class GestioneConto extends AppCompatActivity {

    private TextView nome_cliente;
    private TextView nome_cliente_valore;
    private TextView importo;
    private TextView importo_valore;
    private TextView aggiungi_spesa;
    private TextView aggiungi_mese;
    private TextView elenco_mesi;
    private TextView azzera;
    private String nomeCliente;
    private Double importoVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione_conto);
        nomeCliente = getIntent().getStringExtra("cliente");

        nome_cliente = (TextView) findViewById(R.id.nome_cliente);
        nome_cliente_valore = (TextView) findViewById(R.id.nome_cliente_valore);
        nome_cliente_valore.setText(nomeCliente);
        importo = (TextView) findViewById(R.id.importo);
        importo_valore = (TextView) findViewById(R.id.importo_value);
        aggiungi_spesa = (TextView) findViewById(R.id.aggiungi_spesa);
        aggiungi_mese = (TextView) findViewById(R.id.aggiungi_mese);
        azzera = (TextView) findViewById(R.id.azzera);
        elenco_mesi = (TextView) findViewById(R.id.elenco_mesi);


    }

}
