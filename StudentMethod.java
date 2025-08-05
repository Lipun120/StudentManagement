package StudentManagement;
import java.util.Scanner;
import java.util.ArrayList;

public class StudentMethod {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) addStudent();
            else if (choice == 2) viewStudents();
            else if (choice == 3) updateStudent();
            else if (choice == 4) deleteStudent();
            else if (choice == 5) {
                System.out.println("Exiting");
                break;
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\n---- Student List ----");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                System.out.print("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println(" Student deleted successfully!");
        } else {
            System.out.println(" Student not found!");
        }
    }

    public static void main(String[] args) {
        new StudentMethod().start();
    }
}


