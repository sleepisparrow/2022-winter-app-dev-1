package kr.ac.cnu.computer.sgne;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("kr.ac.cnu.computer.sgne", appContext.getPackageName());
    }

    @Test
    public void test(){
        DB_workbook wb = new DB_workbook();
        wb.setWorkbookName("Testing_workbookName");
        ArrayList<DB_workbookUser> testList = new ArrayList<>();
        DB_workbookUser wbu0 = new DB_workbookUser("이수호", "22.01.27", "56", "false", "100");
        DB_workbookUser wbu1 = new DB_workbookUser("배연우", "22.01.28", "60", "true", "3");
        DB_workbookUser wbu2 = new DB_workbookUser("김민재", "22.01.21", "58", "false", "2");
        DB_workbookUser wbu3 = new DB_workbookUser("박종현", "22.02.02", "0", "true", "1");

        testList.add(wbu0);
        testList.add(wbu1);
        testList.add(wbu2);
        testList.add(wbu3);
        wb.setUser_list(testList);
        DB_workbook.putDB_workbook_obj(wb);

        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){}
    }

    public void selectTest(){
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DB_workbook wb = snapshot.getValue(DB_workbook.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // 객체를 가져올 때 실패하면 호출이 됨
            }
        };
    }
}