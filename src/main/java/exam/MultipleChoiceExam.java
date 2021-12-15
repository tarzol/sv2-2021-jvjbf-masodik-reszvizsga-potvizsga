package exam;

public class MultipleChoiceExam extends Exam {

    public MultipleChoiceExam(long studentId, String topic, int maxPoints) {
        super(studentId, topic, maxPoints);
    }

    public MultipleChoiceExam(long studentId, String topic) {
        super(studentId, topic);
    }

    @Override
    public void calculateExamResult(int actualPoints) {
        if ( actualPoints < 1 || actualPoints >90) {
            throw new IllegalArgumentException("The points are not in the range of 1-90");
        }
        if ((double)actualPoints/getMaxPoints() > 0.5) {
            setExamResult(ExamResult.PASSED);
        } else {
            setExamResult(ExamResult.NOT_PASSED);
        }
    }
}
