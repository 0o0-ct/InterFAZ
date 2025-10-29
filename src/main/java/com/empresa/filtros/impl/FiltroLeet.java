package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroLeet implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro Leet";
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
        return texto.matches(".*[aeiosAEIOS].*");
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
        return texto.replaceAll("[aA]", "4")
                .replaceAll("[eE]", "3")
                .replaceAll("[iI]", "1")
                .replaceAll("[oO]", "0")
                .replaceAll("[sS]", "5");
    }

    @Override
    public String explicar() {
        return "Sustituye las letras a, e, i, o, s por los números 4, 3, 1, 0, 5 respectivamente.";
    }
}
