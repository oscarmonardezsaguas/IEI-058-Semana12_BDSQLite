package com.example.semana12_bdsqlite.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.semana12_bdsqlite.entidades.Contactos;

import java.lang.reflect.Array;
import java.util.ArrayList;

import kotlin.contracts.Returns;

public class dbContactos extends DBHelper {
    Context context;

    public dbContactos(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarContacto(String nombre, String telefono, String correo ) {
        long id = 0;
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo", correo);

            id = db.insert(TABLE_CONTACTOS, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }

    /* public ArrayList<Contactos> mostrarContactos(){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Contactos> listaContactos = new ArrayList();
        Contactos contacto = null;
        Cursor cursorContactos = null;

        cursorContactos = db.rawQuery("SELECT * FROM "+TABLE_CONTACTOS,null);
        if(cursorContactos.moveToFirst()){
            do{
                contacto = new Contactos();
                contacto.setId(cursorContactos.getInt(0));
                contacto.setNombre(cursorContactos.getString(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo(cursorContactos.getString(3));
                listaContactos.add(contacto);
            } while ( cursorContactos.moveToNext());
        }
        cursorContactos.close();
        return listaContactos;
    } */

}
