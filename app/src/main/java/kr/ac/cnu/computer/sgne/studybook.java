package kr.ac.cnu.computer.sgne;

import java.util.ArrayList;

public class studybook {

    ArrayList<ranking> ranking_list = new ArrayList<>();
    String studybookName;
    int personNum;
    int totalNum;

    public studybook(String studybookName, int personNum, int totalNum){
        this.studybookName = studybookName;
        this.personNum = personNum;
        this.totalNum = totalNum;
    }


    public String getStudybookName() {
        return studybookName;
    }
    public void setStudybookName(String studybookName) {
        this.studybookName = studybookName;
    }
    public int getPersonNum() {
        return personNum;
    }
    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }
    public int getTotalNum() {
        return totalNum;
    }
    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

}
