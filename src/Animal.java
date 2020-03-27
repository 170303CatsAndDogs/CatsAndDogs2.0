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

    // Constructors
    public Animal() {
        this.ATK = 10;
        this.HP = 100;
        this.tool = new Tool();
    }

    public Animal(String name) {
        this.name = name;
        this.ATK = 10;
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

}
