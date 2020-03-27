/**
 * 动物类
 * */

public class Animal {

    // 生命值
    private int HP;
    // 攻击力
    private int ATK;
    // 工具
    private Tool tool;
    // 名字
    private String name;
    //初始攻击力
    public static final int BASE_ATK = 10;

    // Constructors
    public Animal() {
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new Tool();
    }

    public Animal(String name) {
        this.name = name;
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new Tool();
    }

    // getters and setters
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

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 攻击
    public int attack(Animal animal, int atk) {
        if (animal == null) {
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

    // 使用道具(两倍攻击力效果一回合)
    public int useTool() {
        int num = this.tool.getNumber();
        if (num == 0) {
            System.out.println("道具数为0！");
            return -1;
        }
        this.ATK = BASE_ATK * 2;
        this.tool.setNumber(num - 1);
        return 0;
    }

    // 道具效果结束，攻击力变为10
    public void endUsingTool() {
        this.ATK = BASE_ATK;
    }

}
