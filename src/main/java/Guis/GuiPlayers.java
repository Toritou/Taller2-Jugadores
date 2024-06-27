package Guis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPlayers extends JFrame implements ActionListener {
    private JPanel panel;
    private JTextArea jugadoresDatos;
    private JButton editarBtn;
    private JButton guardarBtn;
    private JButton volverBtn;
    private JLabel topLabel;

    public GuiPlayers() {
        panel = new JPanel();
        panel.setLayout(null);

        topLabel = new JLabel("Player Data");
        topLabel.setBounds(20, 20, 150, 30);
        panel.add(topLabel);

        jugadoresDatos = new JTextArea();
        jugadoresDatos.setBounds(20, 60, 260, 300);
        panel.add(jugadoresDatos);

        editarBtn = new JButton("Edit");
        editarBtn.setBounds(20, 380, 80, 30);
        panel.add(editarBtn);

        guardarBtn = new JButton("Save");
        guardarBtn.setBounds(110, 380, 80, 30);
        panel.add(guardarBtn);

        volverBtn = new JButton("Back");
        volverBtn.setBounds(200, 380, 80, 30);
        panel.add(volverBtn);

        asignarEventos();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(300, 500);
        setVisible(true);
    }

    private void asignarEventos() {
        editarBtn.addActionListener(this);
        guardarBtn.addActionListener(this);
        volverBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == volverBtn) {
            GuiSelecciones guiSelecciones = new GuiSelecciones();
            guiSelecciones.setVisible(true);
            this.setVisible(false);
        }
    }

}
