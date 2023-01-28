package kr.ac.cnu.computer.sgne;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    public void test(){
        DB_workbook wb = new DB_workbook();
        wb.setWorkbookName("테스트(23.01.28) : 워크북 네임");

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("이수호 테스트");
        myRef.setValue("연결된건가");

        ArrayList<DB_workbookUser> testList = new ArrayList<>();
        wb.setUser_list(testList);;

        DB_workbook.putDB_workbook(wb);
    }
}