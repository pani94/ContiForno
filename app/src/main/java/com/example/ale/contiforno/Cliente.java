package com.example.ale.contiforno;

/**
 * Created by ale on 05/04/2017.
 */

public class Cliente {
    private String nome;
    private double importo;

    public Cliente(String nome, double importo) {
        this.nome = nome;
        this.importo = importo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }
}
