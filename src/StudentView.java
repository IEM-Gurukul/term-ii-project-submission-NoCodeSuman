import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class StudentView {
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> courseBox;
    private JTable table;
    private DefaultTableModel tableModel;

    private JButton saveButton;
    private JButton clearButton;
    private JButton searchButton;

    public StudentView() {
        frame = new JFrame("Student Information System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Student Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(nameLabel, gbc);

        nameField = new JTextField(15);
        gbc.gridx = 1;
        frame.add(nameField, gbc);

        JLabel courseLabel = new JLabel("Course:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(courseLabel, gbc);

        courseBox = new JComboBox<>(new String[]{"Math", "Science", "History"});
        gbc.gridx = 1;
        frame.add(courseBox, gbc);

        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");
        searchButton = new JButton("Search");

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(saveButton, gbc);

        gbc.gridx = 1;
        frame.add(clearButton, gbc);

        gbc.gridx = 2;
        frame.add(searchButton, gbc);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Course");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        frame.add(scrollPane, gbc);

        createMenuBar();
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem aboutItem = new JMenuItem("About");

        exitItem.addActionListener(e -> System.exit(0));
        aboutItem.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Student Information System\nJava Swing Project")
        );

        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public String getNameInput() {
        return nameField.getText();
    }

    public String getCourseInput() {
        return (String) courseBox.getSelectedItem();
    }

    public void clearInputs() {
        nameField.setText("");
        courseBox.setSelectedIndex(0);
    }

    public void addStudentToTable(String name, String course) {
        tableModel.addRow(new Object[]{name, course});
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void selectTableRow(int index) {
        table.setRowSelectionInterval(index, index);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }

    public String showInputDialog(String message) {
        return JOptionPane.showInputDialog(message);
    }

    // Listener setters
    public void addSaveListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearButton.addActionListener(listener);
    }

    public void addSearchListener(ActionListener listener) {
        searchButton.addActionListener(listener);
    }
}