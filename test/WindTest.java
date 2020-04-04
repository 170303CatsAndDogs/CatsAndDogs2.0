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
    public void getRandomWindStrengthTest() {
        // 随机生成50次风力和风向测试
        for (int i = 0; i < 50; i++) {
            wind.getRandomWind();
            assertTrue(wind.getWindStrength() > 0 || wind.getWindStrength() <= 10);
            assertTrue("顺风".equals(wind.getDirect()) || "逆风".equals(wind.getDirect()));
        }
    }

}