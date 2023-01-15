package kr.ac.cnu.computer.sgne.admin_groupranking;

import java.util.ArrayList;

import kr.ac.cnu.computer.sgne.admin_groupranking.ranking;

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
