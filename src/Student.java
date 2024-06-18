public class Student {
    private String studentId;
    private String fullName;
    private double score;
    private String rank;

    public Student(String studentId, String fullName, double score) {
        this.studentId = studentId;
        this.fullName = fullName;
        this.score = score;
        this.rank = calculateRank(score);
    }

    // Getter and Setter methods
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public double getScore() { return score; }
    public void setScore(double score) {
        this.score = score;
        this.rank = calculateRank(score);
    }

    public String getRank() { return rank; }

    // Method to calculate rank based on score
    private String calculateRank(double score) {
        if (score < 5.0) return "Fail";
        else if (score < 6.5) return "Medium";
        else if (score < 7.5) return "Good";
        else if (score < 9.0) return "Very Good";
        else return "Excellent";
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + fullName + ", Score: " + score + ", Rank: " + rank;
    }
}
