package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;
import java.text.Normalizer;

public class FiltroURLify implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro URLify";
    }

    @Override
    public int getPrioridad() {
        return 40;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return texto.contains(" ") || !texto.matches("[a-z0-9\\-]+");
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
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");
        return textoNormalizado.toLowerCase()
                .replaceAll("\\s+", "-")
                .replaceAll("[^a-z0-9\\-]", "");
    }

    @Override
    public String explicar() {
        return "Convierte el texto en un 'slug' para URL: minúsculas, espacios a guiones y elimina caracteres no permitidos.";
    }
}
