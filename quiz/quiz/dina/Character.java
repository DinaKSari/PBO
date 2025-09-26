package quiz.quiz.dina;
public class Character {
    private String name;
    private int health;
    private int attackPower;

    public void attack(){
        
    }

    public int takeDamage(int dmg){
        return health -= dmg;
    }

    public int getAttack(){
        return attackPower;
    }

    public void setAttack(int power){
        attackPower = power;
    }
}
