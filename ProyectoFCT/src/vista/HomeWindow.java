package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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

public class HomeWindow {

    private JFrame frame;

    /**
     * Create the application.
     */
    public HomeWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        // Create and set up the frame
        frame = new JFrame();
        frame.setTitle("Home Window");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Create and set up the menu bar
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // Create "Gestión" menu
        JMenu gestionMenu = new JMenu("Gestión");
        menuBar.add(gestionMenu);

        // Add "Gestión de vehículos" menu item
        JMenuItem mntmGestionVehiculos = new JMenuItem("Gestión de vehículos");
        gestionMenu.add(mntmGestionVehiculos);

        // Add "Gestión de usuarios" menu item
        JMenuItem mntmGestionUsuarios = new JMenuItem("Gestión de usuarios");
        gestionMenu.add(mntmGestionUsuarios);

        // Add action listeners to menu items
        mntmGestionVehiculos.addActionListener(new HomeController("Gestión de vehículos"));
        mntmGestionUsuarios.addActionListener(new HomeController("Gestión de usuarios"));

        // Create a navigation panel with BoxLayout
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.Y_AXIS));
        navigationPanel.setBackground(new Color(60, 63, 65));

        // Add buttons to the navigation panel
        addNavButton(navigationPanel, "Inicio", "Inicio seleccionado");

        // Add "Vehículos" section with sub-buttons
        addNavButton(navigationPanel, "Vehículos", "Vehículos seleccionado");
        addSubNavButton(navigationPanel, "  Añadir Vehículo", "Añadir Vehículo seleccionado");
        addSubNavButton(navigationPanel, "  Eliminar Vehículo", "Eliminar Vehículo seleccionado");
        addSubNavButton(navigationPanel, "  Editar Vehículo", "Editar Vehículo seleccionado");

        // Add "Usuarios" section with sub-buttons
        addNavButton(navigationPanel, "Usuarios", "Usuarios seleccionado");
        addSubNavButton(navigationPanel, "  Añadir Usuario", "Añadir Usuario seleccionado");
        addSubNavButton(navigationPanel, "  Modificar Usuarios", "Modificar Usuarios seleccionado");
        addSubNavButton(navigationPanel, "  Eliminar Usuarios", "Eliminar Usuarios seleccionado");

        addNavButton(navigationPanel, "Configuración", "Configuración seleccionada");

        // Add some vertical glue to center buttons vertically
        navigationPanel.add(Box.createVerticalGlue());

        frame.add(navigationPanel, BorderLayout.WEST);

        // Create a main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JLabel welcomeLabel = new JLabel("Bienvenido a la Gestión de la Aplicación", SwingConstants.CENTER);
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Create a status bar
        JLabel statusBar = new JLabel("Estado: Conectado");
        frame.add(statusBar, BorderLayout.SOUTH);
    }

    private void addNavButton(JPanel panel, String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.addActionListener(new HomeController(actionCommand));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(200, 40));
        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(new Color(84, 84, 84));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons
    }

    private void addSubNavButton(JPanel panel, String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.addActionListener(new HomeController(actionCommand));
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(180, 40));
        button.setPreferredSize(new Dimension(180, 40)); 
        button.setBackground(new Color(104, 104, 104));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add space between buttons
    }
}
