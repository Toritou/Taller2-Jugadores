package model;

import data.InfoJugador;

import java.util.List;

public class Equipo {
    private String nombre;
    private int rankingFIFA;
    private List<Jugador> jugadores;

    public Equipo(String nombre, int rankingFIFA) {
        this.nombre = nombre;
        this.rankingFIFA = rankingFIFA;
        this.jugadores = InfoJugador.cargarJugadores(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
}
