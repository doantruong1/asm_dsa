import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add student");
            System.out.println("2. Edit student");
            System.out.println("3. Remove student");
            System.out.println("4. Sort students by score");
            System.out.println("5. Search student by ID");
            System.out.println("6. Print all students");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter full name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter score: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    manager.addStudent(new Student(id, name, score));
                    break;
                case 2:
                    System.out.println("Enter student ID to edit: ");
                    String editId = scanner.nextLine();
                    System.out.println("Enter new full name: ");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new score: ");
                    double newScore = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    if (manager.editStudent(editId, newName, newScore)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter student ID to remove: ");
                    String removeId = scanner.nextLine();
                    if (manager.removeStudent(removeId)) {
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    manager.sortStudents();
                    System.out.println("Students sorted by score.");
                    break;
                case 5:
                    System.out.println("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student foundStudent = manager.searchStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    manager.printAllStudents();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
