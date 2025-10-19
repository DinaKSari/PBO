package uts.game;

public class FixedStrategy implements AttackStrategy {
    public FixedStrategy() {
    }

    @Override
    public int computeDamage(Character self, Character target) {
        return self.getAttackPower();
    }
}
