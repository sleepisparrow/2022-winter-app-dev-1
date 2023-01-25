package kr.ac.cnu.computer.sgne;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.database.*;
import kr.ac.cnu.computer.sgne.admin_page.Group; // Todo 나중에 이거 말고 다른 Group class 만들어지면 다른 곳으로 import 바꿔주세요.
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;

import java.util.*;


/*
*   이 클래스는 User 라는 클래스가 있어서 만든 임시 user 클래스입니다.
*   추후에 user라는 클래스를 대신할 예정이며, 그 후에는 이 클래스를 User 로 수정바랍니당.
*   Todo 유저가 문제집을 풀이하면, 유저의 DB에 추가할 뿐만 아니라 당장 여기 클래스의 workbooksList에 추가하고, noSolvedWorkbookList에선 해당 문제집을 삭제해야 합니다.
*/
public class UserDbClass {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mchild;

    private String username, id, pw;
    private Group group;   //Todo group에 대한 클래스가 만들어지면 이 내용도 수정해야 함.
    private boolean isAdmin;    // true:어드민, false:학생
    private boolean certified;  // true:인증된유저, false:앱 이용 X

    // Todo 나중에 workbook DB 구축되면 추가해야 함.
    private List<Workbook> solvedWorkbooksList;
    private List<Workbook> noSolvedWorkbookList;
    private List<Long> solvedWorkbookCodeList;

    public UserDbClass(String name, String id, String pw, Group group, boolean isAdmin, boolean certified) {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference("Group");

        username = name;
        this.id = id;
        this.pw = pw;
        this.group = group;
        this.isAdmin = isAdmin;
        this.certified = certified;

        // database에 유저(이름으로) 추가
        mReference.child(this.group.name).child("User_list").push().setValue(username);

        // 워크북 관련한 리스트 초기화
        solvedWorkbooksList = new ArrayList<>();
        noSolvedWorkbookList = new ArrayList<>();
        solvedWorkbookCodeList = new ArrayList<>();
        getWorkbookFromDatabase();

    }

    private void initDatabase() {

        mReference = mDatabase.getReference("Group");
// example        mReference.child("log").setValue("check");
        mchild = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onChildChanged(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull @NotNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull @NotNull DataSnapshot snapshot, @Nullable @org.jetbrains.annotations.Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        };

        mReference.addValueEventListener((ValueEventListener) mchild);
    }

