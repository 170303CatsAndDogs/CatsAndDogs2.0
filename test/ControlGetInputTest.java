import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * @author Zhou
 *
 */
@RunWith(Parameterized.class)
public class ControlGetInputTest {
    public ControlGetInputTest controlTest;
    private int expected;
    private int operationNum;
    private String input;


    public ControlGetInputTest(int expected, String input, int operationNum){
        this.expected = expected;
        this.input = input;
        this.operationNum = operationNum;
    }

    @Parameterized.Parameters(name="{index}:getInput[{1},{2}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {-1, "-1", 1},
                {0, "0", 1},
                {1, "1", 2},
                {9, "9", 4},
                {10, "10", 1},
                {-1, "11", 2},
                {-1, "a", 4},
                {-1, "", 1},
                {-1, "5", 3},
        });
    }

    @Before
    public void setUp(){
        this.controlTest = new ControlGetInputTest(expected, input, operationNum);
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void getInput() {
        Control control = new Control();
        control.setOperationNum(this.operationNum);
        int result = control.getInput(this.input);
        assertEquals(expected, result);
    }
}