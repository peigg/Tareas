package com.dam.tareas;



import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dam.tareas.db.DbSetting;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
/*
Botón usado para crear la base de datos al principio, ya no se le da mas uso, pero queda comentado el método usado para crearlo.
    Button btnInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        *btnInicio = findViewById(R.id.btnInicio);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DbSetting dBsetting = new DbSetting(MainActivity.this);
                SQLiteDatabase db = dBsetting.getWritableDatabase();
                if(db != null){
                   Toast.makeText(MainActivity.this, "Actividad iniciada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Error al iniciar actividad", Toast.LENGTH_LONG).show();
            }
        }

    });}

         */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuPrincipal) {
            newRegistro();
            return true;
        } else if (item.getItemId() == R.id.menuSecundario) {
            newRegistroTarea();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void newRegistro() {
        Intent intent = new Intent(this, UsuariosActivity.class);
        startActivity(intent);
    }

    private void newRegistroTarea() {
        Intent intent = new Intent(this, UsuariosActivity.class);
        startActivity(intent);
    }
}

