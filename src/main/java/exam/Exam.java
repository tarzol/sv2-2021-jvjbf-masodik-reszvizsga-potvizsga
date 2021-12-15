package exam;

public abstract class Exam {

    private long studentId;
    private String topic;
    private int maxPoints;
    private ExamResult examResult;


    public ExamResult getExamResult() {
        return examResult;
    }


    public Exam(long studentId, String topic, int maxPoints) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = maxPoints;
    }

    public Exam(long studentId, String topic) {
        this.studentId = studentId;
        this.topic = topic;
        this.maxPoints = 100;
    }

    public abstract void calculateExamResult(int actualPoints);

    public void setExamResult(ExamResult examResult) {
        this.examResult = examResult;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getTopic() {
        return topic;
    }

    public int getMaxPoints() {
        return maxPoints;
    }
}
