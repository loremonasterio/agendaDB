package com.telefonica.agenda.db;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    AccesoFichero accesofichero;

    ArrayList<Contacto> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
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
        accesofichero = new AccesoFichero(this,"contactos.txt");
        agenda = accesofichero.recuperarContactos();

    }

    public void anadir(View v){
        Intent intent = new Intent(this, Anadir.class);
        this.startActivityForResult(intent,1);
        //System.out.println("LORENA Entra");

    }
    public void buscar(View v){
        Intent intent = new Intent(this, Buscar.class);
        this.startActivityForResult(intent,1);

    }
    public void ver_todos(View v){
        Intent intent = new Intent(this, Todos.class);
        this.startActivityForResult(intent,1);
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

   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==0){
            agenda = (ArrayList<Contacto>)data.getSerializableExtra("agenda");
        }else{
            System.out.println("ERROR al recibir agenda");
        }
    }*/
}
