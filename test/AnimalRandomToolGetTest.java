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
     * 测试随机获得工具方法：RandomToolGet
     */
    @Test
    public void AnimalRandomToolGetTest() {
        // 随机生成50次测试
        for (int i = 0; i < 50; i++) {
            animal.randomToolGet();
            }
    }


}
