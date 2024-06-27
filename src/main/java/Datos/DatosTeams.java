package Datos;

import java.util.ArrayList;
import java.util.List;

public class DatosTeams {
    private String[] chile = new String[4];
    private String[] australia = new String[4];
    private String[] camerun = new String[4];
    private String[] alemania = new String[4];

    public DatosTeams(String[] chile, String[] australia, String[] camerun, String[] alemania){
        this.chile = chile;
        this.australia = australia;
        this.camerun = camerun;
        this.alemania = alemania;
    }

    public void llenarArreglos(){
        List<DatosTeams> paises = new ArrayList<>();
        ManejoTXT datosPaises = new ManejoTXT();
        paises = datosPaises.cargarSelecciones("datos/teams.txt");

    }

}