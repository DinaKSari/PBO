package uts.game;

public class LevelScaledStrategy implements AttackStrategy {
    private final int bonusPerLevel;
    public LevelScaledStrategy(int bonusPerLevel) {
        this.bonusPerLevel = Math.max(0, bonusPerLevel);
    }

    @Override
    public int computeDamage(Character self, Character target) {
        int baseDamage = self.getAttackPower();
        if (self instanceof Player) {
            Player player = (Player) self;
            int bonus = player.getLevel() * this.bonusPerLevel;
            return baseDamage + bonus;
        }
        return baseDamage;
    }
}
