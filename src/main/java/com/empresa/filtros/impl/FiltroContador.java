package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroContador implements Filtro {

    private int contador = 0;

    @Override
    public String getNombre() {
        return "Filtro contador";
    }

    @Override
    public int getPrioridad() {
        return 99;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        return texto != null;
    }

    @Override
    public void reiniciar() {
        contador = 0;
    }

    @Override
    public String aplicar(String texto) {
        if (texto == null) {
            return null;
        }
        contador++;
        return texto + " [aplicado:" + contador + "]";
    }

    @Override
    public String explicar() {
        return "Anexa un contador al final del texto, que se incrementa con cada aplicación.";
    }
}
