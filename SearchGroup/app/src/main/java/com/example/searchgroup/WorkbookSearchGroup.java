package com.example.searchgroup;

public class WorkbookSearchGroup {
    String workBookName;
    String personNum;
    String totalNum;

    WorkbookSearchGroup(String name, String personNum, String totalNuml){
        workBookName = name;
        this.personNum = personNum;
        this.totalNum = totalNuml;
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

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public void setWorkBookName(String workBookName) {
        this.workBookName = workBookName;
    }
}
