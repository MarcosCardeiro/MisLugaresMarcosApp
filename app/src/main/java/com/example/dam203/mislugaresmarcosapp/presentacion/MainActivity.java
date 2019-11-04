package com.example.dam203.mislugaresmarcosapp.presentacion;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.dam203.mislugaresmarcosapp.R;
import com.example.dam203.mislugaresmarcosapp.casouso.casoDeUsoActividades;
import com.example.dam203.mislugaresmarcosapp.casouso.casoUsoLugares;

public class MainActivity extends AppCompatActivity {
    /*Estado Main*/

    private casoDeUsoActividades usoAplicacion;

    private casoUsoLugares usoLugares;

    /*Comportamiento*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usoAplicacion = new casoDeUsoActividades(this);
        usoLugares = new casoUsoLugares(this,((Aplicacion)getApplication()).getLugares());

        //setContentView(R.layout.activity_edicion_lugar); esto no se toca

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        boolean correcto = true;

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.menu_acercade:
                actividadAcercaDe(null);
                break;
            case R.id.menu_buscar:
                actividadVistaLugar(null);
                break;
            case R.id.menu_preferencias:
                actividadPreferencias(null);
                break;
            default:
                Toast mensa = Toast.makeText(this, "Marcos Cardeiro: Opción en construccion",
                        Toast.LENGTH_SHORT);
                mensa.show();

                correcto = super.onOptionsItemSelected(item);

                break;
        }
        return correcto;
    }

    public void actividadAcercaDe(View view){
        usoAplicacion.lanzarAcercaDe(view);
    }

    public void pararAplicacion(View view){
        finish();
    }

    public void actividadPreferencias(View view){
        usoAplicacion.lanzarPreferencias(view);
    }

    public void actividadVistaLugar(View view){
        final EditText entrada = new EditText(this);
        //bloqueamos a numeros
        entrada.setInputType(InputType.TYPE_CLASS_NUMBER);
        entrada.setText("0");
        new AlertDialog.Builder(this)
                .setTitle("Selección de lugar")
                .setMessage("indica su id:")
                .setView(entrada)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        int id= Integer.parseInt (entrada.getText().toString());
                        if (id<usoLugares.numeroLugares())
                            usoLugares.mostrar(id);
                            //desde aquí no se puede enviar un toast
                        else smsErrores("Marcos Cardeiro Rodríguez: Posicion no existe");
                    }})
                .setNegativeButton("Cancelar", null)
                .show();
    }

    public void smsErrores(String error){
        Toast mensa = Toast.makeText(this, error,
                Toast.LENGTH_SHORT);
        mensa.show();

    }

}
