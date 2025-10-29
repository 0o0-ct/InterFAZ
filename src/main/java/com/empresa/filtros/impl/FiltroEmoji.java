package com.empresa.filtros.impl;

import com.empresa.filtros.Filtro;
import java.util.HashMap;
import java.util.Map;

public class FiltroEmoji implements Filtro {

    private final Map<String, String> mapaEmojis = new HashMap<>();

    public FiltroEmoji() {
        mapaEmojis.put("café", "☕");
        mapaEmojis.put("equipo", "👥");
        mapaEmojis.put("contrato", "📝");
    }

    @Override
    public String getNombre() {
        return "Filtro emoji";
    }

    @Override
    public int getPrioridad() {
        return 60;
    }

    @Override
    public boolean puedeAplicar(String texto) {
        if (texto == null) {
            return false;
        }
        for (String palabra : mapaEmojis.keySet()) {
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
        for (Map.Entry<String, String> entry : mapaEmojis.entrySet()) {
            texto = texto.replaceAll("(?i)" + entry.getKey(), entry.getKey() + " " + entry.getValue());
        }
        return texto;
    }

    @Override
    public String explicar() {
        return "Añade emojis a palabras clave (café, equipo, contrato).";
    }
}
