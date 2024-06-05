package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MaintenanceManagementWindow {

    private JFrame frame;
    private JList<String> maintenanceList;
    private DefaultListModel<String> maintenanceListModel;
    private JButton createButton;
    private JButton modifyButton;
    private JButton deleteButton;

    /**
     * Create the application.
     */
    public MaintenanceManagementWindow() {
        initialize();
        this.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Mantenimientos");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(43, 43, 43));
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Panel de usuarios
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        userPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        userPanel.setBackground(new Color(43, 43, 43));

        maintenanceListModel = new DefaultListModel<>();
        maintenanceList = new JList<>(maintenanceListModel);
        maintenanceList.setBackground(new Color(60, 63, 65));
        maintenanceList.setForeground(Color.WHITE);
        maintenanceList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(maintenanceList);
        userPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(43, 43, 43));

        createButton = createButton("Crear mantenimiento");
        modifyButton = createButton("Modificar mantenimiento");
        deleteButton = createButton("Eliminar mantenimiento");

        buttonPanel.add(createButton);
        buttonPanel.add(modifyButton);
        buttonPanel.add(deleteButton);

        mainPanel.add(userPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        JLabel statusBar = new JLabel("Estado: Conectado");
        statusBar.setForeground(Color.WHITE);
        frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
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

	public JList<String> getMaintenanceList() {
		return maintenanceList;
	}

	public void setMaintenanceList(JList<String> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}

	public DefaultListModel<String> getMaintenanceListModel() {
		return maintenanceListModel;
	}

	public void setMaintenanceListModel(DefaultListModel<String> maintenanceListModel) {
		this.maintenanceListModel = maintenanceListModel;
	}

	public void addCreateButtonListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    public void addModifyButtonListener(ActionListener listener) {
        modifyButton.addActionListener(listener);
    }

    public void addDeleteButtonListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public int getSelectedMaintenanceId() {
        String selectedValue = maintenanceList.getSelectedValue();
        if (selectedValue != null) {
            String[] parts = selectedValue.split("   \\|\\|   ");
            String idPart = parts[0];
            String idStr = idPart.replace("ID: ", "").trim();
            return Integer.parseInt(idStr);
        }
        return -1;
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

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
    
    
}


