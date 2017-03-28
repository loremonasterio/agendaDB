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
import android.widget.TextView;

public class Buscar extends AppCompatActivity {

    //ArrayList<Contacto> agenda;

    //AccesoFichero accesofichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
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

    public void volver(View v){
        //Para volver a la actividad principal terminamos esta actividad lo que la destruy
        this.finish();
    }

    public void buscar(View v){
        EditText email = (EditText) this.findViewById(R.id.buscarInputEmail);
        TextView resultado = (TextView) this.findViewById(R.id.buscarResultado);
        DBContactos db=new DBContactos(this);
        Contacto cont = db.recuperarContactoPorEmail(email.getText().toString());
        String s="";
        //si se encuentra el libro se muestran sus datos
        //si no, un mensaje de aviso
        if(cont!=null) {
            s += "Nombre: " + cont.getNombre() + " Email: " +
                    cont.getEmail() + " Edad: " + cont.getEdad();
        }else{
            s="Contacto no encontrado";
        }
        resultado.setText(s);
        db.close();
        /*
        if(agenda.size()==0){
            resultado.setText("Agenda vacia");
        }else{
            for(int i = 0; i < agenda.size(); i++){
                if(email.getText().toString().equals(agenda.get(i).getEmail())){
                    resultado.setText(agenda.get(i).toString());
                }else{
                    resultado.setText("No se ha encontrado el email");
                }
            }
        }*/
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
