package ba.edu.ibu.week10.task2;

import java.util.Arrays;
import java.util.List;

public class GradeAnalyzer {

    private List<Integer> grades;

    public GradeAnalyzer(Integer[] grades) {
        this.grades = Arrays.asList(grades);
    }

    public double calculateAverage() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void printSummary() {
        System.out.println("Average Grade: " + calculateAverage());
    }
}
