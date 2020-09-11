package com.example.theheroproyect;

import java.util.HashMap;

public class SuperHeroe {
    int id;
    String nombre;
    String alterego;
    HashMap Habilidades=new HashMap();

    public SuperHeroe(int id,String alterego,String nombre) {
        this.id = id;
        this.alterego=alterego;
        this.nombre=nombre;
    }

    public SuperHeroe() {
    }

    public void setHabilidades(HashMap habilidades) {
        Habilidades = habilidades;
    }

}
