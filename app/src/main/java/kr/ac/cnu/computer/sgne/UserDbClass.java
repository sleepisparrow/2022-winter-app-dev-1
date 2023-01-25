package kr.ac.cnu.computer.sgne;

import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import kr.ac.cnu.computer.sgne.admin_page.Group; // Todo 나중에 이거 말고 다른 Group class 만들어지면 다른 곳으로 import 바꿔주세요.


/*
*   이 클래스는 User 라는 클래스가 있어서 만든 임시 user 클래스입니다.
*   추후에 user라는 클래스를 대신할 예정이며, 그 후에는 이 클래스를 User 로 수정바랍니당.
*/
public class UserDbClass {
    private DatabaseReference mDatabase;

    private String username, id, pw;
    private Group group;   //Todo group에 대한 클래스가 만들어지면 이 내용도 수정해야 함.
    private boolean isAdmin;    // true:어드민, false:학생
    private boolean certified;  // true:인증된유저, false:앱 이용 X

    // Todo 나중에 workbook DB 구축되면 추가해야 함.
    // private List<Workbook> workbooksList;
    // private List<Workbook> noSolvedWorkbookList;

    public UserDbClass() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        getWorkbookFromDatabase();
    }

    /*
    *   database에 유저를 추가하는 메소드입니다.
    *   DB에 잘 들어가면 true, 오류 등 DB에 넣길 실패하면 false 반환.  -> 나중에 정하자.
    */
    public void userInsert(UserDbClass newUser){

    }

    /*
    *   입력받은 user를 database에서 지우는 메소드입니다.
    */
    public void userDelete(UserDbClass user){

    }


    /*
    * user database에 해당 유저가 있는지 확인하는 메소드 입니다.
    */
    public boolean userSearch(UserDbClass user){
        // 사실 이게 User class에 필요할진 모르겠어요.
        return true;
    }


    /*
        유저가 푼 문제집인지 확인하는 메소드 입니다.
        문제집(Workbook) 이라는 class가 만들어지면 해결될 문제입니다.
     */
//    public boolean checkSolvedWorkbook(Workbook workbook){
//        // 유저의 푼 문제집 list에서 문제집의 고유 코드를 탐색한다.
//        // 이분탐색 사용할 것.
//
//        // 1. 유저 DB에서 푼 문제집들에 대한 정보를 가져온다.
//        //    이때 가져온 정보는 모두 정수이다.
//        // 그런데 이미 workbookList에 위 정보들이 들어 있으니 그냥 database에서 가져올 필요없이 workbookList를 사용하면 된다.
//        // 2. 지금 입력으로 들어온 workbook의 고유 코드가 이 정보들 중에 있는지 탐색한다.
//        // 3. 탐색 결과 있다면 true, 없으면 false를 return한다.
//        return false;
//    }

    private void getWorkbookFromDatabase(){
        // 지금 이 클래스에 저장된 id로 데이터베이스에서 문제집의 정보를 가져와 workbookList와 noSolvedWorkbookList에 담을 것이다.
        // 한 번만 쓰일 것 같지만 혹시 모르니 만들어두는 메소드.
        // 생성자에 추가하면 딱일 것 같다.
    }


    /*
    * 이하 getter, setter
    * 단, database에 대한 getter setter는 없음.
    */
    public String getId() {
        return id;
    }
    public Group getGroup() {
        return group;
    }

    public String getPw() {
        return pw;
    }

    public String getUsername() {
        return username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
