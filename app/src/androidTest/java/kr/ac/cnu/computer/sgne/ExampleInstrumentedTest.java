package kr.ac.cnu.computer.sgne;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    WorkBook workBook;

    @Before
    public void before() {
        workBook = new WorkBook("Testing_workbookName");
    }

    @Test
    public void createTest() {
        WorkBookUser.create(new WorkBookUser(new User("testID", "password", "name", true, false), LocalDateTime.now(), true, 10), workBook);
        WorkBookUser.create(new WorkBookUser(new User("test2", "password", "name", true, false), LocalDateTime.now(), true, 10), workBook);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectTest() {

        LocalDateTime now = LocalDateTime.now();
        LinkedList<WorkBookUser> expected = new LinkedList<>();
        expected.add(new WorkBookUser(
                new User("testID", "password", "name", true, false)
                , now, true, 10));
        List<WorkBookUser> actual = WorkBookUser.select(workBook);

        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertTrue(expected.get(i).equals(actual.get(i)));
        }
    }
}