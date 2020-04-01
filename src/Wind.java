import java.util.Random;

/**
 * 风类
 */
public class Wind {

    // 风向(0：顺风，1：逆风)
    private String direct;
    // 风力(范围0-10)
    private int windStrength;
    // 产生随机数
    private Random random;

    // Constructors
    public Wind () {
        random = new Random();
        windStrength = random.nextInt(11);
        int dir = random.nextInt(2);
        if (dir == 0) {
            this.direct = "顺风";
        }else {
            this.direct = "逆风";
        }
    }

    // Getters and Setters
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

    public int getActualWindStrength() {
        if ("顺风".equals(this.direct)) {
            return this.windStrength;
        }
        if ("逆风".equals(this.direct)) {
            return -this.windStrength;
        }
        return -1;
    }

}
