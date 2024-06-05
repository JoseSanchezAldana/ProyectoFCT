package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateAssignmentsWindow extends JFrame {

    private JComboBox<String> vehiculoComboBox;
    private JComboBox<String> conductorComboBox;
    private JTextField fechaField;
    private JButton assignButton;
    private JButton cancelButton;

    public CreateAssignmentsWindow() {
        setTitle("Asignar Vehículo");
        setSize(480, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setVisible(true);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(43, 43, 43));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2));
        formPanel.setBackground(new Color(43, 43, 43));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel vehiculoLabel = new JLabel("Vehículo:");
        vehiculoLabel.setForeground(Color.WHITE);
        vehiculoComboBox = new JComboBox<>();
        JLabel conductorLabel = new JLabel("Conductor:");
        conductorLabel.setForeground(Color.WHITE);
        conductorComboBox = new JComboBox<>();
        JLabel fechaLabel = new JLabel("Fecha de Asignación: (YYYY-MM-DD)");
        fechaLabel.setForeground(Color.WHITE);
        fechaField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        formPanel.add(vehiculoLabel);
        formPanel.add(vehiculoComboBox);
        formPanel.add(conductorLabel);
        formPanel.add(conductorComboBox);
        formPanel.add(fechaLabel);
        formPanel.add(fechaField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(43, 43, 43));

        assignButton = new JButton("Asignar");
        assignButton.setBackground(new Color(84, 84, 84));
        assignButton.setForeground(Color.WHITE);

        cancelButton = new JButton("Cancelar");
        cancelButton.setBackground(new Color(84, 84, 84));
        cancelButton.setForeground(Color.WHITE);

        buttonPanel.add(assignButton);
        buttonPanel.add(cancelButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public JComboBox<String> getVehiculoComboBox() {
        return vehiculoComboBox;
    }

    public void setVehiculoComboBox(JComboBox<String> vehiculoComboBox) {
        this.vehiculoComboBox = vehiculoComboBox;
    }

    public JComboBox<String> getConductorComboBox() {
        return conductorComboBox;
    }

    public void setConductorComboBox(JComboBox<String> conductorComboBox) {
        this.conductorComboBox = conductorComboBox;
    }

    public JTextField getFechaField() {
        return fechaField;
    }

    public void setFechaField(JTextField fechaField) {
        this.fechaField = fechaField;
    }

    public JButton getAssignButton() {
        return assignButton;
    }

    public void setAssignButton(JButton assignButton) {
        this.assignButton = assignButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }
}
