package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;
import java.util.Arrays;
import java.util.List;

public class FiltroCensurador implements Filtro {

    private final List<String> palabrasCensuradas = Arrays.asList("palabra1", "palabra2", "palabra3");

    @Override
    public String getNombre() {
        return "Filtro censurador";
    }

    @Override
    public int getPrioridad() {
        return 25; // Prioridad ajustable
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null || palabrasCensuradas.isEmpty()) {
            return false;
        }
        for (String palabra : palabrasCensuradas) {
            if (texto.toLowerCase().contains(palabra)) {
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
        for (String palabra : palabrasCensuradas) {
            texto = texto.replaceAll("(?i)" + palabra, "***");
        }
        return texto;
    }

    @Override
    public String explicar() {
        return "Reemplaza palabras de una lista predefinida con '***'.";
    }
}
