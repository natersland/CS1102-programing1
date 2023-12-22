package features;

import common.StringValue;
import common.helpers.GradeHelper;
import common.helpers.UtilityHelper;
import data.Course;
import data.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CourseManagement {
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final HashMap<String, String> gradeBook = new HashMap<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void addNewStudent(Student student) {
        try {
            System.out.println(student.getID());
            boolean isStudentExist = findStudentByID(student.getID());
            if (isStudentExist) {
                System.out.println(StringValue.STUDENT_ALREADY_EXISTS);
                showStudents();
                return;
            }
            students.add(student);
            System.out.println(StringValue.STUDENT_ADDED);
            showStudents();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean findStudentByID(String ID) {
        for (Student student : students) {
            if (student.getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkStudentAndCourseExist(String studentId, String courseCode) {

        if (!findCourseByCode(courseCode)) {
            System.out.println(StringValue.COURSE_NOT_FOUND);
            return false;
        }

        return true;
    }

    private static boolean checkStudentExist(String studentId) {
        if (!findStudentByID(studentId)) {
            System.out.println(StringValue.STUDENT_NOT_FOUND);
            return false;
        }
        return true;
    }

    private static boolean checkCourseExist(String courseCode) {
        if (!findCourseByCode(courseCode)) {
            System.out.println(StringValue.COURSE_NOT_FOUND);
            return false;
        }
        return true;
    }

    public static void enrollStudent(String studentId, String courseCode) {
        try {
            boolean isStudentAndCourseExist = checkStudentAndCourseExist(studentId, courseCode);

            if (!isStudentAndCourseExist) {
                return;
            }

            Student student = getStudentById(studentId);
            Course course = getCourseByCode(courseCode);


            assert course != null;
            if (course.getMaximumCapacity() == Course.getTotalEnrolled()) {
                System.out.println(StringValue.COURSE_FULL);
                return;
            }

            assert student != null;
            student.enrolledCourses(course);
            course.enrolledStudent(student);
            System.out.println(StringValue.ENROLL_SUCCESS);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showStudentCurrentEnrolled(String studentId) {

        try {
            boolean isStudentExist = findStudentByID(studentId);
            if (!isStudentExist) {
                System.out.println(StringValue.STUDENT_NOT_FOUND);
                return;
            }
            Student student = getStudentById(studentId);
            assert student != null;
            if (student.getEnrolledCourses().isEmpty()) {
                System.out.println(StringValue.NO_AVAILABLE_COURSE);
                return;
            }
            System.out.println(StringValue.COURSES_ENROLLED);
            for (Course course : student.getEnrolledCourses().keySet()) {
                System.out.println(StringValue.COURSE_CODE + course.getCourseCode() + ", " + StringValue.COURSE_NAME + course.getCourseName());
            }
            UtilityHelper.printDashLine();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void showStudentGradeBook(String studentId) {
        try {
            boolean isStudentExist = findStudentByID(studentId);
            if (!isStudentExist) {
                System.out.println(StringValue.STUDENT_NOT_FOUND);
                return;
            }
            Student student = getStudentById(studentId);
            assert student != null;

            HashMap<Course, Double> enrolledCourses = student.getEnrolledCourses();

            System.out.println(StringValue.STUDENT_GRADE_BOOK);

            System.out.println(StringValue.GRADE_BOOK_FOR_STUDENT + student.getName() + " (" + StringValue.ID + student.getID() + ")");
            for (Map.Entry<Course, Double> entry : enrolledCourses.entrySet()) {
                Course course = entry.getKey();
                Double grade = entry.getValue();
                System.out.println(StringValue.COURSE_CODE + course.getCourseCode() + " " +StringValue.COURSE_NAME + course.getCourseName() + " " + StringValue.GRADE + (grade != null ? GradeHelper.convertPointToGrade(grade) : "Not Assigned"));
            }
            UtilityHelper.printDashLine();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Student getStudentById(String studentId) {
        for (Student student : students) {
            if (student.getID().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private static void showStudents() {
        if (students.isEmpty()) {
            System.out.println(StringValue.NO_STUDENT);
            return;
        }
        System.out.println(StringValue.STUDENTS);
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + StringValue.STUDENT_NAME + student.getName() + ", " + StringValue.STUDENT_ID + student.getID() + ", " + StringValue.COURSES_ENROLLED + student.getEnrolledCourses().size());
        }
        System.out.println("_____________________________________________________");
    }

    public static void addCourse(Course course) {
        try {
            findCourseByCode(course.getCourseCode());
            System.out.println(StringValue.COURSE_ALREADY_EXISTS);
            courses.add(course);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Course> getCourses() {
        return courses;
    }

    private static Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public static void showAvailableCourses() {
        if (courses.isEmpty()) {
            System.out.println(StringValue.NO_AVAILABLE_COURSE);
            return;
        }

        System.out.println(StringValue.AVAILABLE_COURSES);
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            System.out.println((i + 1) + ". " + StringValue.COURSE_CODE + course.getCourseCode() + ", " + StringValue.COURSE_NAME + course.getCourseName() + ", " + StringValue.MAXIMUM_CAPACITY + course.getMaximumCapacity() + ", " + StringValue.TOTAL_ENROLLED + Course.getTotalEnrolled());
        }
        System.out.println("_____________________________________________________");


    }

    private static boolean findCourseByCode(String courseCode) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(courseCode)) {
                return true;
            }
        }
        return false;
    }

    public static void assignGrade() {
        try {
            System.out.println(StringValue.ENTER_STUDENT_ID);
            String studentId = scanner.nextLine();

            if (!checkStudentExist(studentId)) {
                return;
            }

            showAvailableCourses();
            System.out.println(StringValue.ENTER_COURSE_CODE);
            String courseCode = scanner.nextLine();

            if (!checkCourseExist(courseCode)) {
                return;
            }

            System.out.println(StringValue.ENTER_GRADE);
            Double grade = scanner.nextDouble();
            scanner.nextLine();

            Student student = getStudentById(studentId);
            Course course = getCourseByCode(courseCode);

            assert student != null;


            if (!student.getEnrolledCourses().containsKey(course)) {
                System.out.println(StringValue.STUDENT_NOT_ENROLLED);
                return;
            }

            assert course != null;
            student.assignGrade(course, grade);
            System.out.println(StringValue.GRADE_ASSIGNED);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void calculateOverallCourseGrade(String courseCode) {
        double totalGrade = 0.0;
        int totalStudent = 0;
        for (Map.Entry<String, String> entry : gradeBook.entrySet()) {
            if (entry.getKey().contains(courseCode)) {
                totalGrade += Double.parseDouble(entry.getValue());
                totalStudent++;
            }
        }
        double avarageGrade = totalGrade / totalStudent;
        System.out.println(StringValue.AVERAGE_GRADE_FOR_COURSE + courseCode + " is " + GradeHelper.convertPointToGrade(avarageGrade));

    }



}
