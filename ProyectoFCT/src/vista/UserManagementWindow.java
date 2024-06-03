package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserManagementWindow {

    private JFrame frame;
    private JList<String> userList;
    private DefaultListModel<String> userListModel;
    private JButton createButton;
    private JButton modifyButton;
    private JButton deleteButton;

    /**
     * Create the application.
     */
    public UserManagementWindow() {
        initialize();
        this.frame.setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Gestión de Usuarios");
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

        userListModel = new DefaultListModel<>();
        userList = new JList<>(userListModel);
        userList.setBackground(new Color(60, 63, 65));
        userList.setForeground(Color.WHITE);
        userList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(userList);
        userPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(43, 43, 43));

        createButton = createButton("Crear Usuario");
        modifyButton = createButton("Modificar Usuario");
        deleteButton = createButton("Eliminar Usuario");

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

    public void setUserList(String[] users) {
        userListModel.clear();
        for (String user : users) {
            userListModel.addElement(user);
        }
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

    public String getSelectedUser() {
        return userList.getSelectedValue();
    }

    public JFrame getFrame() {
        return frame;
    }
}
