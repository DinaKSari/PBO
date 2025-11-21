package quiz2;

public class Regen implements StatusEffect {
    private int healPerTurn;
    private int duration;

    public Regen(int healPerTurn, int duration) {
        this.healPerTurn = Math.max(0, healPerTurn);
        this.duration = Math.max(1, duration);    
    }

    @Override
    public void onTurnStart(Character self) {
        System.out.println(self.getName() + " meregenerasi " + this.healPerTurn + " HP.");
        self.setHealth(self.getHealth() + this.healPerTurn);
    }

    @Override
    public void onTurnEnd(Character self) {
        this.duration--;
        if (isExpired()) {
            System.out.println(self.getName() + " berhenti meregenerasi.");
        }
    }

    @Override
    public boolean isExpired() {
        return this.duration <= 0;
    }
}
