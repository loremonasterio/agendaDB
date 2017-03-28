package com.telefonica.agenda.db;

import java.io.Serializable;

/**
 * Created by telefonica on 22/03/2017.
 */

public class Contacto implements Serializable {
    private int edad;
    private String email;
    private String nombre;

    public Contacto(int edad, String email, String nombre){
        this.edad = edad;
        this.email = email;
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Edad: " + edad +
                ", Email: " + email  +
                ", Nombre: " + nombre +
                '\n';
    }
}
