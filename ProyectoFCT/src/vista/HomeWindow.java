package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controlador.HomeController;
import modelo.UsuarioEntity;

public class HomeWindow {

	private JFrame frame;
	JMenuItem mntmGestionVehiculos;
	JMenuItem mntmGestionUsuarios;
	JButton menuButtonInicio;
	JButton menuButtonUsuarios;
	JButton menuButtonVehiculos;
	JButton menuButtonConfiguracion;
	JPanel mainPanel;

	public HomeWindow() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("SGV - Sistema de gestión de vehículos");
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu gestionMenu = new JMenu("Gestión");
		menuBar.add(gestionMenu);

		mntmGestionVehiculos = new JMenuItem("Gestión de vehículos");
		gestionMenu.add(mntmGestionVehiculos);

		mntmGestionUsuarios = new JMenuItem("Gestión de usuarios");
		gestionMenu.add(mntmGestionUsuarios);

		JPanel navigationPanel = new JPanel();
		navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));
		navigationPanel.setBackground(new Color(60, 63, 65));

		addNavButton(navigationPanel, "Inicio", "Inicio seleccionado", menuButtonInicio = new JButton());
		addNavButton(navigationPanel, "Gestión de usuarios", "Usuarios seleccionado",
				menuButtonUsuarios = new JButton());
		addNavButton(navigationPanel, "Gestión de vehículos", "Vehículos seleccionado",
				menuButtonVehiculos = new JButton());

		navigationPanel.add(Box.createVerticalGlue());
		frame.getContentPane().add(navigationPanel, BorderLayout.WEST);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(43, 43, 43));
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		JLabel statusBar = new JLabel("Estado: Conectado");
		statusBar.setForeground(Color.BLACK);
		frame.getContentPane().add(statusBar, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	private void addNavButton(JPanel panel, String text, String actionCommand, JButton menuButton) {
		menuButton.setText(text);
		menuButton.setAlignmentX(JButton.CENTER_ALIGNMENT);
		menuButton.setMaximumSize(new Dimension(200, 40));
		menuButton.setPreferredSize(new Dimension(200, 40));
		menuButton.setBackground(new Color(84, 84, 84));
		menuButton.setForeground(Color.WHITE);
		menuButton.setFocusPainted(false);
		menuButton.setBorderPainted(false);
		panel.add(menuButton);
		panel.add(Box.createRigidArea(new Dimension(0, 5)));
	}

	public void displayUserInfo(UsuarioEntity usuario) {
		mainPanel.removeAll();
		mainPanel.setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// User Info Panel
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setLayout(new BoxLayout(userInfoPanel, BoxLayout.Y_AXIS));
		userInfoPanel.setBackground(new Color(60, 63, 65));
		userInfoPanel.setBorder(BorderFactory.createLineBorder(new Color(60, 63, 65), 15));

		JLabel userInfoTitle = new JLabel("Información del Usuario");
		userInfoTitle.setForeground(Color.WHITE);
		userInfoTitle.setFont(new Font("Arial", Font.BOLD, 16));
		userInfoTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		userInfoPanel.add(userInfoTitle);
		userInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel idLabel = new JLabel("ID Usuario: " + usuario.getIdUsuario());
		JLabel nombreLabel = new JLabel("Nombre: " + usuario.getNombre());
		JLabel emailLabel = new JLabel("Email: " + usuario.getEmail());
		JLabel rolLabel = new JLabel("Rol: " + usuario.getRol());

		for (JLabel label : new JLabel[] { idLabel, nombreLabel, emailLabel, rolLabel }) {
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Arial", Font.PLAIN, 14));
			label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			userInfoPanel.add(label);
			userInfoPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		}

		// Vehicle Info Panel
		JPanel vehicleInfoPanel = new JPanel();
		vehicleInfoPanel.setLayout(new BoxLayout(vehicleInfoPanel, BoxLayout.Y_AXIS));
		vehicleInfoPanel.setBackground(new Color(60, 63, 65));
		vehicleInfoPanel.setBorder(BorderFactory.createLineBorder(new Color(60, 63, 65), 15));

		JLabel vehicleInfoTitle = new JLabel("Información del Vehículo");
		vehicleInfoTitle.setForeground(Color.WHITE);
		vehicleInfoTitle.setFont(new Font("Arial", Font.BOLD, 16));
		vehicleInfoTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		vehicleInfoPanel.add(vehicleInfoTitle);
		vehicleInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel marcaLabel = new JLabel("Marca: " + usuario.getVehiculo().getMarca());
		JLabel modeloLabel = new JLabel("Modelo: " + usuario.getVehiculo().getModelo());
		JLabel matriculaLabel = new JLabel("Matrícula: " + usuario.getVehiculo().getMatricula());
		JLabel anioMatriculacionLabel = new JLabel(
				"Año de matriculación: " + usuario.getVehiculo().getAnoMatriculacion());

		for (JLabel label : new JLabel[] { marcaLabel, modeloLabel, matriculaLabel, anioMatriculacionLabel }) {
			label.setForeground(Color.WHITE);
			label.setFont(new Font("Arial", Font.PLAIN, 14));
			label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
			vehicleInfoPanel.add(label);
			vehicleInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		}

		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(userInfoPanel, gbc);
		gbc.gridy = 1;
		mainPanel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);
		gbc.gridy = 2;
		mainPanel.add(vehicleInfoPanel, gbc);

		mainPanel.revalidate();
		mainPanel.repaint();
	}

	public JMenuItem getMntmGestionVehiculos() {
		return mntmGestionVehiculos;
	}

	public JMenuItem getMntmGestionUsuarios() {
		return mntmGestionUsuarios;
	}

	public JFrame getFrame() {
		return frame;
	}

	public JButton getMenuButtonInicio() {
		return menuButtonInicio;
	}

	public JButton getMenuButtonUsuarios() {
		return menuButtonUsuarios;
	}

	public JButton getMenuButtonVehiculos() {
		return menuButtonVehiculos;
	}

	public JButton getMenuButtonConfiguracion() {
		return menuButtonConfiguracion;
	}
}
