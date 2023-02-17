package kr.ac.cnu.computer.sgne.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class Workbook {
    String name;
    int testTakerCnt;
    int totalStudentCnt;
    List<Quiz> quizzes;
    List<WorkbookUser> results;

    public Workbook() {
        quizzes = new ArrayList<>();
        results = new ArrayList<>();
    }

    public Workbook(String name, int totalStudentCnt) {
        this();
        this.name = name;
        this.totalStudentCnt = totalStudentCnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTestTakerCnt() {
        return testTakerCnt;
    }

    public void setTestTakerCnt(int testTakerCnt) {
        this.testTakerCnt = testTakerCnt;
    }

    public int getTotalStudentCnt() {
        return totalStudentCnt;
    }

    public void setTotalStudentCnt(int totalStudentCnt) {
        this.totalStudentCnt = totalStudentCnt;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<WorkbookUser> getResults() {
        return results;
    }

    public void setResults(List<WorkbookUser> results) {
        this.results = results;
    }
}
