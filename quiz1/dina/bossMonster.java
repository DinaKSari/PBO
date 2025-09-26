package quiz1.dina;
public class bossMonster extends Character{
    private String bossType;
    public bossMonster(String name, int health, int attackPower, String bossType) { 
        super(name, health, attackPower); 
        this.bossType = bossType;
    } 

    @Override 
    public void attack(Character target) { 
        int damage = 2*((int)(Math.random() * 10) + 5); // random damage lalu damage 2 kali lipat
        System.out.println(getName() + " (" + bossType + ") attacks ferociously! Damage: " + 
        damage); 
        target.takeDamage(damage); 
    } 
}
