package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserMaintenanceWindow {

    private JFrame frame;
    private JList<String> maintenanceList;
    private DefaultListModel<String> maintenanceListModel;

    /**
     * Create the application.
     */
    public UserMaintenanceWindow() {
        initialize();
        this.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Mantenimientos pendientes");
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

        mainPanel.add(userPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        JLabel statusBar = new JLabel("Estado: Conectado");
        statusBar.setForeground(Color.WHITE);
        frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
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

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
    
    
}


