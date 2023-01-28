package kr.ac.cnu.computer.sgne;

import android.service.notification.NotificationListenerService;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import kr.ac.cnu.computer.sgne.quiz_list.Quiz;

public class DB_workbook {

    // 파이어베이스 데이터베이스 연동
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference databaseReference = database.getReference();

    String workbookName;
    int personNum;
    int totalPersonNum;
    int totalProblemNum;
    List<DB_quiz> quiz_list = new ArrayList<DB_quiz>();
    List<DB_workbookUser> user_list = new ArrayList<DB_workbookUser>();

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

    public List<DB_quiz> getQuiz_list() {
        return quiz_list;
    }

    public void setQuiz_list(ArrayList<DB_quiz> quiz_list) {
        this.quiz_list = quiz_list;
    }

    public List<DB_workbookUser> getUser_list() {
        return user_list;
    }

    public void setUser_list(ArrayList<DB_workbookUser> user_list) {
        this.user_list = user_list;
    }

    static void putDB_workbook_obj(DB_workbook wb) {
        databaseReference.child("WorkBook").child(wb.workbookName).setValue(wb);
    }



    /**
     *
     * 랭킹, 평균값, 오답률 계산
     *
     */
}
