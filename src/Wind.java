import java.util.Random;

/**
 * 风类
 * @author casdg
 */
public class Wind {

    /**
     * 风向(1：顺风，-1：逆风)
     */
    private String direct;
    /**
     * 风力(范围0-3，等于0时表示无风)
     */
    private int windStrength;

    private Random random;

    public static final String [] DIRECTIONS = { "顺风", "逆风", "无风" };


    /**
     * Constructors
     */
    public Wind () {
        getRandomWind();
    }

    /**
     * Getters and Setters
     */
    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public int getWindStrength() {
        return windStrength;
    }

    public void setWindStrength(int windStrength) {
        this.windStrength = windStrength;
    }


    /**
     * 得到随机风力和风向
     * 风力大小：0-3，风向：顺风、逆风，无风
     */
    public void getRandomWind() {
        random = new Random();
        int strength = random.nextInt(4);
        setWindStrength(strength);
        int dir = random.nextInt(2);
        if (dir == 0) {
            setDirect(DIRECTIONS[0]);
        }else {
            setDirect(DIRECTIONS[1]);
        }
        if (windStrength == 0) {
            setDirect(DIRECTIONS[2]);
        }
    }

    /**
     * @return 风力值顺风为正、逆风为负
     */
    public int getActualWindStrength() {
        if (DIRECTIONS[0].equals(this.direct)) {
            return this.windStrength;
        }
        if (DIRECTIONS[1].equals(this.direct)) {
            return -this.windStrength;
        }
        if (DIRECTIONS[2].equals(this.direct)) {
            return this.windStrength;
        }
        return -1;
    }

}
