package com.example.dam203.mislugaresmarcosapp.casouso;

import android.app.Activity;
import android.content.Intent;

import com.example.dam203.mislugaresmarcosapp.modelo.Lugar;
import com.example.dam203.mislugaresmarcosapp.modelo.LugaresVector;
import com.example.dam203.mislugaresmarcosapp.presentacion.VistaLugarActivity;

/**
 * Created by dam203 on 23/10/2019.
 */

public class casoUsoLugares {
    private Activity actividad;
    private LugaresVector misLugares;

    public casoUsoLugares(Activity actividad,LugaresVector misLugares) {

        this.actividad = actividad;
        this.misLugares = misLugares;
    }

    public void mostrar(int pos) {
        Intent i = new Intent(actividad, VistaLugarActivity.class);
        i.putExtra("pos", pos);
        actividad.startActivity(i);
    }

    public Lugar retornar(int pos){
        return  misLugares.elemento(pos);
    }

    public int numeroLugares(){
        return misLugares.tamanyo();
    }

    public void eliminar(int pos){
        misLugares.borrar(pos);
    }
}
