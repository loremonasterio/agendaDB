package com.telefonica.agenda.db;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class Anadir extends AppCompatActivity {

    ArrayList<Contacto> agenda;

    //AccesoFichero accesofichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //accesofichero = new AccesoFichero(this,"contactos.txt");
        //agenda = accesofichero.recuperarContactos();
    }

    public void anadirContacto(View v){
        EditText nombre = (EditText) this.findViewById(R.id.anadirInputNombre);
        EditText email = (EditText) this.findViewById(R.id.anadirInputEmail);
        EditText edad = (EditText) this.findViewById(R.id.anadirInputEdad);
        //accesofichero.guardarContacto(25,"lore@lore.com","lore");
        //accesofichero.guardarContacto(Integer.parseInt(edad.getText().toString()),email.getText().toString(),nombre.getText().toString());
        DBContactos adp=new DBContactos(this);
        adp.altaContacto(nombre.getText().toString(),email.getText().toString(),Integer.parseInt(edad.getText().toString()));
        adp.close();
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        General.menu(this, id);

        return super.onOptionsItemSelected(item);
    }

}
