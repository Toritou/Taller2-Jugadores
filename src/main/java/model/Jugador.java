package model;

public class Jugador {
    private int numero;
    private String nombre;
    private String posicion;

    public Jugador(int numero, String nombre, String posicion) {
        this.numero = numero;
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }
}
