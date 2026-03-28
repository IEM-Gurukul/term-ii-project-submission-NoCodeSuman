// StudentInfoApp.java
import javax.swing.SwingUtilities;

public class StudentInfoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentView view = new StudentView();
            StudentRepository repository = new StudentRepository();
            new StudentController(view, repository);
            view.setVisible(true);
        });
    }
}

