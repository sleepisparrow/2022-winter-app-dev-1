package kr.ac.cnu.computer.sgne;

public class DB_workbookUser {
    String workbookUserName;
    String date;
    String score;
    String isTest;
    String correctNum;

    public DB_workbookUser(String workbookUserNamename, String date, String score, String isTest, String correctNum){
        this.workbookUserName = workbookUserNamename;
        this.date = date;
        this.score = score;
        this.isTest = isTest;
        this.correctNum = correctNum;
    }

    public String getWorkbookUserName() {
        return workbookUserName;
    }

    public void setWorkbookUserName(String workbookUserName) {
        this.workbookUserName = workbookUserName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getIsTest() {
        return isTest;
    }

    public void setIsTest(String isTest) {
        this.isTest = isTest;
    }

    public String getCorrectNum() {
        return correctNum;
    }

    public void setCorrectNum(String correctNum) {
        this.correctNum = correctNum;
    }
}
