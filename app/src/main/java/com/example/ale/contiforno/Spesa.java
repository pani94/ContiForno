package com.example.ale.contiforno;

/**
 * Created by ale on 05/04/2017.
 */

public class Spesa {

    private int id;
    private String nome;
    private int giorno;
    private String cliente;
    private int mese;
    private int anno;
    private double importo;

    public Spesa(int id, String nome, int giorno, String cliente, int mese, int anno, double importo) {
        this.id = id;
        this.nome = nome;
        this.giorno = giorno;
        this.cliente = cliente;
        this.mese = mese;
        this.anno = anno;
        this.importo = importo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getGiorno() {
        return giorno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public double getImporto() {
        return importo;
    }

    public void setImporto(double importo) {
        this.importo = importo;
    }
}
