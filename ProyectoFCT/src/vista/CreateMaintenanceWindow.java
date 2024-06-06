package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateMaintenanceWindow extends JFrame {

    private JComboBox<String> vehiculoComboBox;
    private JTextField tipoField;
    private JTextField fechaField;
    private JButton assignButton;
    private JButton cancelButton;

    public CreateMaintenanceWindow() {
        setTitle("Mantenimientos");
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
        JLabel tipoLabel = new JLabel("Tipo de mantenimiento:");
		tipoLabel.setForeground(Color.WHITE);
		tipoField = new JTextField();
        JLabel fechaLabel = new JLabel("Fecha del mantenimiento: (YYYY-MM-DD)");
        fechaLabel.setForeground(Color.WHITE);
        fechaField = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        formPanel.add(vehiculoLabel);
        formPanel.add(vehiculoComboBox);
        formPanel.add(tipoLabel);
        formPanel.add(tipoField);
        formPanel.add(fechaLabel);
        formPanel.add(fechaField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(43, 43, 43));

        assignButton = new JButton("Aceptar");
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

	public JTextField getTipoField() {
		return tipoField;
	}

	public void setTipoField(JTextField tipoField) {
		this.tipoField = tipoField;
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

