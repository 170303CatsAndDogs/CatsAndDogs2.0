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
    public void tool1DogAttack1() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(3);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack2() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(7);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack3() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(4);
        assertEquals(1,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack4() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(5);
        assertEquals(1,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack5() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(6);
        assertEquals(1,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack6() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度5-7
        control.setStrength(4);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack7() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度5-7
        control.setStrength(8);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack8() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度5-7
        control.setStrength(5);
        assertEquals(1,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack9() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度5-7
        control.setStrength(6);
        assertEquals(1,control.attack());
        //fail();
    }

    @Test
    public void tool1DogAttack10() {
        control.setRoundOwner(1);
        control.setOperationNum(1);
        control.getWind().setWindStrength(1);
        control.getWind().setDirect("顺风");
        //击中攻击力度5-7
        control.setStrength(7);
        assertEquals(1,control.attack());
        //fail();
    }


    @Test
    public void tool1CatAttack1() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(3);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1CatAttack2() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(7);
        assertEquals(2,control.attack());
        //fail();
    }

    @Test
    public void tool1CatAttack3() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(4);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1CatAttack4() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(5);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1CatAttack5() {
        control.setRoundOwner(0);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(6);
        assertEquals(0,control.attack());
        //fail();
    }

    @Test
    public void tool1CatAttack6() {
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
    public void tool1CatAttack7() {
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
    public void tool1CatAttack8() {
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
    public void tool1CatAttack9() {
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
    public void tool1CatAttack10() {
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
    public void tool3CatAttack1() {
        control.setRoundOwner(0);
        control.setOperationNum(3);
        control.getWind().setWindStrength(0);
        control.setStrength(5);
        assertEquals(-99,control.attack());
        //fail();
    }

    @Test
    public void tool3CatAttack2() {
        control.setRoundOwner(0);
        control.setOperationNum(3);
        control.getWind().setWindStrength(0);
        control.setStrength(2);
        assertEquals(-99,control.attack());
        //fail();
    }

    @Test
    public void errorAttack() {
        control.setRoundOwner(3);
        control.setOperationNum(1);
        control.getWind().setWindStrength(0);
        control.setStrength(2);
        assertEquals(-1,control.attack());
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
