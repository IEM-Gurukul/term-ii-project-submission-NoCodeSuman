import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private StudentView view;
    private StudentRepository repository;
    private List<Student> students;

    public StudentController(StudentView view, StudentRepository repository) {
        this.view = view;
        this.repository = repository;
        this.students = new ArrayList<>();

        // Add listeners
        this.view.addSaveListener(e -> saveStudent());
        this.view.addClearListener(e -> view.clearInputs());
        this.view.addSearchListener(e -> searchStudent());

        // Load initial data
        loadInitialData();
    }

    private void loadInitialData() {
        List<Student> loadedStudents = repository.load();
        for (Student student : loadedStudents) {
            students.add(student);
            view.addStudentToTable(student.getName(), student.getCourse());
        }
    }

    private void saveStudent() {
        String name = view.getNameInput();
        String course = view.getCourseInput();

        if (name.trim().isEmpty()) {
            view.showMessage("Name cannot be empty");
            return;
        }

        Student student = new Student(name, course);
        students.add(student);
        view.addStudentToTable(name, course);
        
        repository.save(students);

        view.clearInputs();
    }

    private void searchStudent() {
        String searchName = view.showInputDialog("Enter name to search");
        if (searchName == null || searchName.trim().isEmpty()) {
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(searchName)) {
                view.selectTableRow(i);
                view.showMessage("Student Found!");
                return;
            }
        }

        view.showMessage("Student Not Found");
    }
}
