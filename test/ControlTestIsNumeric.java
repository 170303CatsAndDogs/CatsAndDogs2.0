import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ControlTestIsNumeric {

    private Control control;
    private boolean expected;
    private String input;

    public ControlTestIsNumeric(boolean expected, String input){
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters(name="{index}:isNumeric[{1}]={0}")
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {false,""},
                {false,"1.56"},
                {false,"-1.4"},
                {false,"abcd"},
                {false,"=-*/"},
                {false,"123.45asd"},
                {true,"12"},
                {true,"5"},
                {true,"0"},
        });
    }

    @Before
    public void setUp(){
        control = new Control();
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void isNumeric1() {
        assertEquals(expected,control.isNumeric(input));
        //fail();
    }


}
