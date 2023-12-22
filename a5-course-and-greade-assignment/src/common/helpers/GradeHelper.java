package common.helpers;

import java.util.HashMap;
import java.util.Map;

public class GradeHelper {
    public static double[] convertGradeToPoints(String grade) {
        return switch (grade) {
            case "A" -> new double[]{90.0, 100.0};
            case "B" -> new double[]{80.0, 89.0};
            case "C" -> new double[]{70.0, 79.0};
            case "D" -> new double[]{60.0, 69.0};
            case "F" -> new double[]{0.0, 59.0};
            default -> new double[]{0.0, 0.0};     // For unrecognized grades
        };
    }

    public static String convertPointToGrade(double grade) {
        if (grade >= 90.0) return "A";
        else if (grade >= 80.0) return "B";
        else if (grade >= 70.0) return "C";
        else if (grade >= 60.0) return "D";
        else return "F";
    }

    private static String convertGrade(int grade) {
        return switch (grade) {
            case 1 -> "A";
            case 2 -> "B";
            case 3 -> "C";
            case 4 -> "D";
            case 5 -> "F";
            default -> "0";
        };
    }

    private static Map<String, String> findGradesByStudentId(String studentId, HashMap<String, String> gradeBook) {
        Map<String, String> studentGrades = new HashMap<>();
        for (Map.Entry<String, String> entry : gradeBook.entrySet()) {
            if (entry.getKey().contains(studentId)) {
                studentGrades.put(entry.getKey().substring(5), entry.getValue());
            }
        }
        return studentGrades;
    }

}
