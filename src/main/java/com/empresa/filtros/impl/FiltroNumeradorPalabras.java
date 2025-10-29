package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroNumeradorPalabras implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro numerador de palabras";
    }

    @Override
    public int getPrioridad() {
        return 55;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.trim().split("\\s+").length >= 2;
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
        String[] palabras = texto.trim().split("\\s+");
        if (palabras.length < 2) {
            return texto;
        }
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabras.length; i++) {
            resultado.append(i + 1).append(":").append(palabras[i]).append(" ");
        }
        return resultado.toString().trim();
    }

    @Override
    public String explicar() {
        return "Prefija cada palabra con su índice (ej. '1:Hola 2:mundo').";
    }
}
