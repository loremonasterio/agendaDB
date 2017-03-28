package com.telefonica.agenda.db;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class Todos extends AppCompatActivity {

    //ArrayList<Contacto> agenda;
    ArrayList<String> nombresAgenda = new ArrayList<String>();
    //AccesoFichero accesofichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
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

        DBContactos adp=new DBContactos(this);
        Cursor c=adp.recuperarContacto();
        String [] columns=new String[]{"nombre","email","edad"};
        int[] views=new int[]{R.id.nombre,R.id.email,R.id.edad};
        SimpleCursorAdapter sc= new SimpleCursorAdapter(
                this,
                R.layout.content_todos2,
                c,
                columns,
                views,
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        ListView lista=(ListView)findViewById(R.id.listaContactos);
        lista.setAdapter(sc);
        adp.close();
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
    /*
    public void verTodos(){
        TextView resultado = (TextView) this.findViewById(R.id.verTodosResultado);
        for(int i = 0; i < agenda.size(); i++){
            resultado.setText(resultado.getText()+agenda.get(i).toString());
        }
    }*/

    public void volver(View v){
        //Para volver a la actividad principal terminamos esta actividad lo que la destruye
        this.finish();
    }

}
