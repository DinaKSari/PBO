package quiz.quiz.dina;
public class Character {
    private String name;
    private int health;
    private int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack(Character target){

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
