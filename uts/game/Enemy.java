package uts.game;

public abstract class Enemy extends Character {
    private int threatLevel; // 1..5
    protected AttackStrategy strategy;

    protected Enemy(String name, int hp, int ap, int threatLevel, AttackStrategy strategy) {
        super(name, hp, ap);
        if (threatLevel < 1) {
            System.out.println("Input threat level (" + threatLevel + ") tidak valid, diatur ke 1.");
            this.threatLevel = 1;
        } else if (threatLevel > 5) {
            System.out.println("Input threat level (" + threatLevel + ") tidak valid, diatur ke 5.");
            this.threatLevel = 5;
        } else {
            this.threatLevel = threatLevel;
        }
        if (strategy == null) {
            System.out.println("Error: AttackStrategy tidak boleh null!");
            throw new IllegalArgumentException("AttackStrategy tidak boleh null.");
        } else {
            this.strategy = strategy;
        }
    }

    public final int getThreatLevel() { return threatLevel; }
    public final void setStrategy(AttackStrategy s) {
        if (s != null) {
            this.strategy = s;
        } else {
            System.out.println("Gagal mengganti strategy: strategy baru tidak boleh null.");
        }
    }
}