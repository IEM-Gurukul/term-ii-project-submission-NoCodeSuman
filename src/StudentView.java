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
