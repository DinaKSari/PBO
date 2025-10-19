package uts.game;
import java.util.*;
public abstract class Character {
    private final String name;
    protected final int maxHealth;
    private int health;
    private final int attackPower;

    private final List<StatusEffect> effects = new ArrayList<>();

    protected Character(String name, int health, int attackPower) {
        // validasi & inisialisasi
    }

    public final String getName() { return name; }
    public final int getAttackPower() { return attackPower; }
    public final int getHealth() { return health; }
    protected final void setHealth(int value) { /* clamp 0..maxHealth */ }

    protected int onIncomingDamage(int base) {
        // hook untuk efek seperti Shield; default return base
        return base;
    }

    public final boolean isAlive() { return health > 0; }

    public final void takeDamage(int dmg) { setHealth(getHealth() - Math.max(0, dmg)); }

    public final void addEffect(StatusEffect e) { /* validasi & tambah */ }

    public final void performTurn(Character target) {
        // panggil effects.onTurnStart, attack(target), effects.onTurnEnd
    }

    public abstract void attack(Character target);
}