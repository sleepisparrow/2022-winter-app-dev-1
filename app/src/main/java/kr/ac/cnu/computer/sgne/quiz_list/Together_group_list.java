package kr.ac.cnu.computer.sgne.quiz_list;

public class Together_group_list {
    int totalQuizNum;
    String quizName;

    public Together_group_list(){

    }

    public Together_group_list(int totalQuizNum, String quizName){
        setQuizName(quizName);
        setTotalQuizNum(totalQuizNum);
    }

    public void setTotalQuizNum(int totalQuizNum) {
        this.totalQuizNum = totalQuizNum;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizName() {
        return quizName;
    }

    public int getTotalQuizNum() {
        return totalQuizNum;
    }
}
