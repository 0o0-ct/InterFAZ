package com.empresa.filtros;

public interface Filtro extends Comparable<Filtro> {
    String getNombre();
    int getPrioridad();
    boolean puedeAplicar(String texto);
    void reiniciar();
    String aplicar(String texto);
    String explicar();

    @Override
    default int compareTo(Filtro otro) {
        return Integer.compare(this.getPrioridad(), otro.getPrioridad());
    }
}
