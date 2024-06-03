package vista;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionListener;

public class VehicleManagementWindow {

    private JFrame frame;
    private JList<String> vehicleList;
    private DefaultListModel<String> vehicleListModel;
    private JButton createButton;
    private JButton modifyButton;
    private JButton deleteButton;

    /**
     * Create the application.
     */
    public VehicleManagementWindow() {
        initialize();
        this.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Gestión de Vehículos");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(43, 43, 43));
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Panel de vehículos
        JPanel vehiclePanel = new JPanel();
        vehiclePanel.setLayout(new BorderLayout());
        vehiclePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        vehiclePanel.setBackground(new Color(43, 43, 43));

        vehicleListModel = new DefaultListModel<>();
        vehicleList = new JList<>(vehicleListModel);
        vehicleList.setBackground(new Color(60, 63, 65));
        vehicleList.setForeground(Color.WHITE);
        vehicleList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(vehicleList);
        vehiclePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(43, 43, 43));

        createButton = createButton("Crear Vehículo");
        modifyButton = createButton("Modificar Vehículo");
        deleteButton = createButton("Eliminar Vehículo");

        buttonPanel.add(createButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);

        mainPanel.add(vehiclePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        JLabel statusBar = new JLabel("Estado: Conectado");
        statusBar.setForeground(Color.WHITE);
        frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
    }

    public DefaultListModel<String> getVehicleListModel() {
		return vehicleListModel;
	}

	public void setVehicleListModel(DefaultListModel<String> vehicleListModel) {
		this.vehicleListModel = vehicleListModel;
	}

	public JList<String> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(JList<String> vehicleList) {
		this.vehicleList = vehicleList;
	}

	private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 40));
        button.setMaximumSize(new Dimension(200, 40));
        button.setBackground(new Color(84, 84, 84));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        return button;
    }
    

    public void setVehicleList(String[] vehicles) {
        vehicleListModel.clear();
        for (String vehicle : vehicles) {
            vehicleListModel.addElement(vehicle);
        }
    }
    
    public int getSelectedVehicleId() {
        String selectedValue = vehicleList.getSelectedValue();
        if (selectedValue != null) {
            String[] parts = selectedValue.split("   \\|\\|   ");
            String idPart = parts[0];
            String idStr = idPart.replace("ID: ", "").trim();
            return Integer.parseInt(idStr);
        }
        return -1; // Indica que no se ha seleccionado ningún vehículo
    }

    public JFrame getFrame() {
        return frame;
    }

	public JButton getCreateButton() {
		return createButton;
	}

	public void setCreateButton(JButton createButton) {
		this.createButton = createButton;
	}

	public JButton getModifyButton() {
		return modifyButton;
	}

	public void setModifyButton(JButton modifyButton) {
		this.modifyButton = modifyButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}

}
