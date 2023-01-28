import java.util.*;

import kr.ac.cnu.computer.sgne.User;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Group {
    private static Query mPostReference;
    String name,first_date,inform;
    int size;
    List<User> User_list;
    List<WorkBook> WorkBook_list;

    public Group(){}

    public Group(String name, String first_date, int size, String inform){
        this.name = name;
        this.first_date = first_date;
        this.size = size;
        this.inform = inform;
    }

    public String GetName() { return this.name; }

    public String GetFirstdate() { return this.first_date; }

    public String Getinform() { return this.inform; }

    public int GetSize() { return this.size; }

    public List<User> GetUserList() { return this.User_list; }

    public List<WorkBook> GetWorkBook() { return this.WorkBook_list; }

    public void addUser(User user){
        User_list.add(user);
    }

    public void addWorkBook(WorkBook workBook){
        WorkBook_list.add(workBook);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Name", name);
        result.put("Size", size);
        result.put("inform", inform);
        return result;
    }

    //===========================================

    private static DatabaseReference mDatabase;
    // ...
    {
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public static void create(String name, String first_date, int size, String inform) {
        Group group = new Group(name, first_date, size, inform);
        mDatabase.child("group").setValue(group);
    }

    public static void update(Group group,String name, String first_date, int size, String inform){
        String key = mDatabase.child("group").push().getKey();
        Group group1 = new Group(name, first_date, size, inform);
        Map<String, Object> postValues = group1.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/group/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }

    public static void delete(Group group){
        mDatabase.child("group").child("group").removeValue();
    }

    public static void readGroup(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Group group = dataSnapshot.getValue(Group.class);
                // ..
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mPostReference.addValueEventListener(postListener);
    }

}

