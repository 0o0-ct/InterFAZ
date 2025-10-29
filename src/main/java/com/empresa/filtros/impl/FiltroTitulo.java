package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroTitulo implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro título";
    }

    @Override
    public int getPrioridad() {
        return 25;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.contains(" ");
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
            if (palabra.length() > 0) {
                resultado.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return resultado.toString().trim();
    }

    @Override
    public String explicar() {
        return "Capitaliza la letra inicial de cada palabra en el texto.";
    }
}
