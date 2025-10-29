package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroAlternadorMayusMinus implements Filtro {

    private boolean aMayusculas = true;

    @Override
    public String getNombre() {
        return "Filtro alternador mayúsculas/minúsculas";
    }

    @Override
    public int getPrioridad() {
        return 95;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.matches(".*[a-zA-Z].*");
    }

    @Override
    public void reiniciar() {
        aMayusculas = true;
    }

    @Override
    public String aplicar(String texto) {
        if (texto == null) {
            return null;
        }
        String resultado;
        if (aMayusculas) {
            resultado = texto.toUpperCase();
        } else {
            resultado = texto.toLowerCase();
        }
        aMayusculas = !aMayusculas;
        return resultado;
    }

    @Override
    public String explicar() {
        return "Alterna entre convertir el texto a mayúsculas y minúsculas en cada llamada.";
    }
}
