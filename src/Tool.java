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
    //private int number;
    private String name;
    private String label;
    private String nameCN;//中文名字

    public Tool(String name) {
        this.name = name;
        if(name.equals("doubleAttackPower"))
        {
            this.label = "使用道具，得到了双倍的攻击力";
            this.nameCN = "双倍攻击力";
        }
        if(name.equals("poison"))
        {
            this.label = "使用道具，对敌人施放毒药，减少敌人30HP";
            this.nameCN = "施放毒药";
        }
        if(name.equals("doubleAttackTimes"))
        {
            this.label = "使用道具，得到了两次攻击机会";
            this.nameCN = "两次攻击";
        }
        if(name.equals("recover"))
        {
            this.label = "使用道具，恢复了30HP";
            this.nameCN = "恢复血量";
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

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }
}
