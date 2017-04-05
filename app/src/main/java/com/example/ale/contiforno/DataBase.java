package com.example.ale.contiforno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by ale on 05/04/2017.
 */

public class DataBase {
    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;

    private static final String CLIENTE_TABLE = "cliente";
    private static final String CLIENTE_NOME = "nome";
    private static final String CLIENTE_IMPORTO = "importo";
    private static final int CLIENTE_NOME_COL = 0;
    private static final int CLIENTE_IMPORTO_COL = 1;

    private static final String MESE_TABLE = "conto_mensile";
    private static final String MESE_NOME = "nome";
    private static final String MESE_MESE = "mese";
    private static final String MESE_ANNO = "anno";
    private static final String MESE_IMPORTO = "importo";
    private static final int MESE_NOME_COL = 0;
    private static final int MESE_MESE_COL = 1;
    private static final int MESE_ANNO_COL = 2;
    private static final int MESE_IMPORTO_COL = 3;

    private static final String SPESA_TABLE = "spesa";
    private static final String SPESA_ID = "id";
    private static final String SPESA_NOME = "nome";
    private static final String SPESA_GIORNO = "giorno";
    private static final String SPESA_MESE_NOME = "conto mensile";
    private static final String SPESA_MESE_MESE = "mese";
    private static final String SPESA_MESE_ANNO = "anno";
    private static final String SPESA_IMPORTO = "importo";
    private static final int SPESA_ID_COL = 0;
    private static final int SPESA_NOME_COL = 1;
    private static final int SPESA_GIORNO_COL = 2;
    private static final int SPESA_MESE_NOME_COL = 3;
    private static final int SPESA_MESE_MESE_COL = 4;
    private static final int SPESA_MESE_ANNO_COL = 5;
    private static final int SPESA_IMPORTO_COL = 6;

    private static final String CREATE_CLIENTE_TABLE =
            "CREATE TABLE " + CLIENTE_TABLE + " (" +
                    CLIENTE_NOME + " TEXT PRIMARY KEY, " +
                    CLIENTE_IMPORTO + " INTEGER );";
    private static final String CREATE_MESE_TABLE =
            "CREATE TABLE " + MESE_TABLE + " (" +
                    MESE_NOME + " TEXT NOT NULL, " +
                    MESE_MESE + " TEXT NOT NULL, " +
                    MESE_ANNO + " TEXT NOT NULL, " +
                    MESE_IMPORTO + " INTEGER, " +
                    " PRIMARY KEY (" + MESE_NOME + "," + MESE_MESE + "," + MESE_ANNO+"));";
    private static final String CREATE_TABLE_SPESA =
            "CREATE TABLE " + SPESA_TABLE + " (" +
                    SPESA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SPESA_NOME + " TEXT NOT NULL, " +
                    SPESA_GIORNO + " TEXT NOT NULL, " +
                    SPESA_MESE_NOME + " TEXT NOT NULL, " +
                    SPESA_MESE_MESE + " TEXT NOT NULL, " +
                    SPESA_MESE_ANNO + " TEXT NOT NULL);";

    private static class DBHelper extends SQLiteOpenHelper {
        private DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_CLIENTE_TABLE);
            db.execSQL(CREATE_MESE_TABLE);
            db.execSQL(CREATE_TABLE_SPESA);

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

    }
    private SQLiteDatabase db;
    private DBHelper dbHelper;


    public DataBase (Context context){
        dbHelper = new DBHelper(context, DB_NAME, null, DB_VERSION);
    }
    private void openReadableDB() {
        db = dbHelper.getReadableDatabase();
    }

    private void openWriteableDB() {
        db = dbHelper.getWritableDatabase();
    }

    private void closeDB() {
        if (db != null)
            db.close();
    }
    public long insertCliente(Cliente cliente) {
        ContentValues cv = new ContentValues();
        cv.put(CLIENTE_NOME, cliente.getNome());
        cv.put(CLIENTE_IMPORTO, cliente.getImporto());
        this.openWriteableDB();
        long rowID = db.insert(CLIENTE_TABLE, null, cv);
        this.closeDB();
        return rowID;
    }
    public ArrayList<Cliente> getClienti(){
        this.openReadableDB();
        Cursor cursor = db.query(CLIENTE_TABLE, null,
                null, null,
                null, null, null);
        ArrayList<Cliente> clienti = new ArrayList<Cliente>();
        while (cursor.moveToNext()) {
            clienti.add(getClienteFromCursor(cursor));
        }
        if (cursor != null)
            cursor.close();
        this.closeDB();

        return clienti;
    }
    private static Cliente getClienteFromCursor(Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0){
            return null;
        }
        else {
            try {
                Cliente cliente = new Cliente(
                        cursor.getString(CLIENTE_NOME_COL),
                        cursor.getDouble(CLIENTE_IMPORTO_COL));

                return cliente;
            }
            catch(Exception e) {
                return null;
            }
        }
    }

}
