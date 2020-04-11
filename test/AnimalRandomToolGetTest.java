import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AnimalRandomToolGetTest {

    private Animal animal;

    @Before
    public void setUp() throws Exception {
        animal = new Animal();
    }

    @After
    public void tearDown() throws Exception {
        animal = null;
    }


    /**
     * 测试随机获得工具方法：randomToolGet
     */
    @Test
    public void randomToolGetTest() {
        // 随机生成50次测试
        for (int i = 0; i < 50; i++) {
            animal.randomToolGet();
            assertTrue(0 == animal.randomToolGet() || 1 == animal.randomToolGet());
        }
    }


}
