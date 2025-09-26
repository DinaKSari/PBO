package quiz1.dina;
// Subclass Player
class Player extends Character { 
    private int level; 
    public Player(String name, int health, int attackPower, int level) { 
        super(name, health, attackPower); 
        this.level = level; 
    } 
    @Override 
    public void attack(Character target) { 
        int damage = (int)(super.getHealth() * 0.1) + level; // bonus dari level 
        System.out.println(getName() + " attacks with sword! Damage: " + damage); 
        target.takeDamage(damage); 
    } 
} 
