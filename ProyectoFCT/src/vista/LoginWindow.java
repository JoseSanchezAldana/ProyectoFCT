package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginWindow {

	private JFrame frame;
	private JTextField userTextField;
	private JPasswordField passwordField;
	private JButton loginButton;

	public LoginWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 64, 128));
		frame.setForeground(new Color(0, 64, 128));
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(101, 93, 103, 13);
		frame.getContentPane().add(lblNewLabel);
		
		userTextField = new JTextField();
		userTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userTextField.setBounds(101, 129, 250, 32);
		frame.getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASEÑA:");
		lblContrasea.setForeground(new Color(255, 255, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblContrasea.setBounds(101, 185, 130, 13);
		frame.getContentPane().add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(101, 218, 250, 32);
		frame.getContentPane().add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginButton.setBounds(160, 272, 125, 32);
		frame.getContentPane().add(loginButton);
		frame.setVisible(true);
	}

	public JTextField getUserTextField() {
		return userTextField;
	}

	public void setUserTextField(JTextField userTextField) {
		this.userTextField = userTextField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JButton getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(JButton loginButton) {
		this.loginButton = loginButton;
	}
	
}
