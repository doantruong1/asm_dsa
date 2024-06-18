import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Method to add a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to edit an existing student by ID
    public boolean editStudent(String studentId, String newFullName, double newScore) {
        Optional<Student> studentOptional = students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst();

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setFullName(newFullName);
            student.setScore(newScore);
            return true;
        }
        return false;
    }

    // Method to remove a student by ID
    public boolean removeStudent(String studentId) {
        return students.removeIf(student -> student.getStudentId().equals(studentId));
    }

    // Method to sort students by score
    public void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getScore).reversed());
    }

    // Method to search for a student by ID
    public Student searchStudent(String studentId) {
        return students.stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    // Method to print all students
    public void printAllStudents() {
        students.forEach(System.out::println);
    }
}
