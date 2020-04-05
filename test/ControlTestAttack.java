import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;


public class ControlTestAttack {
    private Control control;

    @Before
    public void setUp(){
        control = new Control();
    }

    @After
    public void tearDown(){
        System.out.println("finish");
    }

    @Test
    public void output() {
        // fail();
    }

    @Test
    public void play() {
        //fail();
    }

    @Test
    public void tool1Attack1() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(3);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1attack2() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(7);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1attack3() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(4);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1attack4() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(5);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1attack5() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(6);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1attack6() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度3-5
        control.setStrength(2);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1attack7() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度3-5
        control.setStrength(6);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1attack8() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度3-5
        control.setStrength(3);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1attack9() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度3-5
        control.setStrength(4);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1attack10() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度3-5
        control.setStrength(5);
        assertEquals(0,control.attack());
        //fail();
    }


    @Test
    public void tool3attack1() {
        control.setRoundOwner(0);
        control.setOperationNum(3);
        control.getWind().setWindStrength(0);
        control.setStrength(5);
        assertEquals(-99,control.attack());
        //fail();
    }

    @Test
    public void tool3attack2() {
        control.setRoundOwner(0);
        control.setOperationNum(3);
        control.getWind().setWindStrength(0);
        control.setStrength(2);
        assertEquals(-99,control.attack());
        //fail();
    }

    @Test
    public void gameOver1() {
        control.getCat().setHP(0);
        assertEquals(1,control.gameOver());
        //fail();
    }

    @Test
    public void gameOver2() {
        control.getCat().setHP(-10);
        assertEquals(1,control.gameOver());
        //fail();
    }

    @Test
    public void gameOver3() {
        control.getCat().setHP(10);
        assertEquals(-1,control.gameOver());
        //fail();
    }

    @Test
    public void gameOver4() {
        control.getDog().setHP(0);
        assertEquals(0,control.gameOver());
        //fail();
    }

    @Test
    public void gameOver5() {
        control.getDog().setHP(-10);
        assertEquals(0,control.gameOver());
        //fail();
    }

    @Test
    public void gameOver6() {
        control.getDog().setHP(10);
        assertEquals(-1,control.gameOver());
        //fail();
    }

    @Test
    public void changeRound0() {
        control.setRoundOwner(0);
        control.changeRound();
        assertEquals(1,control.getRoundOwner(),0.01);
        //fail();
    }

    @Test
    public void changeRound1() {
        control.setRoundOwner(1);
        control.changeRound();
        assertEquals(0,control.getRoundOwner(),0.01);
        //fail();
    }

}
