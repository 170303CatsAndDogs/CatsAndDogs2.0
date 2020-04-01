import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WindTest {

    private Wind wind;

    @Before
    public void setUp() throws Exception {
        wind = new Wind();
    }

    @After
    public void tearDown() throws Exception {
        wind = null;
    }

    @Test
    public void getActualWindStrengthTest() {
        fail();
    }

}