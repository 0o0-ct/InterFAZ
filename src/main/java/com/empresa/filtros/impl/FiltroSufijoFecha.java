package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FiltroSufijoFecha implements Filtro {

    @Override
    public String getNombre() {
        return "Filtro sufijo de fecha";
    }

    @Override
    public int getPrioridad() {
        return 110;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        return texto != null;
    }

    @Override
    public void reiniciar() {
        // No es necesario reiniciar estado para este filtro
    }

    @Override
    public String aplicar(String texto) {
        if (texto == null) {
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return texto + " (" + dtf.format(now) + ")";
    }

    @Override
    public String explicar() {
        return "Agrega la fecha y hora actual al final del texto.";
    }
}
