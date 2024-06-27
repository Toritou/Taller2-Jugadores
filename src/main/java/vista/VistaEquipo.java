package vista;

import data.InfoJugador;
import model.Equipo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaEquipo {
    private JFrame frame;
    private JComboBox<String> comboBoxEquipos;
    private JTextField textFieldRanking;
    private List<Equipo> equipos;

    public VistaEquipo() {
        equipos = InfoJugador.cargarEquipos();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Teams");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblChooseTeam = new JLabel("Choose team:");
        lblChooseTeam.setBounds(10, 14, 80, 14);
        frame.getContentPane().add(lblChooseTeam);

        comboBoxEquipos = new JComboBox<>();
        for (Equipo equipo : equipos) {
            comboBoxEquipos.addItem(equipo.getNombre());
        }
        comboBoxEquipos.setBounds(100, 11, 150, 22);
        comboBoxEquipos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarEquipoSeleccionado();
            }
        });
        frame.getContentPane().add(comboBoxEquipos);

        JLabel lblRankingFifa = new JLabel("Ranking FIFA:");
        lblRankingFifa.setBounds(10, 50, 80, 14);
        frame.getContentPane().add(lblRankingFifa);

        textFieldRanking = new JTextField();
        textFieldRanking.setBounds(100, 47, 150, 20);
        textFieldRanking.setEditable(false);
        frame.getContentPane().add(textFieldRanking);
        textFieldRanking.setColumns(10);

        JButton btnPlayers = new JButton("Players");
        btnPlayers.setBounds(100, 80, 89, 23);
        btnPlayers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarJugadores();
            }
        });
        frame.getContentPane().add(btnPlayers);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(200, 80, 89, 23);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(btnExit);

        frame.setVisible(true);
    }

    private void actualizarEquipoSeleccionado() {
        String equipoSeleccionado = (String) comboBoxEquipos.getSelectedItem();
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(equipoSeleccionado)) {
                textFieldRanking.setText(String.valueOf(equipo.getRankingFIFA()));
            }
        }
    }

    private void mostrarJugadores() {
        String equipoSeleccionado = (String) comboBoxEquipos.getSelectedItem();
        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(equipoSeleccionado)) {
                new VistaJugadores(equipo);
            }
        }
    }

}
