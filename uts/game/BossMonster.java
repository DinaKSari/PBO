package uts.game;

public class BossMonster extends Enemy {
    private int turnCounter = 0;

    public BossMonster(String name, int hp, int ap, int threatlevel,
AttackStrategy strategy) {
        super(name, hp, ap, threatlevel, strategy);
    }

    @Override
    public void attack(Character target) {
        // Rage Strike: 2x damage jika hp < 50% atau setiap 3 giliran
    }
}
