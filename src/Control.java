

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 * The type Control.
 *
 * @author Lv and Zhou
 * @Description cat, dog Animal类
 * strength 攻击力度
 * operation 操作(0：表示选择道具的输入操作，1表示攻击力度的输入操作
 * over 比赛是否结束，True结束，False没结束
 * round 回合数
 * roundOwner 当前回合所有者 0：cat，1：dog
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
    private int roundOwner;
    private Wind wind;
    /**
     * The constant TOOL1.
     * 不使用道具
     */
    public static final int TOOL1 = 1;
    /**
     * The constant TOOL2.
     * 双倍攻击力
     */
    public static final int TOOL2 = 2;
    /**
     * The constant TOOL3.
     * 施放毒药
     */
    public static final int TOOL3 = 3;
    /**
     * The constant TOOL4.
     * 两次攻击
     */
    public static final int TOOL4 = 4;
    /**
     * The constant TOOL5.
     * 恢复血量
     */
    public static final int TOOL5 = 5;
    /**
     * The constant MAXSTRENGTH.
     * 最大输入力度
     */
    public static final int MAXSTRENGTH = 10;
    /**
     * The constant MINSTRENGTH.
     * 最小输入力度
     */
    public static final int MINSTRENGTH = 0;
    /**
     * The constant MINHITSTRENGTH.
     * 无风时最小击中力度
     */
    public static final int MINHITSTRENGTH = 4;
    /**
     * The constant MAXHITSTRENGTH.
     * 无风时最大击中力度
     */
    public static final int MAXHITSTRENGTH = 6;
    /**
     * The constant TOOLOP.
     * 表示当前回合的选择道具阶段
     */
    public static final int TOOLOP = 1;
    /**
     * The constant ATKOP.
     * 表示当前回合的输入攻击力度阶段
     */
    public static final int ATKOP = 2;
    /**
     * The constant TOOLOPLOWBORDER.
     * 选择道具阶段输入的下界
     */
    public static final int TOOLOPLOWBORDER = 1;
    /**
     * The constant TOOLOPHIGHBORDER.
     * 选择道具阶段输入的上界
     */
    public static final int TOOLOPHIGHBORDER = 5;


    /**
     * Instantiates a new Control.
     */
    public Control(){
        this.cat = new Animal("cat");
        this.dog = new Animal("dog");
        this.strength = 0;
        this.over = false;
        this.round = 1;
        this.operation = TOOLOP;
        this.whoGoesFirstJudge();
        this.wind = new Wind();
    }

    public void setRoundOwner(int roundOwner) {
        this.roundOwner = roundOwner;
    }

    public int getRoundOwner() {
        return roundOwner;
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

    /**
     * Is numeric boolean.
     *
     * @param str the str
     * @return the boolean
     */
    public static boolean isNumeric(String str){
        if(!str.isEmpty()){
            for (int i = str.length();--i>=0;){
                if (!Character.isDigit(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Output.
     */
    public void output(){
        System.out.print("Cat               风向: "+this.wind.getDirect());
        if(this.wind.getActualWindStrength() == 0){
            System.out.print("--");
        }else if(this.wind.getActualWindStrength() < 0){
            System.out.print("<--");
        }else {
            System.out.print("-->");
        }
        System.out.println("  风速:"+this.wind.getWindStrength()+"                Dog");
        System.out.println("HP:" + this.cat.getHP() +"                                              Dog:" + this.dog.getHP());
        System.out.println("道具数:" + this.cat.getTool().size() +"                                             道具数:" + this.dog.getTool().size());
    }

    /**
     * Play.
     * 完整的游戏过程
     */
    public void play(){
        while (!this.over){
            System.out.println("ROUND  " + this.getRound());
            this.setRound(this.getRound()+1);
            this.wind.getRandomWind();
            this.output();
            if(this.getRoundOwner() == 0){
                this.catPlay();
                this.gameOver();
                if(over){ break; }
                this.changeRound();
                this.dogPlay();
                this.gameOver();
                this.changeRound();
            }else {
                this.dogPlay();
                this.gameOver();
                if(over){ break; }
                this.changeRound();
                this.catPlay();
                this.gameOver();
                this.changeRound();
            }
            System.out.println("==========================================================");
        }
    }

    /**
     * catPlay.
     * 猫猫的一个完整回合
     *
     */
    private void catPlay(){
        System.out.println("猫猫的回合  go!");
        this.getOperationInput();
        this.useTool();
        this.getInput();
        this.attack();
        this.cat.endUsingTool();
        this.cat.randomToolGet();
        if(this.operationNum == TOOL4){
            this.catPlay();
        }
    }

    /**
     * dogPlay.
     * 狗狗的一个完整回合
     *
     */
    private void dogPlay(){
        System.out.println("狗狗的回合  go!");
        this.getOperationInput();
        this.useTool();
        this.getInput();
        this.attack();
        this.dog.endUsingTool();
        this.dog.randomToolGet();
        if(this.operationNum == TOOL4){
            this.dogPlay();
        }
    }


    /**
     * Attack int.
     * 对敌方进行攻击并进行命中判定
     *
     * @return the int
     */
    public int attack(){
        //只有在1 2 4三种道具下才需要判定攻击
        if(this.operationNum == TOOL1 || this.operationNum == TOOL2 ||this.operationNum == TOOL4){
            if(this.roundOwner == 0){
                if(this.getStrength()>=MINHITSTRENGTH-this.wind.getActualWindStrength() && this.getStrength()<=MAXHITSTRENGTH-this.wind.getActualWindStrength()){
                    this.cat.attack(this.dog,cat.getATK());
                    return 0;
                }else{
                    System.out.println("攻击没有命中");
                    return 2;
                }
            }else if(this.roundOwner == 1){
                if(this.getStrength()>=MINHITSTRENGTH+this.wind.getActualWindStrength() && this.getStrength()<=MAXHITSTRENGTH+this.wind.getActualWindStrength()){
                    this.dog.attack(this.cat,dog.getATK());
                    return 1;
                }else{
                    System.out.println("攻击没有命中");
                    return 2;
                }
            }else{
                System.out.println("error");
                return -1;
            }
        }else {
            //不需要进行攻击
            return -99;
        }

    }

    /**
     * Game over int.
     *检测游戏是否已经结束
     * @return the int
     */
    public int gameOver(){
        if(this.dog.getHP()<=0){
            this.over = true;
            System.out.println("Cat WIN");
            return 0;
        }
        if(this.cat.getHP()<=0){
            this.over = true;
            System.out.println("Dog WIN");
            return 1;
        }
        return -1;
    }


    /**
     * Get input int.
     * 检测与获取玩家的攻击力度。
     * 仅允许0-10的整数
     *
     * @return the int
     */
    public int getInput(){
        //只有在1 2 4三种道具下才需要输入攻击力度
        if(this.operationNum == TOOL1 || this.operationNum == TOOL2 ||this.operationNum == TOOL4){
            Scanner scanner= new Scanner(System.in);
            System.out.println("请输入你的攻击力度（0-10的整数）");
            String index;
            int istrength;
            while (true){
                index = scanner.nextLine();
                if(isNumeric(index)){
                    istrength = Integer.parseInt(index);
                    if(istrength <= MAXSTRENGTH && istrength >= MINSTRENGTH){
                        this.setStrength(istrength);
                        this.setOperation(TOOLOP);
                        return this.strength;
                    }else{
                        System.out.println("输入力度不在正确范围内，请重新输入");
                    }
                }else {
                    System.out.println("输入力度不在正确范围内，请重新输入");
                }
            }
        }else{
            //不需要输入攻击力度
            return -99;
        }
    }

    /**
     * 显示玩家已有道具
     * 检测记录玩家选择的道具
     * 只允许输入为范围内的合法整数.
     *
     * @return the int
     */
    public int getOperationInput(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("请选择你的操作（输入操作前的数字）");
        System.out.println("1.不使用道具");
        Animal animal = new Animal();
        //猫的回合，则展示猫拥有的所有道具
        if(this.roundOwner == 0)
        {
            animal = this.cat;
        }
        //狗的回合，则展示狗拥有的所有道具
        else if(this.roundOwner == 1)
        {
            animal = this.dog;
        }
        //序号
        int num = 2;
        for(Tool tool :animal.getTool()){
            System.out.println(num+".使用道具:"+tool.getNameCn()+"  道具数量:"+tool.getNumber());
            num++;
        }
        String index;
        int ioperationNum;
        while (true){
            index = scanner.nextLine();
            if(isNumeric(index)){
                ioperationNum = Integer.parseInt(index);
                if(ioperationNum <= TOOLOPHIGHBORDER && ioperationNum >= TOOLOPLOWBORDER){
                    if(ioperationNum != TOOLOPLOWBORDER){
                        if(animal.getTool().get(ioperationNum-2).getNumber() <=0) {
                            System.out.println("道具数为0！请再一次进行选择");
                        }else{
                            this.setOperationNum(ioperationNum);
                            this.setOperation(ATKOP);
                            return this.operationNum;
                        }
                    }else{
                        this.setOperationNum(ioperationNum);
                        this.setOperation(ATKOP);
                        return this.operationNum;
                    }
                }else{
                    System.out.println("选择道具有误");
                }
            }else {
                System.out.println("选择道具有误");
            }
        }
    }

    /**
     * Use tool int.
     *operationNum表示玩家输入的数字，此数字对应相应的道具，作为参数传递给猫获狗的useTool函数，由其进行使用道具、使用完后移除道具的过程。
     * 但是由于某些道具在control类中实现比较方便，故将其写在以下函数，分别为 毒药 和 两次攻击 ，其中两次攻击尚未实现，需要设计此类的同学斟酌过后加以实现
     * @return the int
     */
    public int useTool(){
        if(this.operationNum != TOOLOPLOWBORDER){
            Animal animal = new Animal();
            if(this.roundOwner == 0) {
                animal = this.cat;
            } else if(this.roundOwner == 1) {
                animal = this.dog;
            } else {
                return  -1;
            }
            if(this.operationNum <= animal.getTool().size()+1){
                String toolName = animal.getTool().get(operationNum-2).getName();
                if(toolName.equals("poison")){
                    System.out.println(animal.getName()+animal.getTool().get(operationNum-2).getLabel());
                    //打印道具信息
                    Animal opposite = this.roundOwner==0?this.dog:this.cat;
                    //得到对手
                    List<Tool> tools = animal.getTool();
                    int indexTool = operationNum-2;
                    tools.get(indexTool).setNumber(tools.get(indexTool).getNumber()-1);
                    //使用完后移除道具
                    animal.setTool(tools);
                    animal.attack(opposite,30);
                    //产生伤害
                    return 0;
                }
                else if(toolName.equals("doubleAttackTimes")){
                    System.out.println(animal.getName()+animal.getTool().get(operationNum-2).getLabel());
                    //打印道具信息
                    List<Tool> tools = animal.getTool();
                    int indexTool = operationNum-2;
                    tools.get(indexTool).setNumber(tools.get(indexTool).getNumber()-1);
                    //使用完后移除道具
                    animal.setTool(tools);
                    return 0;
                }
                else {
                    return animal.useTool(operationNum);
                }
            }else{
                return -1;
            }
        }else{
            return -1;
        }
    }

    /**
     * Change round.
     */
    public void changeRound(){
        this.setRoundOwner((this.roundOwner + 1) % 2);
    }


    /**
     * Set input.
     * 仅是为了测试而写的函数，在程序运行过程中无意义
     *
     * @param input the input
     */
    public void setInput(int input){
        if(this.operation == TOOLOP){
            this.setOperationNum(input);
        }else if(this.operation == ATKOP){
            this.setStrength(input);
        }else{
            return;
        }
    }


    /**
     * Who goes first judge.
     * 游戏开始前初始化函数
     */
    public void whoGoesFirstJudge(){
        Random random = new Random();
        this.setRoundOwner(random.nextInt(2));
    }


    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        Control control = new Control();
        control.play();
    }
}
