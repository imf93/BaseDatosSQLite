package com.chacach.dbandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class DB extends SQLiteOpenHelper {
    public DB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Prueba", factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table datos(nombre text, apellido text,apellido2 text, apellido3 text, frenos text, caja text, suspension text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public String guardar(String nombre, String apellido, String apellido2, String apellido3, String frenos, String caja, String suspension) {
        String mensaje="";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put("nombre",nombre);
        contenedor.put("apellido", apellido);
        contenedor.put("apellido2",apellido2);
        contenedor.put("apellido3",apellido3);
        contenedor.put("frenos", frenos);
        contenedor.put("caja", caja);
        contenedor.put("suspension", suspension);

        try {
            database.insertOrThrow("datos",null,contenedor);
            mensaje="Ingresado Correctamente";
        }catch (SQLException e){
            mensaje="No Ingresado";
        }
        database.close();
        return mensaje;
    }


    public String[] buscar_reg(String buscar){
        String[] datos = new String[8];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM datos WHERE nombre ='"+buscar+"'";
        Cursor registros = database.rawQuery(q, null);
        if(registros.moveToFirst()){
            for (int i = 0; i < 7; i++) {
                datos[i]= registros.getString(i);

            }
            datos[7] = "Encontrado";
        }else{

            datos[7] = "No se encontro a " + buscar;
        }
        database.close();
        return datos;
    }



}

