package kr.ac.cnu.computer.sgne;

import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/*
*   이 클래스는 User 라는 클래스가 있어서 만든 임시 user 클래스입니다.
*   추후에 user라는 클래스를 대신할 예정이며, 그 후에는 이 클래스를 User 로 수정바랍니당.
*/
public class UserDbClass {
//    private DatabaseReference mDatabase;
//
//    mDatabase = FirebaseDatabase.getInstance().getReference();

    private String username, id, pw;
    private String group;   //Todo group에 대한 클래스가 만들어지면 이 내용도 수정해야 함.
    private boolean isAdmin;    // true:어드민, false:학생
    private boolean certified;  // true:인증된유저, false:앱 이용 X

    // Todo 나중에 workbook DB 구축되면 추가해야 함.
    // private List<workbooks> workbooksList;

    public UserDbClass() {

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

    // group db에서 문제집을 하나하나 search한다.
    /*
    * */

}
