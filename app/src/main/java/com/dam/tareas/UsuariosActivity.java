package com.dam.tareas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.tareas.db.DbUsuarios;

public class UsuariosActivity extends AppCompatActivity {

    EditText txtNombre,txtMail,txtPassword;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        txtNombre= findViewById(R.id.txtNombre);
        txtMail= findViewById(R.id.txtMail);
        txtPassword= findViewById(R.id.txtPassword);
        btnRegistro= findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbUsuarios dbUsuarios = new DbUsuarios(UsuariosActivity.this);
                long id = DbUsuarios.AddUsuario(UsuariosActivity.this,txtNombre.getText().toString(),txtMail.getText().toString(),txtPassword.getText().toString());
                if (id>0) {
                    Toast.makeText(UsuariosActivity.this,"Registro guardado",Toast.LENGTH_LONG).show();
                    clean();

                }else {
                    Toast.makeText(UsuariosActivity.this,"Error al registrar el usuario",Toast.LENGTH_LONG).show();
                }
                }
            });
        }

        private void clean(){
        txtNombre.setText("");
            txtMail.setText("");
            txtPassword.setText("");
        }

    }