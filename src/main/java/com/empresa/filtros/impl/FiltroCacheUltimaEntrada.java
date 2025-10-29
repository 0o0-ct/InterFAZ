package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;

public class FiltroCacheUltimaEntrada implements Filtro {

    private String ultimaEntrada = null;

    @Override
    public String getNombre() {
        return "Filtro caché última entrada";
    }

    @Override
    public int getPrioridad() {
        return 100;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        return texto != null;
    }

    @Override
    public void reiniciar() {
        ultimaEntrada = null;
    }

    @Override
    public String aplicar(String texto) {
        if (texto == null) {
            return null;
        }
        if (texto.equals(ultimaEntrada)) {
            return "(repetido)";
        }
        ultimaEntrada = texto;
        return texto;
    }

    @Override
    public String explicar() {
        return "Si la entrada es la misma que la anterior, devuelve '(repetido)'.";
    }
}
