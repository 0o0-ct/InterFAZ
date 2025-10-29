package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroHashtag implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro Hashtag";
    }

    @Override
    public int getPrioridad() {
        return 45;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        String[] palabras = texto.split(" ");
        for (String palabra : palabras) {
            if (palabra.length() > 5) {
                return true;
            }
        }
        return false;
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
        String[] palabras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            if (palabra.length() > 5) {
                resultado.append("#").append(palabra).append(" ");
            } else {
                resultado.append(palabra).append(" ");
            }
        }
        return resultado.toString().trim();
    }

    @Override
    public String explicar() {
        return "Convierte palabras con más de 5 letras en hashtags (ej. #Palabra).";
    }
}
