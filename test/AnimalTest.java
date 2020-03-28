import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;


public class AnimalTest {

    //攻击者
    private Animal attacker;
    //承受者
    private Animal defender;

    @Before
    public void setUp() {
        this.attacker = new Animal("attacker");
        this.defender = new Animal("defender");
    }

    @After
    public void tearDown() {
        this.attacker = null;
        this.defender = null;
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT1() {
        attacker.attack(defender, -10);
        assertEquals(100, this.defender.getHP(), 0.01);
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT2() {
        attacker.attack(defender, 0);
        assertEquals(100, this.defender.getHP(), 0.01);
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT3() {
        attacker.attack(defender, 10);
        assertEquals(90, this.defender.getHP(), 0.01);
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT4() {
        attacker.attack(defender, 90);
        assertEquals(10, this.defender.getHP(), 0.01);
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT5() {
        attacker.attack(defender, 100);
        assertEquals(0, this.defender.getHP(), 0.01);
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT6() {
        attacker.attack(defender, 110);
        assertEquals(0, this.defender.getHP(), 0.01);
    }

    @Category(BVTTest.class)
    @Test
    public void attackTestBVT7() {
        int status = attacker.attack(null, 110);
        assertEquals(-1, status, 0.01);
    }

    @Category(EPTest.class)
    @Test
    public void attackTestEP1() {
        attacker.attack(defender, -50);
        assertEquals(100, defender.getHP(), 0.01);
    }

    @Category(EPTest.class)
    @Test
    public void attackTestEP2() {
        attacker.attack(defender, 50);
        assertEquals(50, defender.getHP(), 0.01);
    }

    @Category(EPTest.class)
    @Test
    public void attackTestEP3() {
        attacker.attack(defender, 150);
        assertEquals(0, defender.getHP(), 0.01);
    }
}