package vista;

import javax.swing.*;
import java.awt.*;

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
        frame.setTitle("Inicio de Sesión");
        frame.setBounds(100, 100, 450, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        // Panel superior con título
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(60, 63, 65)); // Mismo color que la ventana Home
        topPanel.setPreferredSize(new Dimension(frame.getWidth(), 60));
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Inicio de Sesión");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        topPanel.add(titleLabel);

        // Panel central
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(new Color(238, 238, 238)); // Mismo color de fondo que la ventana Home
        frame.getContentPane().add(centerPanel, BorderLayout.CENTER);

        JLabel lblNewLabel = new JLabel("Usuario:");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(50, 90, 100, 20);
        centerPanel.add(lblNewLabel);

        userTextField = new JTextField();
        userTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        userTextField.setBounds(160, 85, 200, 30);
        centerPanel.add(userTextField);
        userTextField.setColumns(10);

        JLabel lblContrasea = new JLabel("Contraseña:");
        lblContrasea.setForeground(Color.BLACK);
        lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblContrasea.setBounds(50, 140, 100, 20);
        centerPanel.add(lblContrasea);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        passwordField.setBounds(160, 135, 200, 30);
        centerPanel.add(passwordField);

        loginButton = new JButton("Iniciar Sesión");
        loginButton.setFont(new Font("Tahoma", Font.BOLD, 16));
        loginButton.setBounds(160, 200, 200, 40);
        centerPanel.add(loginButton);

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

    public JFrame getFrame() {
        return frame;
    }
}
