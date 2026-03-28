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
