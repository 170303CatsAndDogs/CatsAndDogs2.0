import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ControlUseToolTest {
    public ControlUseToolTest controlUseToolTest;
    private int expected;
    private int roundOwner;
    private int operationNum;


    public ControlUseToolTest(int expected, int roundOwner, int operationNum){
        this.expected = expected;
        this.roundOwner = roundOwner;
        this.operationNum = operationNum;
    }

    @Parameterized.Parameters(name="{index}:useTool[{1},{2}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {-1, 0, 0},
                {-1, 0, 1},
                {0, 0, 2},
                {-1, 0, 3},
                {-1, -1, 2},
                {0, 0, 2},
                {0, 1, 2},
                {-1, 2, 2},
        });
    }

    @Before
    public void setUp(){
        this.controlUseToolTest = new ControlUseToolTest(expected, roundOwner, operationNum);
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void useTool() {
        Control control = new Control();
        control.setRoundOwner(roundOwner);
        control.setOperationNum(operationNum);
        assertEquals(expected, control.useTool());
    }
}
