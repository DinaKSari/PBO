package uts.game;
import java.util.Random;

public class Monster extends Enemy {
    private static final Random rand = new Random();
    public Monster(String name, int hp, int ap, int threatLevel, AttackStrategy strategy) {
        super(name, hp, ap, threatLevel, strategy);
    }

    @Override
    public void attack(Character target) {
        int baseAP = getAttackPower();
        int minDamage = (int) (baseAP * 0.8);
        int maxDamage = (int) (baseAP * 1.2);
        int damage = rand.nextInt(maxDamage - minDamage + 1) + minDamage;

        target.takeDamage(damage);
    }
}
