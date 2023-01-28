package kr.ac.cnu.computer.sgne;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class WorkBookUser {
    User user;
    LocalDateTime testDate;
    boolean isTested;
    int correctCount;

    final private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

    public WorkBookUser(User user,
                        LocalDateTime testDate,
                        boolean isTested,
                        int correctCount) {
        this.user = user;
        this.testDate = testDate;
        this.isTested = isTested;
        this.correctCount = correctCount;
    }

    public WorkBookUser() { }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDateTime testDate) {
        this.testDate = testDate;
    }

    public boolean isTested() {
        return isTested;
    }

    public void setTested(boolean tested) {
        isTested = tested;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    //----------DB 관련----------

    public static boolean create(WorkBookUser target, WorkBook workBook) {
        mDatabase.child("WorkBook").child(workBook.toString()).child("workbook_user").child(String.valueOf(target.hashCode())).setValue(target);
        return true;
    }

    public static List<WorkBookUser> select(WorkBook from) {
        List<WorkBookUser> ret = new LinkedList<>();

        return makeDataSnapshotToList(mDatabase.child("workbook").child(from.toString()).get());
    }

    public static List<WorkBookUser> select(WorkBook from, String[] where) {
        List<WorkBookUser> ret = new LinkedList<>();

        Query mid = mDatabase.child("workbook").child(from.toString());
        for (String s : where) {
            String key = s.split("=")[0].trim();
            String value = s.split("=")[1].trim();
            mid = mid.orderByChild(key).equalTo(value);
        }

        return makeDataSnapshotToList(mDatabase.child("workbook").child(from.toString()).get());
    }

    private static List<WorkBookUser> makeDataSnapshotToList(Task<DataSnapshot> in) {
        if (in.isCanceled())
            return null;

        List<WorkBookUser> ret = new LinkedList<>();
        while(true) {
            if (in.isSuccessful())
                break;
            else if (in.isCanceled())
                return null;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        DataSnapshot snapshot = in.getResult();
        for (DataSnapshot ds : snapshot.getChildren()) {
            ret.add(ds.getValue(WorkBookUser.class));
        }
        return ret;
    }

    public static boolean deleteByUserId(String userId) {
        return true;
    }

    @Override
    public boolean equals(Object wb) {
        if (wb != null && wb.getClass() != WorkBookUser.class)
            return false;
        WorkBookUser compare = (WorkBookUser) wb;

        return testDate.equals(compare.testDate) &&  user.equals(compare.user);
    }
}