package uts.game;

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


}
