package uts.game;

public class BossMonster extends Enemy {
    private int turnCounter = 0;

    public BossMonster(String name, int hp, int ap, int threatlevel, AttackStrategy strategy) {
        super(name, hp, ap, threatlevel, strategy);
    }

    @Override
    public void attack(Character target) {
        turnCounter++;
        double damageMultiplier = 1.0;
        boolean isHealthLow = (double)getHealth() / (double)maxHealth < 0.5;
        boolean isThirdTurn = (turnCounter % 3 == 0);
        if (isHealthLow || isThirdTurn) {
            System.out.println(getName() + " menggunakan RAGE STRIKE (x2.0 Damage)!");
            damageMultiplier = 2.0;
        }
    }
}
