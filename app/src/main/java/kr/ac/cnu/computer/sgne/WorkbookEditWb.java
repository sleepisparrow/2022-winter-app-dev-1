package com.example.eidtworkbook;

import java.util.ArrayList;
import java.util.List;

public class WorkbookEditWb {
    private String workBookName;
    private String personNum;
    private String totalNum;
    private List<ProblemEditWb> problems;

    WorkbookEditWb(String name, String personNum, String totalNuml) {
        workBookName = name;
        this.personNum = personNum;
        this.totalNum = totalNuml;
        problems = new ArrayList<>();
    }

    public void addProblem(ProblemEditWb p) {
        problems.add(p);
    }

    public void deleteProblem(int idx) {
        problems.remove(idx);
    }

    public List<ProblemEditWb> getProblems() {
        return problems;
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
