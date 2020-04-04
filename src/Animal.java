import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        this.tool.add(new Tool("poison"));
        this.tool.add(new Tool("doubleAttackTimes"));
        this.tool.add(new Tool("recover"));
    }

    public Animal(String name) {
        this.name = name;
        this.ATK = BASE_ATK;
        this.HP = 100;
        this.tool = new ArrayList<Tool>();
        //初始时拥有一个双倍攻击力的道具
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
        int num = this.tool.size();
        if (num == 0) {
            System.out.println("道具数为0！");
            return -1;
        }
        Tool tool = this.getTool().get(operationNum-2);
        if(tool.getName().equals("doubleAttackPower")){
            this.ATK = BASE_ATK * 2;
            System.out.println(this.name+tool.getLabel());
            removeTool("doubleAttackPower");
            return 0;
        }
        else if(tool.getName().equals("recover")){
            if(this.HP+30>100) {
                this.HP = 100;
            }
            else {
                this.HP +=30 ;
            }
            System.out.println(this.name+tool.getLabel());
            removeTool("recover");
            return 0;
        }
        return 0;
    }
    /**
     * 随机道具获得
     * @return 成功返回0，否则返回-1
     */
    public int randomToolGet(){
        Random r = new Random();
        int random  = r.nextInt(100);

        if(random<=60){
            System.out.println(this.name+"没有获得随机道具");
            return 0;

        }
        else if(random>60&&random<=70){
            addTool("doubleAttackPower");
            System.out.println(this.name+"获得随机道具：双倍攻击力");
            return 0;
        }
        else if(random>70&&random<=80){
            addTool("poison");
            System.out.println(this.name+"获得随机道具：施放毒药");
            return 0;
        }
        else if(random>80&&random<=90){
            addTool("doubleAttackTimes");
            System.out.println(this.name+"获得随机道具：两次攻击机会");
            return 0;
        }
        else if(random>90&&random<=100){
            addTool("recover");
            System.out.println(this.name+"获得随机道具：恢复血量");
            return 0;
        }
        else {
            return -1 ;
        }
    }

    /**
     * 添加道具的方法
     * @return 成功 0 ，失败 -1
     */
    public int addTool(String toolName){
        List<Tool> tools = this.getTool();
        int flag = 0;
        for (Tool tool : tools) {
            if(tool.getName().equals(toolName)) {
                tool.setNumber(tool.getNumber()+1);
                flag = 1;
                return 0;
            }
        }
        if(flag == 0){
            tools.add(new Tool(toolName));
            return 0;
        }
        else {
            return -1;
        }
    }
    /**
     * 删除道具的方法
     * @return 成功 0 ，失败 -1
     */
    public int removeTool(String toolName) {
        List<Tool> tools = this.getTool();
        for (Tool tool : tools) {
            if (tool.getName().equals(toolName)) {
                if (tool.getNumber() > 1) {
                    tool.setNumber(tool.getNumber() - 1);
                    return 0;
                } else if (tool.getNumber() == 1) {
                    tools.remove(tool);
                    return 0;
                }
                else{
                    return -1;
                }

            } else {
                return -1;
            }
        }
        return 0;
    }
    /**
     * 道具效果结束，攻击力变为10
     */
    public void endUsingTool() {
        this.ATK = BASE_ATK;
    }

}
