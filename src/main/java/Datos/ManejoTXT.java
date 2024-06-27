package Datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class ManejoTXT {

    // Método para leer un archivo de texto y mostrar su contenido
    public List<DatosTeams> cargarSelecciones(String rutaArchivo) {
        List<DatosTeams> equipos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    String index = datos[0];
                    String nombre = datos[1];
                    String posicion = datos[2];

                    // Dependiendo del índice, se agrega a un array específico
                    DatosTeams equipo;
                    if (index.equals("01")) {
                        equipo = new DatosTeams(new String[]{nombre, posicion}, null, null, null);
                    } else if (index.equals("02")) {
                        equipo = new DatosTeams(null, new String[]{nombre, posicion}, null, null);
                    } else if (index.equals("03")) {
                        equipo = new DatosTeams(null, null, new String[]{nombre, posicion}, null);
                    } else if (index.equals("04")) {
                        equipo = new DatosTeams(null, null, null, new String[]{nombre, posicion});
                    } else {
                        // Otra lógica para el índice desconocido
                        equipo = new DatosTeams(null, null, null, null);
                    }

                    equipos.add(equipo);
                } else {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return equipos;
    }

    // Método para escribir en un archivo de texto
    public  void escribirArchivo(String nombreArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true))) {
            bw.write(contenido);
            bw.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}