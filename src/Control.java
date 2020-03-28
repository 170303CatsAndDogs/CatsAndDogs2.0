import java.util.Scanner;


/**
 * @Description cat,dog Animal类
 *              strength 攻击力度
 *              operation 操作(0：表示选择道具的输入操作，1表示攻击力度的输入操作
 *              over 比赛是否结束，True结束，False没结束
 *              round 回合数
 *              roundOwner 当前回合所有者
 * @author  Lv and Zhou
 * @date 2020.3.27
 */
public class Control {
    private Animal cat;
    private Animal dog;
    private int strength;
    private int operation;
    private int operationNum;
    private boolean over;
    private int round;
    private String roundOwner;
    public static final int MAXSTRENGTH = 10;
    public static final int MINSTRENGTH = 0;
    public static final int MINHITSTRENGTH = 4;
    public static final int MAXHITSTRENGTH = 6;
    public static final int TOOLOP = 1;
    public static final int ATKOP = 2;
    public static final int OP1LOWBORDER = 1;
    public static final int OP1HIGHBORDER = 5;
    public static final int OP2LOWBORDER = 0;
    public static final int OP2HIGHBORDER = 10;


    public Control(){
        this.cat = new Animal();
        this.dog = new Animal();
        this.strength = 0;
        this.over = false;
        this.round = 1;
    }

    public void setRoundOwner(String roundOwner) {
        this.roundOwner = roundOwner;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public void setOperationNum(int operationNum) {
        this.operationNum = operationNum;
    }

    public boolean getOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public Animal getCat() {
        return cat;
    }

    public Animal getDog() {
        return dog;
    }

    public void output(){
        System.out.println("Cat                                                 Dog");
        System.out.println("HP:" + this.cat.getHP() +"                                              Dog:" + this.dog.getHP());
        System.out.println("道具数:" + this.cat.getTool().getNumber() +"                                             道具数:" + this.dog.getTool().getNumber());
    }

    public void animalAtk(Scanner sc){

        System.out.println("猫猫的回合，请输入猫猫的攻击力度(0~10): ");
        int strength = sc.nextInt();
        while (strength < MINSTRENGTH || strength > MAXSTRENGTH){
            System.out.println("攻击力度有误，只能输入0~10");
            strength=sc.nextInt();
        }
        this.setStrength(strength);
        if(this.strength >= MINHITSTRENGTH && this.strength<=MAXHITSTRENGTH){
            this.dog.setHP(this.dog.getHP()-this.cat.getATK());
        }
        this.gameOver();
    }

    public void gameOver(){
        if(this.dog.getHP()<=0){
            this.over = true;
        }
        if(this.cat.getHP()<=0){
            this.over = true;
        }
    }

    public int getInput(){
//        Scanner scanner= new Scanner(System.in);
        if(this.operation == TOOLOP){
            System.out.println("请选择你的操作（输入操作前的数字）");
            System.out.println("1.不使用道具");
            System.out.println("2.使用道具1");
            System.out.println("3.使用道具2");
            System.out.println("4.使用道具3");
            System.out.println("5.使用道具4");
//            this.setOperationNum(scanner.nextInt());
            if(this.operationNum <= OP1HIGHBORDER && this.operationNum >= OP1LOWBORDER){
                this.setOperation(ATKOP);
                return this.operationNum;
            }
        }
        else if(this.operation == ATKOP){
            System.out.println("请输入你的攻击力度（0-10）");
//            this.setOperationNum(scanner.nextInt());
            if(this.operationNum <= OP2HIGHBORDER && this.operationNum >= OP2LOWBORDER){
                this.setOperation(TOOLOP);
                return this.operationNum;
            }
        }
        System.out.println("输入不在正确范围内，请重新输入");
        return -1;
    }

    public int useTool(){
        if(cat.getName().equals(this.roundOwner)){
            return cat.useTool();
        }else{
            return dog.useTool();
        }
    }


    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while (true){
//            System.out.println("ROUND  " + control.getRound());
//            control.setRound(control.getRound()+1);
//            control.output();
//            control.animalAtk(sc);
//            control.output();
//            if(control.getOver()){
//                System.out.println("Cat WIN");
//                break;
//            }
//            control.animalAtk(sc);
//            control.output();
//            if(control.getOver()){
//                System.out.println("Dog WIN");
//                break;
//            }
//            System.out.println("==========================================================");
//        }
    }
}
