import java.util.ArrayList;
import java.util.List;

/**
 * 动物类
 * */
public class Animal {

    // 生命值
    private int HP;
    // 攻击力
    private int ATK;
    // 工具
    private List<Tool> tool;
    // 名字
    private String name;
    // 初始攻击力
    public static final int BASE_ATK = 10;

    /**
     * Constructors
     */
    public Animal() {
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new ArrayList<Tool>();
        //初始时拥有一个双倍攻击力的道具
        this.tool.add(new Tool("doubleAttackPower"));
    }

    public Animal(String name) {
        this.name = name;
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new ArrayList<Tool>();
        //初始时拥有一个双倍攻击力的道具
        this.tool.add(new Tool("doubleAttackPower"));

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
    public int useTool() {
        //通过tool集合长度判断道具数是否为零
        int num = this.tool.size();
        if (num == 0) {
            System.out.println("道具数为0！");
            return -1;
        }
        //使用道具后的效果实现，并打印出来
        this.ATK = BASE_ATK * 2;
        System.out.println(this.name+this.tool.get(0).getLabel());
        //删除使用过的道具，在版本一中暂时用remove(0)来实现
        this.tool.remove(0);
        //this.tool.size(num - 1);
        return 0;
    }

    /**
     * 道具效果结束，攻击力变为10
     */
    public void endUsingTool() {
        this.ATK = BASE_ATK;
    }

}
