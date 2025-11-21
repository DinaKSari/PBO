package quiz2;

public class HealSkill implements Skill {
    private final int amount;
    public HealSkill(int amount) {
        this.amount = Math.max(0, amount);
    }
    @Override
    public String name() {
        return "Heal";
    }

    @Override
    public void apply(Character self, Character target) {
        int newHealth = self.getHealth() + this.amount;
        self.setHealth(newHealth);
        
        System.out.println(self.getName() + " memulihkan diri sebanyak " + this.amount + " HP. (HP sekarang: " + self.getHealth() + ")");
    }
}
