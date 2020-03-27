import java.util.Scanner;


/**
 * @author  Lv and Zhou
 *
 */
public class Control {
    private Animal cat;
    private Animal dog;
    private int strength;
    private boolean over;
    private int round;
    public static final int MAXSTRENGTH = 10;
    public static final int MINHITSTRENGTH = 4;
    public static final int MAXHITSTRENGTH = 6;


    public Control(){
        this.cat = new Animal();
        this.dog = new Animal();
        this.strength = 0;
        this.over = false;
        this.round = 1;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
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
        while (strength < 0 || strength > MAXSTRENGTH){
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

    public void getInput(){

    }

    public void useTool(){}


    public static void main(String[] args){
        Control control = new Control();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("ROUND  " + control.getRound());
            control.setRound(control.getRound()+1);
            control.output();
            control.animalAtk(sc);
            control.output();
            if(control.getOver()){
                System.out.println("Cat WIN");
                break;
            }
            control.animalAtk(sc);
            control.output();
            if(control.getOver()){
                System.out.println("Dog WIN");
                break;
            }
            System.out.println("==========================================================");
        }
    }
}
