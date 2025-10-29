package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;
import java.text.Normalizer;

public class FiltroNormalizarAcentos implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro normalizar acentos";
    }

    @Override
    public int getPrioridad() {
        return 5;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        return !Normalizer.isNormalized(texto, Normalizer.Form.NFD);
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
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("\\p{M}", "");
    }

    @Override
    public String explicar() {
        return "Quita los diacríticos (acentos) de las letras.";
    }
}
