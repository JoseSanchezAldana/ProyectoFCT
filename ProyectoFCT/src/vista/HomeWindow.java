package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.List;

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

import conexion.ConexionSQL;
import controlador.HomeController;
import modelo.Modelo;
import modelo.UsuarioEntity;
import modelo.VehiculoEntity;

public class HomeWindow {

	private JFrame frame;
	JMenuItem mntmGestionVehiculos;
	JMenuItem mntmGestionUsuarios;
	JMenuItem mntmAsignaciones;
	JMenuItem mntmMantenimientos;
	JMenuItem mntmSalir;
	JMenuItem mntmUserM;
	//JButton menuButtonInicio;
	JButton menuButtonUsuarios;
	JButton menuButtonVehiculos;
	JButton menuButtonAsignaciones;
	JButton menuButtonMantenimientos;
	JButton menuButtonSalir;
	JButton menuButtonUserM;
	JPanel mainPanel;
	ConexionSQL conexionSQL;
	Modelo modelo;
	UsuarioEntity usuario;

	public HomeWindow(ConexionSQL conexionSQL, Modelo modelo) {
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;
		usuario = conexionSQL.obtenerUsuarioPorId(modelo.getIdActiveUser());
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

		JMenu inicioMenu = new JMenu("Inicio");
		menuBar.add(inicioMenu);

		JMenu gestionMenu = new JMenu("Gestión");

		mntmSalir = new JMenuItem("Salir");
		inicioMenu.add(mntmSalir);

		mntmGestionVehiculos = new JMenuItem("Gestión de vehículos");

		mntmGestionUsuarios = new JMenuItem("Gestión de usuarios");
		mntmUserM = new JMenuItem("Mantenimientos pendientes");

		mntmAsignaciones = new JMenuItem("Asignación de vehículos");

		mntmMantenimientos = new JMenuItem("Mantenimientos");

		JPanel navigationPanel = new JPanel();
		navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));
		navigationPanel.setBackground(new Color(60, 63, 65));

		//addNavButton(navigationPanel, "Inicio", "Inicio seleccionado", menuButtonInicio = new JButton());
		
		if (usuario.getRol().equals("admin")) {
			menuBar.add(gestionMenu);
			gestionMenu.add(mntmGestionVehiculos);
			gestionMenu.add(mntmGestionUsuarios);
			gestionMenu.add(mntmAsignaciones);
			gestionMenu.add(mntmMantenimientos);
			addNavButton(navigationPanel, "Gestión de usuarios", "Usuarios seleccionado",
					menuButtonUsuarios = new JButton());
			addNavButton(navigationPanel, "Gestión de vehículos", "Vehículos seleccionado",
					menuButtonVehiculos = new JButton());
			addNavButton(navigationPanel, "Asignación de vehículos", "Asignación seleccionado",
					menuButtonAsignaciones = new JButton());
			addNavButton(navigationPanel, "Mantenimientos", "Mantenimientos seleccionado",
					menuButtonMantenimientos = new JButton());
		} else {
			gestionMenu.add(mntmUserM);
			addNavButton(navigationPanel, "Mantenimientos pendientes", "Mantenimientos pendientes",
					menuButtonUserM = new JButton());
		}
		addNavButton(navigationPanel, "Salir", "Salir", menuButtonSalir = new JButton());

		navigationPanel.add(Box.createVerticalGlue());
		frame.getContentPane().add(navigationPanel, BorderLayout.WEST);

		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(43, 43, 43));
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

		JLabel statusBar = new JLabel("Proyecto FCT || José Francisco Sánchez Aldana");
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

	public void displayUserInfo() {
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

		JLabel vehicleInfoTitle = new JLabel("Vehiculos asociados");
		vehicleInfoTitle.setForeground(Color.WHITE);
		vehicleInfoTitle.setFont(new Font("Arial", Font.BOLD, 16));
		vehicleInfoTitle.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		vehicleInfoPanel.add(vehicleInfoTitle);
		vehicleInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

		List<VehiculoEntity> vehiculos = conexionSQL.obtenerVehiculosAsignadosAUsuario(modelo.getIdActiveUser());
		JLabel vehiculosLabel = new JLabel();
			for (VehiculoEntity vehiculo : vehiculos) {
	            JLabel labelVehiculo = new JLabel();
	            labelVehiculo.setForeground(Color.WHITE);
				labelVehiculo.setFont(new Font("Arial", Font.PLAIN, 14));
				labelVehiculo.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	            labelVehiculo.setText("Matrícula: " + vehiculo.getMatricula() + "   ||   "
	                                  + "Marca: " + vehiculo.getMarca() + "   ||   "
	                                  + "Modelo: " + vehiculo.getModelo());
	            vehicleInfoPanel.add(labelVehiculo);
	        }
		vehicleInfoPanel.add(Box.createRigidArea(new Dimension(0, 10)));

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

	public JButton getMenuButtonUsuarios() {
		return menuButtonUsuarios;
	}

	public JButton getMenuButtonVehiculos() {
		return menuButtonVehiculos;
	}

	public JMenuItem getMntmAsignaciones() {
		return mntmAsignaciones;
	}

	public void setMntmAsignaciones(JMenuItem mntmAsignaciones) {
		this.mntmAsignaciones = mntmAsignaciones;
	}

	public JMenuItem getMntmMantenimientos() {
		return mntmMantenimientos;
	}

	public void setMntmMantenimientos(JMenuItem mntmMantenimientos) {
		this.mntmMantenimientos = mntmMantenimientos;
	}

	public JButton getMenuButtonAsignaciones() {
		return menuButtonAsignaciones;
	}

	public void setMenuButtonAsignaciones(JButton menuButtonAsignaciones) {
		this.menuButtonAsignaciones = menuButtonAsignaciones;
	}

	public JButton getMenuButtonMantenimientos() {
		return menuButtonMantenimientos;
	}

	public void setMenuButtonMantenimientos(JButton menuButtonMantenimientos) {
		this.menuButtonMantenimientos = menuButtonMantenimientos;
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public void setMntmGestionVehiculos(JMenuItem mntmGestionVehiculos) {
		this.mntmGestionVehiculos = mntmGestionVehiculos;
	}

	public void setMntmGestionUsuarios(JMenuItem mntmGestionUsuarios) {
		this.mntmGestionUsuarios = mntmGestionUsuarios;
	}

	public void setMenuButtonUsuarios(JButton menuButtonUsuarios) {
		this.menuButtonUsuarios = menuButtonUsuarios;
	}

	public void setMenuButtonVehiculos(JButton menuButtonVehiculos) {
		this.menuButtonVehiculos = menuButtonVehiculos;
	}

	public JButton getMenuButtonSalir() {
		return menuButtonSalir;
	}

	public void setMenuButtonSalir(JButton menuButtonSalir) {
		this.menuButtonSalir = menuButtonSalir;
	}

	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	public JMenuItem getMntmUserM() {
		return mntmUserM;
	}

	public void setMntmUserM(JMenuItem mntmUserM) {
		this.mntmUserM = mntmUserM;
	}

	public JButton getMenuButtonUserM() {
		return menuButtonUserM;
	}

	public void setMenuButtonUserM(JButton menuButtonUserM) {
		this.menuButtonUserM = menuButtonUserM;
	}

}
