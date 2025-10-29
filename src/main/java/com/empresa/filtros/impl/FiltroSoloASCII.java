package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroSoloASCII implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro solo ASCII";
    }

    @Override
    public int getPrioridad() {
        return 12;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return !texto.matches("\\A\\p{ASCII}*\\z");
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
        return texto.replaceAll("[^\\p{ASCII}]", "");
    }

    @Override
    public String explicar() {
        return "Elimina todos los caracteres que no pertenecen al conjunto ASCII.";
    }
}
