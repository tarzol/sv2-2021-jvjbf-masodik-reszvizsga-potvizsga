package exam;

import java.util.ArrayList;
import java.util.List;

public class PracticeExam extends Exam {

    private List<Integer> pointsPerTasks = new ArrayList<>();
    private int maxPoints;

    public PracticeExam(long studentId, String topic, List<Integer> pointsPerTasks) {
        super(studentId, topic);
        Integer totalPoints = 0;
        for ( Integer item : pointsPerTasks ) {
            totalPoints += item;
        }
        if ( totalPoints <10 ) {
            throw new IllegalArgumentException("Maximum points should be between 10 and 150! %");
        }
        maxPoints = totalPoints; //nem tudom megváltoztatni a maxpoints értékét
        //System.out.println("Max pontok számítása: "+totalPoints);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        if ( actualPoints < 1 || actualPoints >90) {
            throw new IllegalArgumentException("The points are not in the range of 1-90");
        }
        if ((double)actualPoints/getMaxPoints() >= 0.76) {
            setExamResult(ExamResult.PERFECT);
        } else if ((double)actualPoints/getMaxPoints() >= 0.51){
            setExamResult(ExamResult.OK);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
