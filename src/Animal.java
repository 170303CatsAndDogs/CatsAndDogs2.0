import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 动物类
 * @author casdg
 */
public class Animal {
    /**
     * 生命值
     */
    private int HP;
    /**
     * 攻击力
     */
    private int ATK;
    /**
     * 工具
     */
    private List<Tool> tool;
    /**
     * 名字
     */
    private String name;
    /**
     * 初始攻击力
     */
    public static final int BASE_ATK = 10;

    /**
     * Constructors
     */
    public Animal() {
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new ArrayList<Tool>();
        /*初始时拥有一个双倍攻击力的道具*/
        this.tool.add(new Tool("doubleAttackPower"));
        this.tool.add(new Tool("poison"));
        this.tool.add(new Tool("doubleAttackTimes"));
        this.tool.add(new Tool("recover"));
    }

    public Animal(String name) {
        this.name = name;
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new ArrayList<Tool>();
        /* 初始时拥有一个双倍攻击力的道具 */
        this.tool.add(new Tool("doubleAttackPower"));
        this.tool.add(new Tool("poison"));
        this.tool.add(new Tool("doubleAttackTimes"));
        this.tool.add(new Tool("recover"));

    }

    /**
     * getters and setters
     */
    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public List<Tool> getTool() {
        return tool;
    }

    public void setTool(List<Tool> tool) {
        this.tool = tool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 动物攻击
     * @param animal 被攻击的动物
     * @param atk 攻击力
     * @return 攻击成功返回0，否则返回-1
     */
    public int attack(Animal animal, int atk) {
        if (animal == null || atk < 0) {
            return -1;
        }
        int res = animal.getHP() - atk;
        if (res < 0) {
            res = 0;
        }
        animal.setHP(res);
        System.out.println(this.name + "攻击" + animal.name + "造成了"
                + atk + "点伤害，" + animal.name + "剩余HP：" + animal.getHP());
        return 0;
    }

    /**
     * 使用道具(两倍攻击力效果一回合)
     * @return 使用成功返回0，否则返回-1
     */
    public int useTool(int operationNum) {
        int indexTool = operationNum - 2;
        // 通过tool集合长度判断道具数是否为零
        int num = this.tool.get(indexTool).getNumber();
        if (num == 0) {
            System.out.println("道具数为0！");
            return -1;
        }
        // 使用道具后的效果实现，并打印出来
        // 这里的operationNum - 2目的是对应tool集合的序号
        Tool tool = this.getTool().get(indexTool);
        if (Tool.DOUBLEATTACKPOWER.equals(tool.getName())) {
            this.ATK = BASE_ATK * 2;
            System.out.println(this.name + tool.getLabel());
            //删除使用过的道具
            this.tool.get(indexTool).setNumber(this.tool.get(indexTool).getNumber() - 1);
            return 0;
        } else if (Tool.RECOVER.equals(tool.getName())) {
            if (this.HP + 30 > 100) {
                this.HP = 100;
            } else {
                this.HP += 30;
            }
            System.out.println(this.name + tool.getLabel());
            // 删除使用过的道具
            this.tool.get(indexTool).setNumber(this.tool.get(indexTool).getNumber() - 1);
            return 0;
        }

        return 0;
    }

    /**
     * 随机道具获得
     * @return 成功返回0，否则返回-1
     */
    public int randomToolGet() {
        Random r = new Random();
        int random  = r.nextInt(100);

        if (random<=Tool.RATE1) {
            System.out.println(this.name + "没有获得随机道具");
            return 0;

        } else if (random > Tool.RATE1 && random <= Tool.RATE2) {
            this.tool.get(0).setNumber(this.tool.get(0).getNumber() + 1);
            System.out.println(this.name + "获得随机道具：双倍攻击力");
            return 0;

        } else if (random > Tool.RATE2 && random <= Tool.RATE3) {
            this.tool.get(1).setNumber(this.tool.get(1).getNumber() + 1);
            System.out.println(this.name + "获得随机道具：施放毒药");
            return 0;

        } else if (random > Tool.RATE3 && random <= Tool.RATE4) {
            this.tool.get(2).setNumber(this.tool.get(2).getNumber() + 1);
            System.out.println(this.name + "获得随机道具：两次攻击机会");
            return 0;

        } else if (random > Tool.RATE4 && random < Tool.RATE5) {
            this.tool.get(3).setNumber(this.tool.get(3).getNumber() + 1);
            System.out.println(this.name + "获得随机道具：恢复血量");
            return 0;

        } else {
            return -1;
        }

    }

    /**
     * 道具效果结束，攻击力变为10
     */
    public void endUsingTool() {
        this.ATK = BASE_ATK;
    }

    /**
     * Calculate tool num.
     */
    public int calculateToolNum() {
        int num = 0;
        for (Tool tool : this.getTool()) {
            num += tool.getNumber();
        }
        return num;
    }

}
