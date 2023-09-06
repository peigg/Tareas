package com.dam.tareas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbTareas extends DbSetting {

    Context context;

    public DbTareas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public static long AddTarea(Context context,String titulo, String descripcion){
        long id = 0;
        try {
            DbSetting dBsetting = new DbSetting(context);
            SQLiteDatabase db = dBsetting.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            values.put("descripcion", descripcion);


            id = db.insert(TABLE_TAREAS, null, values);
        }catch (Exception ex){
            ex.toString();

        }
        return id;
    }
}

