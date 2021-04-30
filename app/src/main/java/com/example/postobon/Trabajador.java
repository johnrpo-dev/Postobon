package com.example.postobon;

public class Trabajador {
    String nombreTrabajador;
    int fotoTrabajador;

    public Trabajador(String nombreTrabajador, int fotoTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
        this.fotoTrabajador = fotoTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public int getFotoTrabajador() {
        return fotoTrabajador;
    }

    public void setFotoTrabajador(int fotoTrabajador) {
        this.fotoTrabajador = fotoTrabajador;
    }
}
