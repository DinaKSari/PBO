package uts.game;
import java.util.*;

public class Player extends Character {
    private int level;
    private AttackStrategy strategy;
    private final List<Skill> skills = new ArrayList<>();

    public Player(String name, int hp, int ap, int level, AttackStrategy strategy) {
        super(name, hp, ap);
        if (level < 1) {
            System.out.println("Level tidak valid (< 1), diatur ke 1.");
            this.level = 1;
        } else {
            this.level = level;
        }
    }
    private static final Random rand = new Random();
    public void addSkill(Skill s) { /* non-null */ }

    @Override
    public void attack(Character target) {
        // gunakan strategy computeDamage, cek apakah ada PiercingStrike di skills lalu apply
    }
}
