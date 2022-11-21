package com.example.semana12_bdsqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.Toast;

import com.example.semana12_bdsqlite.db.DBHelper;
import com.example.semana12_bdsqlite.db.dbContactos;
import com.example.semana12_bdsqlite.entidades.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /* RecyclerView listaContactos; */
    /*ArrayList<Contactos> listaArrayContactos; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*=findViewById(R.id.listaContactos); */
        /* listaContactos.setLayoutManager(new LinearLayoutManager(this)); */

        /*dbContactos dbContactos = new dbContactos (MainActivity.this); */
        /*listaArrayContactos = new ArrayList<>(); */

        /* ListaContactosAdapter adapter = new ListaContactosAdapter(dbContactos.mostrarContactos()); */
        /*listaContactos.setAdapter(adapter); */
    }

    // muestra el menu de globo
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return  true;
    }

    // muestra el resultado de la seleccion del menu
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;
            case R.id.crearBase:
                crearBase();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //
    private void nuevoRegistro(){
        Intent intent = new Intent(this, NewActivity.class);
        startActivity(intent);
    }

    //
    private void crearBase(){
        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null) {
            Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Error al crear base de datos", Toast.LENGTH_LONG).show();
        }
    }

}