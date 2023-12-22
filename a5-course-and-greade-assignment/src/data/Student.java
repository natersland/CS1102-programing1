package data;

import java.util.HashMap;

public class Student {
    private String name;
    private String ID;
    private HashMap<Course, Double> enrolledCourses;

    public Student(String name, String ID) {
        this.name = name;
        this.ID = ID;
        enrolledCourses = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public HashMap<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void assignGrade(Course course, Double grade) {
        enrolledCourses.put(course, grade);
    }

    public Double getGrade(Course course) {
        return enrolledCourses.getOrDefault(course, null);
    }

    public void enrolledCourses(Course course) {
        enrolledCourses.put(course, null);
    }
}
