package kr.ac.cnu.computer.sgne;

public class ranking implements Comparable<ranking>{
    // ranking studybook

    String studybookName;
    String studentName;
    int studentScore;
    int rankingNum;

    public ranking(String studybookName, String studentName, int studentScore){
        this.studentName = studentName;
        this.studentScore = studentScore;
    }

    public int compareTo(ranking studentInfo) {
        return studentInfo.getStudentScore() - getStudentScore();
    }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public int getStudentScore() { return studentScore; }
    public void setStudentScore(int studentScore) { this.studentScore = studentScore; }
    public int getRankingNum() { return rankingNum; }
    public void setRankingNum(int rankingNum) { this.rankingNum = rankingNum; }
    public String getStudybookName() { return studybookName; }
    public void setStudybookName(String studybookName) { this.studentName = studybookName; }

}
