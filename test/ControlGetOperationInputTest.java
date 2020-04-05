import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhou
 *
 */
@RunWith(Parameterized.class)
public class ControlGetOperationInputTest {
    public ControlGetOperationInputTest controlGetOperationInputTest;
    private int expected;
    private String input;

    public ControlGetOperationInputTest(int expected, String input){
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters(name="{index}:getOperationInput[{1}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {-1, "0"},
                {1, "1"},
                {2, "2"},
                {4, "4"},
                {5, "5"},
                {-1, "6"},
                {-1, "a"},
                {-1, ""},
        });
    }

    @Before
    public void setUp(){
        this.controlGetOperationInputTest = new ControlGetOperationInputTest(expected, input);
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void getOperationInput(){
        Control control = new Control();
        assertEquals(expected, control.getOperationInput(input));
    }
}
