package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroSinVocales implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro sin vocales";
    }

    @Override
    public int getPrioridad() {
        return 30;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.matches(".*[aeiouáéíóúAEIOUÁÉÍÓÚ].*");
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
        return texto.replaceAll("[aeiouáéíóúAEIOUÁÉÍÓÚ]", "");
    }

    @Override
    public String explicar() {
        return "Elimina todas las vocales (a, e, i, o, u, á, é, í, ó, ú) del texto.";
    }
}
