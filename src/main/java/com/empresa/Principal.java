package com.empresa;

import com.empresa.filtros.Filtro;
import com.empresa.filtros.impl.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        String textoOriginal = "   Hola qué tal,    este es un texto de prueba con acentos y caracteres especiales.   ";

        // Crear una lista de todos los filtros disponibles
        List<Filtro> filtros = new ArrayList<>();
        filtros.add(new FiltroTrimMultiEspacios());
        filtros.add(new FiltroNormalizarAcentos());
        filtros.add(new FiltroSoloASCII());
        filtros.add(new FiltroMayusculas());
        filtros.add(new FiltroMinusculas());
        filtros.add(new FiltroTitulo());
        filtros.add(new FiltroSinVocales());
        filtros.add(new FiltroRot13());
        filtros.add(new FiltroLeet());
        filtros.add(new FiltroCensurador());
        filtros.add(new FiltroURLify());
        filtros.add(new FiltroHashtag());
        filtros.add(new FiltroContador());
        filtros.add(new FiltroCacheUltimaEntrada());
        filtros.add(new FiltroAlternadorMayusMinus());
        filtros.add(new FiltroEmoji());
        filtros.add(new FiltroNumeradorPalabras());
        filtros.add(new FiltroSufijoFecha());

        System.out.println("Texto original: \"" + textoOriginal + "\"\n");
        System.out.println("--- Lista de Filtros Disponibles ---");

        // Informar sobre cada filtro
        for (Filtro filtro : filtros) {
            System.out.println("Filtro: " + filtro.getNombre() +
                               " | Prioridad: " + filtro.getPrioridad() +
                               " | Soportado: " + (filtro.puedeAplicar(textoOriginal) ? "Sí" : "No") +
                               " | Explicación: " + filtro.explicar());
        }

        // Ordenar los filtros por prioridad
        Collections.sort(filtros);

        System.out.println("\n--- Aplicando Filtros por Orden de Prioridad ---");
        String textoProcesado = textoOriginal;
        for (Filtro filtro : filtros) {
            if (filtro.puedeAplicar(textoProcesado)) {
                String textoAnterior = textoProcesado;
                textoProcesado = filtro.aplicar(textoProcesado);
                System.out.println("Aplicando filtro '" + filtro.getNombre() + "': \"" + textoProcesado + "\"");
            }
        }

        System.out.println("\n--- Resultado Final ---");
        System.out.println("Texto original:   \"" + textoOriginal + "\"");
        System.out.println("Texto procesado:  \"" + textoProcesado + "\"");

        // Demostración de reinicio en filtros con estado
        System.out.println("\n--- Demostración de Reinicio de Filtros con Estado ---");
        FiltroContador contador = new FiltroContador();
        System.out.println("Aplicando contador 1ra vez: " + contador.aplicar("texto"));
        System.out.println("Aplicando contador 2da vez: " + contador.aplicar("texto"));
        contador.reiniciar();
        System.out.println("Reiniciando contador...");
        System.out.println("Aplicando contador después de reiniciar: " + contador.aplicar("texto"));
    }
}
