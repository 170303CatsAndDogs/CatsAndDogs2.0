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


    /**
     * 测试随机生成风力和风向方法：getRandomWindStrength
     */
    @Test
    public void getRandomWindTest() {
        // 随机生成50次风力和风向测试
        for (int i = 0; i < 50; i++) {
            wind.getRandomWind();
            assertTrue(wind.getWindStrength() >= 0 || wind.getWindStrength() <= 3);
            assertTrue("顺风".equals(wind.getDirect()) || "逆风".equals(wind.getDirect())
                || "无风".equals(wind.getDirect()));
        }
    }

    /**
     * 测试方法：getActualWindStrength
     * 判定覆盖，每条分支至少测试一次
     */
    @Test
    public void getActualWindStrengthTest1() {
        wind.setDirect("顺风");
        wind.setWindStrength(3);
        int expected = 3;
        assertEquals(expected, wind.getActualWindStrength(), 0.01);
    }

    @Test
    public void getActualWindStrengthTest2() {
        wind.setDirect("逆风");
        wind.setWindStrength(2);
        int expected = -2;
        assertEquals(expected, wind.getActualWindStrength(), 0.01);
    }

    @Test
    public void getActualWindStrengthTest3() {
        wind.setDirect("无风");
        wind.setWindStrength(0);
        int expected = 0;
        assertEquals(expected, wind.getActualWindStrength(), 0.01);
    }

    @Test
    public void getActualWindStrengthTest4() {
        wind.setDirect("有风");
        wind.setWindStrength(2);
        int expected = -1;
        assertEquals(expected, wind.getActualWindStrength(), 0.01);
    }

}