package uts.game;
import java.util.Random;

public class Monster extends Enemy {
    private static final Random rand = new Random();
    public Monster(String name, int hp, int ap, int threatLevel, AttackStrategy strategy) {
        super(name, hp, ap, threatLevel, strategy);
    }

    @Override
    public void attack(Character target) {
        int baseDamage = this.strategy.computeDamage(this, target);
        int minDamage = (int) (baseDamage * 0.8);
        int maxDamage = (int) (baseDamage * 1.2);
        if (minDamage == 0 && maxDamage == 0) {
            maxDamage = 1;
        }
        int damage = rand.nextInt(maxDamage - minDamage + 1) + minDamage;

        target.takeDamage(damage);
    }
}
