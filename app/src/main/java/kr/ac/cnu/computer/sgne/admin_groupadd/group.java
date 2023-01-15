package kr.ac.cnu.computer.sgne.admin_groupadd;

public class group {
    String groupName;
    int personNum;
    int totalNum;
    String firstLecture;

    public group(String groupName, int personNum, int totalNum, String firstLecture){
        this.groupName = groupName;
        this.personNum = personNum;
        this.totalNum = totalNum;
        this.firstLecture = firstLecture;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getFirstLecture() {
        return firstLecture;
    }

    public void setFirstLecture(String firstLecture) {
        this.firstLecture = firstLecture;
    }
}
