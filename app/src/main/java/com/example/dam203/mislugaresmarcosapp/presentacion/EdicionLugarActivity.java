package com.example.dam203.mislugaresmarcosapp.presentacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dam203.mislugaresmarcosapp.R;
import com.example.dam203.mislugaresmarcosapp.casouso.casoUsoLugares;
import com.example.dam203.mislugaresmarcosapp.modelo.Lugar;

import java.text.DateFormat;
import java.util.Date;

public class EdicionLugarActivity extends AppCompatActivity {
    /***************************
     * interfaz grafica
     * **************************/
    private EditText nombre;
    private EditText direccion;
    private EditText telefono;
    private EditText url;
    private EditText comentario;
    //1.- declaro spinner
    private Spinner tipo;
    /***************************
     * datos
     * **************************/
    private casoUsoLugares usoLugar;
    private int pos;
    private Lugar lugar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion_lugar);
        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos", 0);
        usoLugar = new casoUsoLugares(this, ((Aplicacion) getApplication()).getLugares());//-------------
        /*Recupero el lugar segun su posicion*/
        lugar = usoLugar.retornar(pos);
        actualizaVistas();

    }

    public void actualizaVistas() {
        nombre = findViewById(R.id.nombre);
        nombre.setText(lugar.getNombre());
         direccion = findViewById(R.id.direccion);
        direccion.setText(lugar.getDireccion());
        telefono = findViewById(R.id.telefono);
        telefono.setText(Integer.toString(lugar.getTelefono()));
        url = findViewById(R.id.url);
        url.setText(lugar.getUrl());
        comentario = findViewById(R.id.comentario);
        comentario.setText(lugar.getComentario());
    }
}
