package kr.ac.cnu.computer.sgne;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Mock
    WorkBook workBook;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createTest() {
        WorkBookUser.create(new WorkBookUser(new User("testID", "password", "name", true, false), LocalDateTime.now(), true, 10), workBook);
    }

    @Test
    public void selectTest() {
    }
}