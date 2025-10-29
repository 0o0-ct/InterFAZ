package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroTrimMultiEspacios implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro trim multi-espacios";
    }

    @Override
    public int getPrioridad() {
        return 8;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.contains("  ") || texto.startsWith(" ") || texto.endsWith(" ");
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
        return texto.trim().replaceAll("\\s+", " ");
    }

    @Override
    public String explicar() {
        return "Elimina espacios en blanco al principio y al final, y colapsa múltiples espacios en uno solo.";
    }
}
