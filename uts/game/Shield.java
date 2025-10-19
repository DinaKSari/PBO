package uts.game;

public class Shield implements StatusEffect {
    private int flatReduce;
    private int duration;

    public Shield(int flatReduce, int duration) {
        this.flatReduce = Math.max(0, flatReduce);
        this.duration = Math.max(1, duration);
    }

    @Override
    public void onTurnStart(Character self) {
        // No effect di awal giliran
    }

    @Override
    public void onTurnEnd(Character self) {
        this.duration--;
        if (isExpired()) {
            System.out.println("Shield milik " + self.getName() + " hancur.");
        }
    }

    @Override
    public boolean isExpired() {
        return this.duration <= 0;
    }
}
