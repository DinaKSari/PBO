package uts.game;
public class Monster extends Enemy {
    public Monster(String name, int hp, int ap, int threatLevel,
AttackStrategy strategy) {
        super(name, hp, ap, threatLevel, strategy);
    }

    @Override
    public void attack(Character target) {
        // random damage berbasis attackPower / strategy
    }
}
