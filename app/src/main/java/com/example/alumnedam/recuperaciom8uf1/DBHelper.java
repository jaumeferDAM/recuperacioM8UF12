package com.example.alumnedam.recuperaciom8uf1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ALUMNEDAM on 09/06/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NOMBRE = "promocion.db";
    public static final String COLUMNA_ID = "Cliente_id";
    public static final String COLUMNA_PRODUCTO1 = "Producto1";
    public static final String COLUMNA_PRODUCTO2 = "Producto2";
    public static final String COLUMNA_PRODUCTO3 = "Producto3";
    private static final String SQL_CREAR = "create table "
            + DATABASE_NOMBRE + "(" + COLUMNA_ID
            + " integer primary key autoincrement, " + COLUMNA_PRODUCTO1
            + " text not null," + COLUMNA_PRODUCTO2
            + " text not null," + COLUMNA_PRODUCTO3
            + " text not null);";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREAR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int agregar(String producto, String producto2, String producto3) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMNA_PRODUCTO1, producto);
        values.put(COLUMNA_PRODUCTO2, producto2);
        values.put(COLUMNA_PRODUCTO3, producto3);

        db.insert(DATABASE_NOMBRE, null, values);
        long newRowId;
        newRowId = db.insert(DATABASE_NOMBRE, COLUMNA_PRODUCTO1, values);
        db.close();
        return (int) newRowId;
    }

    public void obtener(int id) {

        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMNA_ID, COLUMNA_PRODUCTO1, COLUMNA_PRODUCTO2, COLUMNA_PRODUCTO3};

        Cursor cursor = db.query(DATABASE_NOMBRE,
                projection,
                " _id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);


        if (cursor != null)
            cursor.moveToFirst();

        System.out.println("El nombre es " + cursor.getString(1));
        db.close();

    }

    public void actualizar(String nombre, int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nombre", nombre);

        db.update(DATABASE_NOMBRE,
                values,
                " _id = ?",
                new String[]{String.valueOf(id)});
//        db.update(DATABASE_NOMBRE, values, COLUMNA_ID + id, null);
        db.close();
    }
}
