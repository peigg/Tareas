package com.dam.tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.tareas.db.DbTareas;
import com.dam.tareas.db.DbUsuarios;

public class TareasActivity extends AppCompatActivity {

    EditText txtTitle,txtDescripcion;
    Button btnRegistroTarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas);

        txtTitle= findViewById(R.id.txtTitle);
        txtDescripcion= findViewById(R.id.txtdescripcion);
        btnRegistroTarea= findViewById(R.id.btnRegistroTarea);
        btnRegistroTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbTareas dbtareas = new DbTareas(TareasActivity.this);
                long id = DbTareas.AddTarea(TareasActivity.this,txtTitle.getText().toString(),txtDescripcion.getText().toString());
                if (id>0) {
                    Toast.makeText(TareasActivity.this,"Registro guardado",Toast.LENGTH_LONG).show();
                    clean();

                }else {
                    Toast.makeText(TareasActivity.this,"Error al registrar la tarea",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void clean(){
        txtTitle.setText("");
        txtDescripcion.setText("");

    }

}