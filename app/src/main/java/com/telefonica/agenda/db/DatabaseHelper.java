package com.telefonica.agenda.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by telefonica on 27/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Agenda";
    private static final int DATABASE_VERSION=1;

    //sql de creación de tabla
    private static final String DATABASE_CREATE_LIBROS=
            "create table if not exists contactos (_id integer primary key autoincrement,"+
                    "nombre text not null, email text not null, edad int not null)";
    //sql eliminación de tabla
    private static final String DATABASE_DELETE_LIBROS=
            "drop table if exists contactos";
    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    //Se llama al crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {      //creamos las tablas
        createTables(db);
    }
    //este método es llamado si a la hora de crear el DataBaseHelper
    //se pasa una versión superior a la ya existente
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //reconstruimos la tabla
        deleteTables(db);
        createTables(db);

    }
    private void createTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_LIBROS);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_DELETE_LIBROS);
    }
}