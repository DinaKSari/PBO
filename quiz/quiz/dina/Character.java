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
        System.out.println(name + " menyerang " + target.getName() + "!");
        target.takeDamage(attackPower);
    }

    public void takeDamage(int dmg){
        health -= dmg;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " menerima " + dmg + " damage. Sisa HP: " + health);
    }

    public int getAttack(){
        return attackPower;
    }

    public void setAttack(int power){
        attackPower = power;
    }

    public String getName() { 
        return name; 
    }

    public int getHealth() { 
        return health; 
    }
}
