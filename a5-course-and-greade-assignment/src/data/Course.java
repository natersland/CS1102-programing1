package data;

public class Course {
    private final String courseCode;
    private final String courseName;
    private final int maximumCapacity;

    private static int totalEnrolled = 0;

    public Course(String courseCode, String courseName, int maximumCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maximumCapacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public String getCourseName() {
        return courseName;
    }

    public static int getTotalEnrolled() {
        return totalEnrolled;
    }

    public synchronized static void incrementTotalEnrolled() {
        totalEnrolled++;
    }

    public void enrolledStudent(Student student) {
        student.enrolledCourses(this);
        incrementTotalEnrolled();
    }


}
