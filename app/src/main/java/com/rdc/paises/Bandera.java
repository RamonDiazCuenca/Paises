package com.rdc.paises;

import android.widget.ImageView;

public class Bandera { // Creamos una clase Bandera donde se encontraran la imagen y el nombre de la bandera

    private int image;
    private CharSequence nombre;

    public Bandera(int image, CharSequence nombre) {
        this.image = image;
        this.nombre = nombre;
    }

    // Creamos los métodos getters para recuperar despúes la imagen y el nombre
    public int getImage() {
        return image;
    }

    public CharSequence getNombre() {
        return nombre;
    }
}
