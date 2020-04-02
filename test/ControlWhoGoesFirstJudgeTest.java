import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ControlWhoGoesFirstJudgeTest {
    public Control control;

    @Before
    public void setUp(){
        this.control = new Control();
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void whoGoesFirstJudgeTest(){
//        fail();
        control.whoGoesFirstJudge();
        assertTrue(0 == control.getRoundOwner() || 1 == control.getRoundOwner());
    }
}
