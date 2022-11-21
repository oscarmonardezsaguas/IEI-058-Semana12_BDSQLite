package com.example.semana12_bdsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.semana12_bdsqlite.db.DBHelper;
import com.example.semana12_bdsqlite.db.dbContactos;

public class NewActivity extends AppCompatActivity {
    EditText txtNombre, txtTelefono, txtCorreo;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtCorreo = findViewById(R.id.txtCorreo);
        btnGuarda = findViewById(R.id.btnGuardar);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbContactos dbContactos = new dbContactos(NewActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtCorreo.getText().toString());
                if (id > 0) {
                    Toast.makeText(NewActivity.this, "Registro guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {
                    Toast.makeText(NewActivity.this, "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // metodo limpar TextPlain
    private void limpiar() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }

}