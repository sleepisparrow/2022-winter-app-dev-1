package com.example.searchuser;

public class UserSearchUser {
    private String name;
    private String id;
    private String group;
    private String firstClass;

    UserSearchUser(String name, String id, String group, String firstClass){
        this.name = name;
        this.id = id;
        this.group = group;
        this.firstClass = firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public String getGroup() {
        return group;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
