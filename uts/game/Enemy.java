package uts.game;

public abstract class Enemy extends Character {
    private int threatLevel; // 1..5
    protected AttackStrategy strategy;

    protected Enemy(String name, int hp, int ap, int threatLevel,
            AttackStrategy strategy) {
        super(name, hp, ap);
        // validasi threatlevel & strategy
    }

    public final int getThreatLevel() { return threatLevel; }
    public final void setStrategy(AttackStrategy s) { /* non-null */ }
}