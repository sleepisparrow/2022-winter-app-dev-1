package kr.ac.cnu.computer.sgne.DataStructure;

import java.util.LinkedList;

public class User {
    String _id;
    String pw;
    String name;

    Group group;

    boolean isVerified;
    boolean isAdmin;

    LinkedList<Workbook> solved;

    public User() {
        solved = new LinkedList<>();
    }

    public User(String _id, String pw, String name, Group group) {
        this(_id, pw, name, group, false, false);
    }

    public User(String _id, String pw, String name, Group group, boolean isVerified, boolean isAdmin) {
        this._id = _id;
        this.pw = pw;
        this.name = name;
        this.group = group;
        this.isVerified = isVerified;
        this.isAdmin = isAdmin;

        solved = new LinkedList<>();
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public LinkedList<Workbook> getSolved() {
        return solved;
    }

    public void setSolved(LinkedList<Workbook> solved) {
        this.solved = solved;
    }
}
