package com.example.dam203.mislugaresmarcosapp.presentacion;

import android.app.Application;
import android.content.SharedPreferences;

import com.example.dam203.mislugaresmarcosapp.modelo.LugaresVector;

/**
 * Created by dam203 on 21/10/2019.
 */

public class Aplicacion extends Application {
    private int saldo;
    private LugaresVector misLugares;

    @Override public void onCreate() {
        super.onCreate();
        SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
        saldo = pref.getInt("saldo_inicial", -1);

        misLugares = new LugaresVector();
    }

    public int getSaldo(){
        return saldo;
    }

    public void setSaldo(int saldo){
        this.saldo=saldo;
    }
    /*codigo que maneja los datos*/
    public LugaresVector getLugares() {
        return misLugares;
    }
}

