/**
 * 道具类
 * @author Chen and Dai
 * 此类的每一个实例只对应一个道具对象，故而取消原定的number属性
 * 将原先需求改为：在Animal类中的tool属性更改为一个tool类型的集合，通过此集合长度判断是否有道具可使用
 *
 * 以下为属性注释（截至目前）
 * name可选值为："doubleAttackPower":（双倍攻击力） "poison":(毒药) "doubleAttackTimes":(两次攻击机会) "recover":(回血)

 * */

public class Tool {
    private int number;
    private String name;
    private String label;
    /*中文名字*/
    private String nameCn;
    /**
     * The constant DOUBLEATTACKTIMES.
     * 两次攻击name值
     */
    public static final String DOUBLEATTACKTIMES = "doubleAttackTimes";
    /**
     * The constant POISON.
     *毒药name值
     */
    public static final String POISON = "poison";
    /**
     * The constant DOUBLEATTACKPOWER.
     * 双倍攻击力name值
     */
    public static final String DOUBLEATTACKPOWER = "doubleAttackPower";
    /**
     * The constant RECOVER.
     *回血name值
     */
    public static final String RECOVER = "recover";
    /**
     * The constant RECOVER.
     *回血值
     */
    public static final int RECOVERHP = 30;
    /**
     * The constant RECOVER.
     *回血上限
     */
    public static final int MAXHP = 100;
    /**
     * The constant RATEx.
     *获得道具几率分隔值
     * 0~60 无道具
     * 60~70 双倍攻击力
     * 70~80 毒药
     * 80~90 两次攻击机会
     * 90~100 恢复30hp
     */
    public static final int RATE1 = 60;
    public static final int RATE2 = 70;
    public static final int RATE3 = 80;
    public static final int RATE4 = 90;
    public static final int RATE5 = 100;

    public Tool(String name) {
        this.number = 1;
        this.name = name;
        if(DOUBLEATTACKPOWER.equals(name))
        {
            this.label = "使用道具，得到了双倍的攻击力";
            this.nameCn = "双倍攻击力";
            this.number=1;
        }
        if(POISON.equals(name))
        {
            this.label = "使用道具，对敌人施放毒药，减少敌人30HP";
            this.nameCn = "施放毒药";
            this.number=1;
        }
        if(DOUBLEATTACKTIMES.equals(name))
        {
            this.label = "使用道具，得到了两次攻击机会";
            this.nameCn = "两次攻击";
            this.number=1;
        }
        if(RECOVER.equals(name))
        {
            this.label = "使用道具，恢复了30HP";
            this.nameCn = "恢复血量";
            this.number=1;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
}
