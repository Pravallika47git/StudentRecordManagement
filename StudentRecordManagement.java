import java.util.ArrayList;
import java.util.Scanner;

public class StudentRecordManagement {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear buffer
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    // View Students
    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter ID of student to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.id == id) {
                found = true;
                System.out.println("What would you like to update?");
                System.out.println("1. Name");
                System.out.println("2. Marks");
                System.out.println("3. Both");
                System.out.print("Enter your choice: ");
                int updateChoice = sc.nextInt();
                sc.nextLine(); // Clear buffer

                switch (updateChoice) {
                    case 1 -> {
                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();
                        System.out.println("Name updated successfully.");
                    }
                    case 2 -> {
                        System.out.print("Enter new marks: ");
                        s.marks = sc.nextDouble();
                        System.out.println("Marks updated successfully.");
                    }
                    case 3 -> {
                        System.out.print("Enter new name: ");
                        s.name = sc.nextLine();
                        System.out.print("Enter new marks: ");
                        s.marks = sc.nextDouble();
                        System.out.println("Name and marks updated successfully.");
                    }
                    default -> System.out.println("Invalid update option.");
                }
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter ID of student to delete: ");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
