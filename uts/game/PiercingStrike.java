package uts.game;

public class PiercingStrike implements Skill {
    private final double multiplier;
    public PiercingStrike(double multiplier) {
        this.multiplier = Math.max(0, multiplier);
    }

    @Override
    public String name() {
        return "Piercing Strike";
    }

    @Override
    public void apply(Character self, Character target) {
        int damage = (int) (self.getAttackPower() * this.multiplier);
        System.out.println(self.getName() + " menggunakan " + name() + " terhadap " + target.getName() + "!");
        target.setHealth(target.getHealth() - Math.max(0, damage));
    }
}
