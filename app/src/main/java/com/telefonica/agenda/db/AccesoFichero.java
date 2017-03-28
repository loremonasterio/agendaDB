package com.telefonica.agenda.db;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by telefonica on 24/03/2017.
 */

public class AccesoFichero {
    private Context contexto;
    private String nombre;
    //se proporciona el contexto y el nombre del fichero
    //durante la creación del objeto
    public AccesoFichero(Context contexto, String nombre){
        this.contexto=contexto;
        this.nombre=nombre;
    }
    public void guardarContacto(int edad, String email, String nombre2 ){
        FileOutputStream fos= null;
        PrintStream out=null;
        String contactoCompleto = edad+"|"+email+"|"+nombre2;
        try {
            //guardamos la nota en modo append para
            //añadirla a las ya existentes
            fos = contexto.openFileOutput(nombre, Context.MODE_APPEND);
            out=new PrintStream(fos);
            out.println(contactoCompleto);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }//fin método

    public ArrayList<Contacto> recuperarContactos(){
        ArrayList<Contacto> contactos =new ArrayList<>();
        FileInputStream fis=null;
        BufferedReader bf=null;
        try{
            fis=contexto.openFileInput(nombre);
            bf=new BufferedReader(new InputStreamReader(fis));
            System.out.println("Entramos en recuperar contactos");
            String linea;
            String nombreAGuardar="";
            String edad="";
            String email="";
            //recorremos linea por línea y extraemos las notas
            //como texto, por eso se convirten a Double
            while((linea=bf.readLine())!=null){
                StringTokenizer tokens = new StringTokenizer(linea,"|");
                while(tokens.hasMoreTokens()){
                    edad=tokens.nextToken();
                    email=tokens.nextToken();
                    nombreAGuardar=tokens.nextToken();
                }
                Contacto contactoNuevo = new Contacto(Integer.parseInt(edad),email,nombreAGuardar);
                contactos.add(contactoNuevo);

            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return contactos;
    }//fin método
    public void limpiarFichero(){
        FileOutputStream fos= null;
        //para limpiar el fichero, basta con abrirlo
        //en modo sobrescritura y se eliminará todo
        //su contenido
        try {
            fos = contexto.openFileOutput(nombre, Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }//fin método
} //fin clase