package features;

import common.StringValue;
import data.Course;
import data.Student;

import java.util.Scanner;

public class AdminInterface {
    private static Scanner scanner = new Scanner(System.in);

    private void welcomeMessage() {
        System.out.println(StringValue.WELCOME);
    }

    public void showMenu() {
        welcomeMessage();
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = 0;
            try {
                System.out.println(StringValue.ENTER_YOUR_CHOICE);
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println(StringValue.PLEASE_ENTER_VALID_INTEGER);
                scanner.nextLine();
            }
            switch (choice) {
                case 1 -> addNewCourse();
                case 2 -> addNewStudent();
                case 3 -> enrollStudent();
                case 4 -> assignGrade();
                case 5 -> calculateOverallCourseGrade();
                case 6 -> showStudentGradeBook();
                case 7 -> exit = true;
                default -> System.out.println(StringValue.INVALID_CHOICE);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add a course");
        System.out.println("2. Add a student");
        System.out.println("3. Enroll a student");
        System.out.println("4. Assign a grade");
        System.out.println("5. Calculate overall grade");
        System.out.println("6. Show student Grade Book");
        System.out.println("7. Exit");
    }

    private static void addNewCourse() {
        System.out.println(StringValue.ENTER_COURSE_CODE);
        String courseCode = scanner.nextLine();
        System.out.println(StringValue.ENTER_COURSE_NAME);
        String courseName = scanner.nextLine();
        System.out.println(StringValue.ENTER_MAXIMUM_CAPACITY);
        int maximumCapacity = scanner.nextInt();
        scanner.nextLine();
        CourseManagement.addCourse(new Course(courseCode, courseName, maximumCapacity));
        CourseManagement.showAvailableCourses();
    }

    private static void addNewStudent() {
        System.out.println(StringValue.ENTER_STUDENT_NAME);
        String name = scanner.nextLine();
        System.out.println(StringValue.ENTER_STUDENT_ID);
        String ID = scanner.nextLine();
        CourseManagement.addNewStudent(new Student(name, ID));
    }

    private static void enrollStudent() {
        System.out.println(StringValue.ENTER_STUDENT_ID);
        String studentId = scanner.nextLine();
        CourseManagement.showAvailableCourses();
        System.out.println(StringValue.ENTER_COURSE_CODE_TO_ENROLL);
        String courseCode = scanner.nextLine();

        CourseManagement.enrollStudent(studentId, courseCode);
    }

    private static void assignGrade() {
        CourseManagement.assignGrade();
    }

    private static void calculateOverallCourseGrade() {
        System.out.println(StringValue.COURSE_CODE);
        String courseCode = scanner.nextLine();
        CourseManagement.calculateOverallCourseGrade(courseCode);

    }

    private static void showStudentGradeBook() {
        System.out.println("Enter student ID: ");
        String studentId = scanner.nextLine();
        CourseManagement.showStudentGradeBook(studentId);
    }

}
