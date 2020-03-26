public class Animal {

    private int HP;
    private int ATK;
    private Tool tool;

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

    public Animal(){
        this.ATK = 10;
        this.HP = 100;
        this.tool = new Tool();
    }


}
