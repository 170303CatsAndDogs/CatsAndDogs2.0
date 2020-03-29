/**
 * 道具类
 * @author Chen and Dai
 * 此类的每一个实例只对应一个道具对象，故而取消原定的number属性
 * 将原先需求改为：在Animal类中的tool属性更改为一个tool类型的数组，通过此数组长度判断是否有道具可使用
 *
 * 以下为属性注释（截至目前）
 * name可选值为："doubleAttackPower"（双倍攻击力）
 * label可选值为："使用道具，得到了双倍的攻击力"
 * */

public class Tool {
    //private int number;
    private String name;
    private String label;

    public Tool(String name) {
        this.name = name;
        if(name.equals("doubleAttackPower"))
        {
            this.label = "使用道具，得到了双倍的攻击力";
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

}
