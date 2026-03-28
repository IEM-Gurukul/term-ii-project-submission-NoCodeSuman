import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private final String fileName = "students.txt";

    public void save(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getCourse());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    