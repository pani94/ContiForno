package com.example.ale.contiforno;

/**
 * Created by ale on 05/04/2017.
 */

public class Conto {

    private String cliente;
    private int mese;
    private int anno;
    private double importo;


    public Conto(String cliente, int mese, int anno, double importo) {
        this.cliente = cliente;
        this.mese = mese;
        this.anno = anno;
        this.importo = importo;
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
