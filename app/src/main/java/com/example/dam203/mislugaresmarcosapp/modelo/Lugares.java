package com.example.dam203.mislugaresmarcosapp.modelo;

import com.example.dam203.mislugaresmarcosapp.modelo.GeoPunto;
import com.example.dam203.mislugaresmarcosapp.modelo.Lugar;

public interface Lugares {
    final static String TAG = "MisLugares";
    static GeoPunto posicionActual = new GeoPunto(0,0);

    Lugar elemento(int id); //Devuelve el elemento dado su id
    void anyade(Lugar lugar); //Añade el elemento indicado
    int nuevo(); //Añade un elemento en blanco y devuelve su id
    void borrar(int id); //Elimina el elemento con el id indicado
    int tamanyo(); //Devuelve el número de elementos
    void actualiza(int id, Lugar lugar); //Reemplaza un elemento
}