package kr.ac.cnu.computer.sgne.DataStructure;

import com.google.type.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String name;
    List<User> members;
    List<Workbook> workbooks;
    DateTime first_Date;
    String memo;

    public Group() {
        members = new ArrayList<>();
        workbooks = new ArrayList<>();
    }

    public Group(String name, DateTime first_Date, String memo) {
        this();
        this.name = name;
        this.first_Date = first_Date;
        this.memo = memo;
    }

    public Group(String name, DateTime first_Date) {
        this(name, first_Date, "");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Workbook> getWorkbooks() {
        return workbooks;
    }

    public void setWorkbooks(List<Workbook> workbooks) {
        this.workbooks = workbooks;
    }

    public DateTime getFirst_Date() {
        return first_Date;
    }

    public void setFirst_Date(DateTime first_Date) {
        this.first_Date = first_Date;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
