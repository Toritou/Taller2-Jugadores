package data;

import model.Equipo;
import model.Jugador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InfoJugador {
    public static List<Equipo> cargarEquipos() {
        List<Equipo> equipos = new ArrayList<>();
        String path = "src/main/java/data/EquipoTXT/teams.txt";
        System.out.println("Intentando cargar archivo desde: " + new java.io.File(path).getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");
                if (datos.length != 4) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                String nombre = datos[1];
                int rankingFIFA;
                try {
                    rankingFIFA = Integer.parseInt(datos[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Número de ranking FIFA inválido en la línea: " + linea);
                    continue;
                }

                Equipo equipo = new Equipo(nombre, rankingFIFA);
                equipos.add(equipo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return equipos;
    }

    public static List<Jugador> cargarJugadores(String nombreEquipo) {
        List<Jugador> jugadores = new ArrayList<>();
        String path = "src/main/java/data/TXT/" + nombreEquipo.toLowerCase() + ".txt";
        System.out.println("Intentando cargar archivo desde: " + new java.io.File(path).getAbsolutePath());
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(";");
                if (datos.length != 3) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                int numero;
                try {
                    numero = Integer.parseInt(datos[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Número de jugador inválido en la línea: " + linea);
                    continue;
                }

                String nombre = datos[1];
                String posicion = datos[2];

                Jugador jugador = new Jugador(numero, nombre, posicion);
                jugadores.add(jugador);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jugadores;
    }
}
