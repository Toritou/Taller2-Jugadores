package Launcher;

import vista.VistaEquipo;

public class Launcher {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VistaEquipo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
