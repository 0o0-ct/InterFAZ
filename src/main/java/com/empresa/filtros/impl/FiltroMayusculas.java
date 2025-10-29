package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroMayusculas implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro mayúsculas";
    }

    @Override
    public int getPrioridad() {
        return 20;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return !texto.equals(texto.toUpperCase());
    }

    @Override
    public void reiniciar() {
        // No se necesita estado para este filtro
    }

    @Override
    public String aplicar(String texto) {
        if (texto == null) {
            return null;
        }
        return texto.toUpperCase();
    }

    @Override
    public String explicar() {
        return "Convierte todo el texto a mayúsculas.";
    }
}