    // 공식 문서에 있던거 일단 따라 만든거. 어따 쓰는지는 잘 모르겠음.
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("pw", pw);
        result.put("group", group);
        result.put("isAdmin", isAdmin);
        result.put("certified", certified);
        result.put("solved", solvedWorkbooksList);
        result.put("noSolved", noSolvedWorkbookList);
        return result;
    }

    /*
    *   database에 유저를 추가하는 메소드입니다.
    *   DB에 잘 들어가면 true, 오류 등 DB에 넣길 실패하면 false 반환.  -> 나중에 정하자.
    */
    public void userAdd(UserDbClass newUser){
        mReference = mDatabase.getReference();
        mReference.child("Group").child(group.name).child("User_list").push().setValue(newUser);
        // 잘 들어갔는지 확인하려면 여기서 데이터베이스에서 newUser를 찾아보고 있으면 true 없으면 false 반환
    }

    /*
    *   입력받은 user를 database에서 지우는 메소드입니다.
    */
    public void userDelete(UserDbClass user){
        mReference = mDatabase.getReference();
        mReference.child("Group").child(group.name).child("User_list").child(username).removeValue();
    }


    /*
    * user database에 해당 유저가 있는지 확인하는 메소드 입니다.
    */
    public boolean userSearch(UserDbClass user) {
        // 사실 이게 User class에 필요할진 모르겠어요.
        try {
            mReference = mDatabase.getReference();
            mReference.child("Group").child(user.getGroup().name).child("User_list").child(user.getUsername());
        } catch (NullPointerException nullPointerException) {
            return false;
        } catch (Exception e){ // 널포인터이셉션이 맞다면 이 catch문은 지워주세요.
            return false;
        }

        return true;
    }


    /*
        유저가 푼 문제집인지 확인하는 메소드 입니다.
        문제집(Workbook) 이라는 class가 만들어지면 해결될 문제입니다.
     */

    public boolean checkSolvedWorkbook(Workbook workbook){
        // 유저의 푼 문제집 list에서 문제집의 고유 코드를 탐색한다.
        // 이분탐색 사용할 것.

        // 1. 유저 DB에서 푼 문제집들에 대한 정보를 가져온다.
        //    이때 가져온 정보는 모두 정수이다.
        // 그런데 이미 workbookList에 위 정보들이 들어 있으니 그냥 database에서 가져올 필요없이 workbookList를 사용하면 된다.
        // 2. 지금 입력으로 들어온 workbook의 고유 코드가 이 정보들 중에 있는지 탐색한다.
        // 3. 탐색 결과 있다면 true, 없으면 false를 return한다.

        long target = workbook.getCode();
        int result = binarySearch(target, solvedWorkbookCodeList);

        return (result==1) ? true : false;
    }

    // 문제집의 개수가 int 범위를 초과하면 오류가 발생함.
    public int binarySearch(long target, List<Long> arr) {
        int low = 0;
        int high = arr.size()-1;
        int mid = 0;

        while(low <= high) {
            mid = (low + high) / 2;

            if(target == arr.get(mid)) {
                return 1; // 탐색 성공
            } else if(target < arr.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1; // 탐색 실패
    }

    private void getWorkbookFromDatabase(){
        // 지금 이 클래스에 저장된 id로 데이터베이스에서 문제집의 정보를 가져와 workbookList와 noSolvedWorkbookList에 담을 것이다.
        // 한 번만 쓰일 것 같지만 혹시 모르니 만들어두는 메소드.
        // 생성자에 추가하면 딱일 것 같다.
        mReference = mDatabase.getReference("Group").child(group.name).child("Workbook");  // 변경값을 확인할 child 이름
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    // child 내에 있는 데이터만큼 반복합니다.
                    try {
                        Workbook workbook = (Workbook) messageData.getValue();
//                        long code = workbook.getCode();
                        noSolvedWorkbookList.add(workbook);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addSolvedWorkbook(Workbook workbook){
        solvedWorkbooksList.add(workbook);
        addSolvedWorkbookCode(workbook.getCode());
        deleteSolvedWorkbook(workbook);
    }
    private void addSolvedWorkbookCode(long code){
        // Todo 가능하면 여기에 삽입 정렬 구현해서 list에 삽입하기.
        // 그래야 시간 효율이 증가함.
        // 만약 그렇게 하면 if 문은 지워버리고 그렇게 삽입.
        solvedWorkbookCodeList.add(code);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            solvedWorkbookCodeList.sort(new Comparator<Long>() {
                @Override
                public int compare(Long a, Long b) {
                    return (a>b) ? 1 : (a==b) ? 0 : -1;
                }
            });
        }
    }
    private void deleteSolvedWorkbook(Workbook workbook) {
        // 이 리스트도 정렬해두면 remove 시간이 많이 줄어들 것 같음.
        noSolvedWorkbookList.remove(workbook);
    }

    /*
    * 이하 getter, setter
    * 단, database에 대한 getter setter는 없음.
    */
    public String getId() {return id;}
    public Group getGroup() {return group;}

    public String getPw() {return pw;}

    public String getUsername() {return username;}

    public void setId(String id) {this.id = id;}

    public void setGroup(Group group) {this.group = group;}

    public void setAdmin(boolean admin) {isAdmin = admin;}

    public void setCertified(boolean certified) {this.certified = certified;}

    public void setPw(String pw) {this.pw = pw;}

    public void setUsername(String username) {this.username = username;}
}

/*
    임시로 만든 클래스입니다.
 */
class Workbook{
    private long code = 10;

    public long getCode() {
        return code;
    }

}