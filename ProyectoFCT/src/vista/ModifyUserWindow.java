package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyUserWindow extends JFrame {

	private JTextField nombreField;
	private JTextField emailField;
	private JTextField passwordField;
	private JTextField rolField;
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

	public ModifyUserWindow(String nombre, String email, String password, String rol) {
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

		JLabel nombreLabel = new JLabel("Nombre:");
		nombreLabel.setForeground(Color.WHITE);
		nombreField = new JTextField(email);
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setForeground(Color.WHITE);
		emailField = new JTextField(email);
		JLabel passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setForeground(Color.WHITE);
		passwordField = new JTextField();
		JLabel rolLabel = new JLabel("Rol:");
		rolLabel.setForeground(Color.WHITE);
		rolField = new JTextField(String.valueOf(rol));

		formPanel.add(nombreLabel);
		formPanel.add(nombreField);
		formPanel.add(emailLabel);
		formPanel.add(emailField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordField);
		formPanel.add(rolLabel);
		formPanel.add(rolField);

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

	public JTextField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JTextField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextField getRolField() {
		return rolField;
	}

	public void setRolField(JTextField rolField) {
		this.rolField = rolField;
	}


}
