package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUserWindow extends JFrame {

	private JTextField nombreField;
	private JTextField emailField;
	private JTextField passwordField;
	private JComboBox<String> rolComboBox;
	private JButton createButton;
	private JButton cancelButton;

	public CreateUserWindow() {
		setTitle("Crear Usuario");
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

		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setForeground(Color.WHITE);
		nombreField = new JTextField();
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setForeground(Color.WHITE);
		emailField = new JTextField();
		JLabel passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setForeground(Color.WHITE);
		passwordField = new JTextField();
		JLabel rolLabel = new JLabel("Rol:");
		rolLabel.setForeground(Color.WHITE);
		rolComboBox = new JComboBox<>(new String[]{"admin", "usuario"});

		formPanel.add(nombreLabel);
		formPanel.add(nombreField);
		formPanel.add(emailLabel);
		formPanel.add(emailField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordField);
		formPanel.add(rolLabel);
		formPanel.add(rolComboBox);

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

	public JTextField getNombreField() {
		return nombreField;
	}

	public void setNombreField(JTextField nombreField) {
		this.nombreField = nombreField;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JComboBox<String> getRolComboBox() {
		return rolComboBox;
	}

	public void setRolComboBox(JComboBox<String> rolComboBox) {
		this.rolComboBox = rolComboBox;
	}

	public JTextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}

}
