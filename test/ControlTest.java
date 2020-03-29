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
    private int operation;
    private int input;


    public ControlTest(int expected, int operation, int input){
        this.expected = expected;
        this.operation = operation;
        this.input = input;
    }

    @Parameterized.Parameters(name="{index}:getInput[{1},{2}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {-1, 0, 5},
                {-1, 1, 5},
                {5, 2, 5},
                {-1, 3, 5},
                {-1, 0, 2},
                {2, 1, 2},
                {2, 2, 2},
                {-1, 3, 2},
                {-1, 1, 0},
                {1, 1, 1},
                {2, 1, 2},
                {-1, 1, 3},
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
        this.controlTest = new ControlTest(expected, operation, input);
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
        control.setOperation(operation);
        control.setInput(input);
        int result = control.getInput();
        assertEquals(expected, result);
    }
}