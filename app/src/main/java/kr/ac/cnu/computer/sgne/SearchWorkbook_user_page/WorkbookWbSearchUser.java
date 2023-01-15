package com.example.workbookserch_user;

public class WorkbookWbSearchUser {
    private String workBookName, personNum, totalNum, date, score;


    WorkbookWbSearchUser(String name, String personNum, String totalNum, String userScore, String userDate){
        workBookName = name;
        this.personNum = personNum;
        this.totalNum = totalNum;
        score = userScore;
        date = userDate;
    }

    public String getPersonNum() {
        return personNum;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public String getWorkBookName() {
        return workBookName;
    }

    public String getScore() {
        return score;
    }

    public String getDate() {
        return date;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public void setWorkBookName(String workBookName) {
        this.workBookName = workBookName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
