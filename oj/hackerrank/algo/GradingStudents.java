package oj.hackerrank.algo;
import java.util.*;
public class GradingStudents {
    public List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> newGrades = new ArrayList<>();
        for (int grade : grades)
        {
            int roundedGrade = grade;
            if (grade > 37)
            {
                if ((grade + 2) % 5 < 2)
                {
                    roundedGrade = (grade + 2  - ((grade + 2)  % 5));
                }
            }
            newGrades.add(roundedGrade);

        }
        return newGrades;

    }
}
