package kr.ac.cnu.computer.sgne;

import android.service.notification.NotificationListenerService;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import kr.ac.cnu.computer.sgne.quiz_list.Quiz;

public class DB_workbook {

    // 파이어베이스 데이터베이스 연동
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference();

    String workbookName;
    int personNum;
    int totalPersonNum;
    int totalProblemNum;
    ArrayList<DB_quiz> quiz_list = new ArrayList<DB_quiz>();
    ArrayList<DB_workbookUser> user_list = new ArrayList<DB_workbookUser>();

    public String getWorkbookName() {
        return workbookName;
    }

    public void setWorkbookName(String workbookName) {
        this.workbookName = workbookName;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public int getTotalPersonNum() {
        return totalPersonNum;
    }

    public void setTotalPersonNum(int totalPersonNum) {
        this.totalPersonNum = totalPersonNum;
    }

    public int getTotalProblemNum() {
        return totalProblemNum;
    }

    public void setTotalProblemNum(int totalProblemNum) {
        this.totalProblemNum = totalProblemNum;
    }

    public ArrayList<DB_quiz> getQuiz_list() {
        return quiz_list;
    }

    public void setQuiz_list(ArrayList<DB_quiz> quiz_list) {
        this.quiz_list = quiz_list;
    }

    public ArrayList<DB_workbookUser> getUser_list() {
        return user_list;
    }

    public void setUser_list(ArrayList<DB_workbookUser> user_list) {
        this.user_list = user_list;
    }

    public void putDB_workbook(DB_workbook wb) {
        databaseReference.child("WorkBook").child(wb.workbookName).setValue(wb.user_list = null);
        databaseReference.child("WorkBook").child(wb.workbookName).child("User_list").setValue(wb.getUser_list());
    }

}
