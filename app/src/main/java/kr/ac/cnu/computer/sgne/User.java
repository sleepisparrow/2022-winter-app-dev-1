package kr.ac.cnu.computer.sgne;

import androidx.annotation.Nullable;

import kr.ac.cnu.computer.sgne.admin_page.Group;

public class User {
    private String id, pw, name;
    public boolean is_valid, is_admin;
    private Group group;

    public User() { }

    public User(String id, String pw, String name, boolean is_valid, boolean is_admin) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.is_valid = is_valid;
        this.is_admin = is_admin;
        group = new Group("test", 48);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        User u = (User) obj;
        return u.id.equals(this.id);
    }

    public Group getGroup() {
        return group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
