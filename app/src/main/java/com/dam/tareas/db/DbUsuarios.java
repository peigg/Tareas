package com.dam.tareas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUsuarios extends DbSetting {
    Context context;
    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public static long AddUsuario(Context context,String nombre, String correo, String contraseña){
        long id = 0;
        try {
            DbSetting dBsetting = new DbSetting(context);
            SQLiteDatabase db = dBsetting.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("correo", correo);
            values.put("contraseña", contraseña);

             id = db.insert(TABLE_USUARIOS, null, values);
        }catch (Exception ex){
            ex.toString();

        }
        return id;
    }
}
