package Guis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiSelecciones extends JFrame implements ActionListener {
    private JPanel panel;
    private JComboBox<String> seleccionesCombo;
    private JButton playersBtn;
    private JButton exitBtn;

    public GuiSelecciones() {
        panel = new JPanel();
        panel.setLayout(null);

        seleccionesCombo = new JComboBox<>(new String[]{"Selecciona", "Chile", "Australia", "Camerun", "Alemania"});
        seleccionesCombo.setBounds(50, 50, 150, 30);
        panel.add(seleccionesCombo);

        playersBtn = new JButton("Players");
        playersBtn.setBounds(50, 350, 100, 30);
        panel.add(playersBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(160, 350, 100, 30);
        panel.add(exitBtn);

        asignarEventos();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 500);
        setVisible(true);
    }

    private void asignarEventos() {
        playersBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        seleccionesCombo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == exitBtn) {
            System.exit(0);
        } else if (event.getSource() == playersBtn) {
            GuiPlayers guiPlayers = new GuiPlayers();
            guiPlayers.setVisible(true);
            this.setVisible(false);
        }
    }
}
