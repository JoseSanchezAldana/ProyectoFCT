package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyVehicleWindow extends JFrame {

	private JTextField marcaField;
	private JTextField modeloField;
	private JTextField matriculaField;
	private JTextField anoMatriculacionField;
	private JButton cancelButton;
	private JButton modifyButton;

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	public JButton getModifyButton() {
		return modifyButton;
	}

	public void setModifyButton(JButton modifyButton) {
		this.modifyButton = modifyButton;
	}

	public ModifyVehicleWindow(String marca, String modelo, String matricula, int anoMatriculacion) {
		setTitle("Modificar Vehículo");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(43, 43, 43));

		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 2));
		formPanel.setBackground(new Color(43, 43, 43));
		formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JLabel marcaLabel = new JLabel("Marca:");
		marcaLabel.setForeground(Color.WHITE);
		marcaField = new JTextField(marca);
		JLabel modeloLabel = new JLabel("Modelo:");
		modeloLabel.setForeground(Color.WHITE);
		modeloField = new JTextField(modelo);
		JLabel matriculaLabel = new JLabel("Matrícula:");
		matriculaLabel.setForeground(Color.WHITE);
		matriculaField = new JTextField(matricula);
		JLabel anoMatriculacionLabel = new JLabel("Año de Matriculación:");
		anoMatriculacionLabel.setForeground(Color.WHITE);
		anoMatriculacionField = new JTextField(String.valueOf(anoMatriculacion));

		formPanel.add(marcaLabel);
		formPanel.add(marcaField);
		formPanel.add(modeloLabel);
		formPanel.add(modeloField);
		formPanel.add(matriculaLabel);
		formPanel.add(matriculaField);
		formPanel.add(anoMatriculacionLabel);
		formPanel.add(anoMatriculacionField);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.setBackground(new Color(43, 43, 43));

		modifyButton = new JButton("Modificar");
		modifyButton.setBackground(new Color(84, 84, 84));
		modifyButton.setForeground(Color.WHITE);

		cancelButton = new JButton("Cancelar");
		cancelButton.setBackground(new Color(84, 84, 84));
		cancelButton.setForeground(Color.WHITE);

		buttonPanel.add(modifyButton);
		buttonPanel.add(cancelButton);

		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(mainPanel);
	}

	public JTextField getMarcaField() {
		return marcaField;
	}

	public void setMarcaField(JTextField marcaField) {
		this.marcaField = marcaField;
	}

	public JTextField getModeloField() {
		return modeloField;
	}

	public void setModeloField(JTextField modeloField) {
		this.modeloField = modeloField;
	}

	public JTextField getMatriculaField() {
		return matriculaField;
	}

	public void setMatriculaField(JTextField matriculaField) {
		this.matriculaField = matriculaField;
	}

	public JTextField getAnoMatriculacionField() {
		return anoMatriculacionField;
	}

	public void setAnoMatriculacionField(JTextField anoMatriculacionField) {
		this.anoMatriculacionField = anoMatriculacionField;
	}
}
