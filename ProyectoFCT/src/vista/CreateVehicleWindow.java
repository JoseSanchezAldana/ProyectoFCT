package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateVehicleWindow extends JFrame {

	private JTextField marcaField;
	private JTextField modeloField;
	private JTextField matriculaField;
	private JTextField anoMatriculacionField;
	private JButton createButton;
	private JButton cancelButton;

	public CreateVehicleWindow() {
		setTitle("Crear Vehículo");
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
		marcaField = new JTextField();
		JLabel modeloLabel = new JLabel("Modelo:");
		modeloLabel.setForeground(Color.WHITE);
		modeloField = new JTextField();
		JLabel matriculaLabel = new JLabel("Matrícula:");
		matriculaLabel.setForeground(Color.WHITE);
		matriculaField = new JTextField();
		JLabel anoMatriculacionLabel = new JLabel("Año de Matriculación:");
		anoMatriculacionLabel.setForeground(Color.WHITE);
		anoMatriculacionField = new JTextField();

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

		createButton = new JButton("Crear");
		createButton.setBackground(new Color(84, 84, 84));
		createButton.setForeground(Color.WHITE);

		cancelButton = new JButton("Cancelar");
		cancelButton.setBackground(new Color(84, 84, 84));
		cancelButton.setForeground(Color.WHITE);

		buttonPanel.add(createButton);
		buttonPanel.add(cancelButton);

		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(mainPanel);
	}

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
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
