package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroRot13 implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro ROT13";
    }

    @Override
    public int getPrioridad() {
        return 35;
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
        // No se necesita estado para este filtro
    }

    @Override
    public String aplicar(String texto) {
        if (texto == null) {
            return null;
        }
        StringBuilder resultado = new StringBuilder();
        for (char c : texto.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                resultado.append((char) ('a' + (c - 'a' + 13) % 26));
            } else if (c >= 'A' && c <= 'Z') {
                resultado.append((char) ('A' + (c - 'A' + 13) % 26));
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    @Override
    public String explicar() {
        return "Aplica el cifrado ROT13 al texto, rotando cada letra 13 posiciones en el alfabeto.";
    }
}
