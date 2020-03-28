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
public class ControlTest {
    public ControlTest controlTest;
    private int expected;
    private int input1;
    private int input2;


    public ControlTest(int expected, int input1, int input2){
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Parameterized.Parameters(name="{index}:getArea[{1},{2}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {-1, 0, 5},
                {5, 1, 5},
                {5, 2, 5},
                {-1, 3, 5},
                {-1, 0, 2},
                {2, 1, 2},
                {2, 2, 2},
                {-1, 3, 2},
                {-1, 1, 0},
                {1, 1, 1},
                {2, 1, 2},
                {4, 1, 4},
                {5, 1, 5},
                {-1, 1, 6},
                {-1, 2, -1},
                {0, 2, 0},
                {1, 2, 1},
                {9, 2, 9},
                {10, 2, 10},
                {-1, 2, 11},
        });
    }

    @Before
    public void setUp(){
        this.controlTest = new ControlTest(expected, input1, input2);
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void output() {
    }

    @Test
    public void gameOver() {
    }

    @Test
    public void getInput() {
        Control control = new Control();
        control.setOperation(input1);
        control.setOperationNum(input2);
        int result = control.getInput();
        assertEquals(expected, result);
    }

    @Test
    public void useTool() {
        fail();
    }
}