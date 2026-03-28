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

    public List<Student> load() {
        List<Student> students = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    students.add(new Student(data[0], data[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}


    