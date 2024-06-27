package vista;

import model.Equipo;
import model.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaJugadores {
    private JFrame frame;
    private JTable tableJugadores;

    public VistaJugadores(Equipo equipo) {
        initialize(equipo);
    }

    private void initialize(Equipo equipo) {
        frame = new JFrame("Players");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblFormacion = new JLabel("Official formation");
        lblFormacion.setBounds(10, 14, 150, 14);
        frame.getContentPane().add(lblFormacion);

        String[] columnNames = {"Number", "Name", "Position"};
        Object[][] data = new Object[equipo.getJugadores().size()][3];
        int i = 0;
        for (Jugador jugador : equipo.getJugadores()) {
            data[i][0] = jugador.getNumero();
            data[i][1] = jugador.getNombre();
            data[i][2] = jugador.getPosicion();
            i++;
        }
        tableJugadores = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableJugadores);
        scrollPane.setBounds(10, 40, 400, 150);
        frame.getContentPane().add(scrollPane);

        JButton btnEditPlayer = new JButton("Edit player");
        btnEditPlayer.setBounds(10, 200, 100, 23);
        frame.getContentPane().add(btnEditPlayer);

        JButton btnSaveChanges = new JButton("Save changes");
        btnSaveChanges.setBounds(120, 200, 120, 23);
        frame.getContentPane().add(btnSaveChanges);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250, 200, 89, 23);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.getContentPane().add(btnBack);

        frame.setVisible(true);
    }
}
