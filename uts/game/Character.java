package uts.game;
import java.util.*;
public abstract class Character {
    private final String name;
    protected final int maxHealth;
    private int health;
    private final int attackPower;

    private final List<StatusEffect> effects = new ArrayList<>();

    protected Character(String name, int health, int attackPower) {
        this.name = name;
        if (health < 0) {
            System.out.println("Input health tidak valid (< 0), diatur ke 0.");
            this.health = 0;
        } else {
            this.health = health;
        }
        this.maxHealth = this.health;
        if (attackPower < 0) {
            System.out.println("Input attackPower tidak valid (< 0), diatur ke 0.");
            this.attackPower = 0;
        } else {
            this.attackPower = attackPower;
        }
    }

    public final String getName() { return name; }
    public final int getAttackPower() { return attackPower; }
    public final int getHealth() { return health; }
    protected final void setHealth(int value) {
        if (value > this.maxHealth) {
            this.health = this.maxHealth;
        } else if (value < 0) {
            this.health = 0;
        } else {
            this.health = value;
        }
    }

    protected int onIncomingDamage(int base) {
        int originalDamage = base;
        int totalReduction = 0;

        for (StatusEffect effect : this.effects) {
            if (effect instanceof Shield) {
                Shield shield = (Shield) effect;
                totalReduction += shield.getFlatReduce();
            }
        }
        if (totalReduction > 0) {
            base = Math.max(0, base - totalReduction);
            System.out.println(getName() + " memblok " + (originalDamage - base) + " damage dengan Shield!");
        }
        return base;
    }

    public final boolean isAlive() { return health > 0; }

    public final void takeDamage(int dmg) {
        int finalDamage = onIncomingDamage(dmg);
        setHealth(getHealth() - Math.max(0, finalDamage)); 
    }

    public final void addEffect(StatusEffect e) { /* validasi & tambah */ }

    public final void performTurn(Character target) {
        if (!this.isAlive()) {
            System.out.println(this.getName() + " sudah kalah dan tidak bisa bergerak.");
            return;
        } else if (!target.isAlive()) {
            System.out.println(this.getName() + " ingin menyerang " + target.getName() + ", tapi target sudah kalah.");
            return;
        } else{
            System.out.println(this.getName() + " menyerang " + target.getName() + "!");
            this.attack(target);
            if (!target.isAlive()) {
                System.out.println(target.getName() + " telah dikalahkan!");
            } else {
                System.out.println(target.getName() + " sekarang memiliki " + target.getHealth() + " HP.");
            }
        }
    }

    public abstract void attack(Character target);
}