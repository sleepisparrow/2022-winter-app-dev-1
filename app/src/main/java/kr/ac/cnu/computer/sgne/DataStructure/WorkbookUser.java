package kr.ac.cnu.computer.sgne.DataStructure;

import com.google.type.DateTime;

import java.util.ArrayList;
import java.util.List;

public class WorkbookUser {
    User user;
    DateTime testedDate;
    int correctCount;
    int score;
    List<String> userSolutions;
    //IDEA: quizWrapper 를 사용할 것도 고려해 보기

    public WorkbookUser() {
        userSolutions = new ArrayList<>();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DateTime getTestedDate() {
        return testedDate;
    }

    public void setTestedDate(DateTime testedDate) {
        this.testedDate = testedDate;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<String> getUserSolutions() {
        return userSolutions;
    }

    public void setUserSolutions(List<String> userSolutions) {
        this.userSolutions = userSolutions;
    }
}
