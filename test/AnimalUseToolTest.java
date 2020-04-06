import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class AnimalUseToolTest {
    public AnimalUseToolTest animalUseToolTest;
    private int expected;
    private int operationNum;


    public AnimalUseToolTest(int expected, int operationNum){
        this.expected = expected;
        this.operationNum = operationNum;
    }

    @Parameterized.Parameters(name="{index}:useTool[{1}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {-1, 1},
                {0, 2},
                {0, 3},
                {0, 4},
                {0, 5},
                {-1, 6},
        });
    }

    @Before
    public void setUp(){
        this.animalUseToolTest = new AnimalUseToolTest(expected, operationNum);
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void useTool() {
        Control control = new Control();
        control.setOperationNum(operationNum);
        assertEquals(expected, control.useTool());
    }
}
