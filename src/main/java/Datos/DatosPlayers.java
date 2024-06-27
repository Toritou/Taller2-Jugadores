package Datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DatosPlayers {
    private Map<String, String[]> playersPorPais;
    private String rutaDirectorio;

    public DatosPlayers(String rutaDirectorio) {
        this.rutaDirectorio = rutaDirectorio;
        playersPorPais = new HashMap<>();
        cargarDatos();
    }

    private void cargarDatos() {
        try {
            // Cargar datos para cada país desde archivos
            cargarDatosPorPais("chile.txt");
            cargarDatosPorPais("australia.txt");
            cargarDatosPorPais("camerun.txt");
            cargarDatosPorPais("alemania.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarDatosPorPais(String archivo) throws IOException {
        String pais = archivo.substring(0, archivo.indexOf("."));
        String rutaArchivo = rutaDirectorio + "/" + archivo;
        BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
        String linea;
        StringBuilder jugadores = new StringBuilder();
        while ((linea = br.readLine()) != null) {
            jugadores.append(linea).append("\n");
        }
        br.close();
        playersPorPais.put(pais, jugadores.toString().split(";"));
    }

    public String[] obtenerJugadoresPorPais(String pais) {
        return playersPorPais.get(pais);
    }
}
