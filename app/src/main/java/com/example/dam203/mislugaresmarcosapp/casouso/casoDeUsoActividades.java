package com.example.dam203.mislugaresmarcosapp.casouso;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.dam203.mislugaresmarcosapp.presentacion.AcercaDeActivity;

/**
 * Created by dam203 on 23/10/2019.
 */

public class casoDeUsoActividades {

    private Activity activity;
    //no necesita la lista de lugares
    //pero si la actividad


    public casoDeUsoActividades(Activity activity) {
        this.activity = activity;
    }

    public void lanzarAcercaDe(View view){

        Intent i = new Intent(activity, AcercaDeActivity.class);
        activity.startActivity(i);
    }


    public void lanzarPreferencias(View view) {
        Toast mensa = Toast.makeText(activity,
                "Marcos Cardeiro: Opción casoDeUsoActividades en construccion", Toast.LENGTH_SHORT);
        mensa.show();

        //Intent i = new Intent(actividad, ACercaDeActivity.class);
        //actividad.startActivity(i);
    }

    public void lanzarMapas(View view) {

        Toast mensa = Toast.makeText(activity,
                "Marcos Cardeiro: Opción casoDeUsoActividades en construccion", Toast.LENGTH_SHORT);
        mensa.show();
        //Intent i = new Intent(actividad, ACercaDeActivity.class);
        //actividad.startActivity(i);
    }
}