import java.util.Scanner;

public class Control {
    private Animal cat;
    private Animal dog;
    private int cat_strength;
    private int dog_strength;
    private boolean over;
    private int round;


    public Control(){
        this.cat = new Animal();
        this.dog = new Animal();
        this.cat_strength = 0;
        this.over = false;
        this.round = 1;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public int getCat_strength() {
        return cat_strength;
    }

    public void setCat_strength(int strength) {
        this.cat_strength = strength;
    }

    public int getDog_strength() {
        return dog_strength;
    }

    public void setDog_strength(int dog_strength) {
        this.dog_strength = dog_strength;
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

    public void cat_ATK(Scanner sc){
        System.out.println("猫猫的回合，请输入猫猫的攻击力度(0~10): ");
        int strength = sc.nextInt();
        while (strength<0 || strength>10){
            System.out.println("攻击力度有误，只能输入0~10");
            strength=sc.nextInt();
        }
        this.setCat_strength(strength);
        if(this.cat_strength>=4 && this.cat_strength<=6){
            this.dog.setHP(this.dog.getHP()-this.cat.getATK());
        }
        this.gameOver();
    }

    public void dog_ATK(Scanner sc){
        System.out.println("狗狗的回合，请输入狗狗的攻击力度(0~10): ");
        int strength = sc.nextInt();
        while (strength<0 || strength>10){
            System.out.println("攻击力度有误，只能输入0~10");
            strength=sc.nextInt();
        }
        this.setDog_strength(strength);
        if(this.dog_strength>=4 && this.dog_strength<=6){
            this.cat.setHP(this.cat.getHP()-this.dog.getATK());
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

    public static void main(String[] args){
        Control control = new Control();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("ROUND  " + control.getRound());
            control.setRound(control.getRound()+1);
            control.output();
            control.cat_ATK(sc);
            control.output();
            if(control.isOver()){
                System.out.println("Cat WIN");
                break;
            }
            control.dog_ATK(sc);
            control.output();
            if(control.isOver()){
                System.out.println("Dog WIN");
                break;
            }
            System.out.println("==========================================================");
        }
    }
}
