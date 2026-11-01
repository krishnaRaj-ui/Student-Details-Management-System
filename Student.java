public class Student {

    private int studentId;
    private String studentName;
    private double marks;

    public Student(int studentId,
                   String studentName,
                   double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getMarks() {
        return marks;
    }
}
