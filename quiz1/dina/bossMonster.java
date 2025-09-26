package quiz1.dina;
public class bossMonster extends Character{
    private int seranganSpecial;
    public bossMonster(String name, int health, int attackPower) { 
        super(name, health, attackPower); 
        seranganSpecial = attackPower * 2; 
    } 

    @Override 
    public void attack(Character target) { 
        int damage = (int)(Math.random() * 10) + 5; // random damage 
        System.out.println(getName() + " (" + type + ") attacks ferociously! Damage: " + 
        damage); 
        target.takeDamage(damage); 
    } 
}
