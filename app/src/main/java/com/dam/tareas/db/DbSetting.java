package com.dam.tareas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbSetting extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "tareas.db";
    public static final String TABLE_USUARIOS = "Usuarios";
    public static final String TABLE_TAREAS = "Tareas";

    public DbSetting(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos tabla usuarios
        String createUsuariosTableQuery = "CREATE TABLE " + TABLE_USUARIOS + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL, " +
                "correo TEXT NOT NULL, " +
                "contraseña TEXT NOT NULL) ";
        db.execSQL(createUsuariosTableQuery);

        //Creamos Tabla de tareas
        String createTareasTableQuery = "CREATE TABLE " + TABLE_TAREAS + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT NOT NULL, " +
                "descripcion TEXT NOT NULL ) ";
        db.execSQL(createTareasTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TAREAS);
        onCreate(sqLiteDatabase);
    }
}
