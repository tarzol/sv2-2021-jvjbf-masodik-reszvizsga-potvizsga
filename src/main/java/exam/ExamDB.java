package exam;

import java.util.ArrayList;
import java.util.List;

public class ExamDB {

    private List<Exam> exams = new ArrayList<>();

    public void addExam(Exam exam, int actualPoints) {
        exam.calculateExamResult(actualPoints);
        exams.add(exam);
    }

    public int countPassedExams() {
        int result = 0;
        for ( Exam item : exams ) {
            if ( item.getExamResult() == ExamResult.PASSED || item.getExamResult() == ExamResult.OK || item.getExamResult() == ExamResult.PERFECT) {
                result++;
            }
        }
        return result;
    }

    public List<Exam> findById(int id) {
        List<Exam> result = new ArrayList<>();
        for ( Exam item : exams ) {
            if ( item.getStudentId() == id ) {
                result.add(item);
            }
        }
        return result;
    }

    public List<String> findTopicByPrefix(String topic) {
        List<String> result = new ArrayList<>();
        for ( Exam item : exams ) {
            if ( item.getTopic().startsWith(topic) && !result.contains(item.getTopic())) {
                result.add(item.getTopic());
            }
        }
        return result;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
