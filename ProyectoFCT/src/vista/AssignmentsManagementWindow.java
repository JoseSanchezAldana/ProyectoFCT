package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AssignmentsManagementWindow {

    private JFrame frame;
    private JList<String> assignmentsList;
    private DefaultListModel<String> assignmentsListModel;
    private JButton createButton;
    private JButton modifyButton;
    private JButton deleteButton;

    /**
     * Create the application.
     */
    public AssignmentsManagementWindow() {
        initialize();
        this.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Asignaciones");
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

        assignmentsListModel = new DefaultListModel<>();
        assignmentsList = new JList<>(assignmentsListModel);
        assignmentsList.setBackground(new Color(60, 63, 65));
        assignmentsList.setForeground(Color.WHITE);
        assignmentsList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(assignmentsList);
        userPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(43, 43, 43));

        createButton = createButton("Crear asignación");
        modifyButton = createButton("Modificar asignación");
        deleteButton = createButton("Eliminar asignación");

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

    public JList<String> getAssignmentsList() {
		return assignmentsList;
	}

	public DefaultListModel<String> getAssignmentsListModel() {
		return assignmentsListModel;
	}

	public void setAssignmentsListModel(DefaultListModel<String> assignmentsListModel) {
		this.assignmentsListModel = assignmentsListModel;
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

    public int getSelectedAssignmentsId() {
        String selectedValue = assignmentsList.getSelectedValue();
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

