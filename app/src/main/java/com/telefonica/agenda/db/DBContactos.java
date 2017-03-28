package com.telefonica.agenda.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by telefonica on 27/03/2017.
 */

public class DBContactos {
    private static final String TABLA="contactos";
    //Atributos
    private SQLiteDatabase db=null;
    private DatabaseHelper dbhelper=null;
    //Contexto
    Context context;
    public DBContactos(Context ctx){
        this.context=ctx;
        //crea una instancia del helper
        dbhelper=new DatabaseHelper(context);
        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db=dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }
    public long altaContacto(String nombre, String email, int edad){
        //crea el contentvalues y añade una entrada
        //por cada dato del libro a añadir
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", nombre);
        initialValues.put("email", email);
        initialValues.put("edad", edad);
        return db.insert(TABLA, null, initialValues);
    }

    public boolean borrarContacto(int id){
        //elimina el libro a partir del id
        return db.delete(TABLA, "_id="+id, null)>0;
    }
    public Contacto recuperarContactoPorEmail(String email){
        float valor=0.0f;
        Contacto contacto=null;
        Cursor c=db.query(TABLA, new String[]{"_id", "nombre","edad"},"email=?", new String[]{email}, null,null,null);
        //el curso apunta a la posición anterior al primer registro
        //debe desplazarlo al siguiente registro para apuntar al primero
        if(c.moveToNext()){
            contacto=new Contacto(c.getInt(2),email,c.getString(1));
        }
        return contacto;
    }
    public Cursor recuperarContacto(){
        //aunque no se utilice, se debe recuperar también
        // el campo _id
        return db.query(TABLA, new String[]{"_id","nombre", "email","edad"},null, null, null,null,null);
    }

}


