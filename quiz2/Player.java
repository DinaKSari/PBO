package quiz2;
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
        if (strategy == null) {
             System.out.println("Error: AttackStrategy tidak boleh null!");
            throw new IllegalArgumentException("AttackStrategy tidak boleh null.");
        } else {
            this.strategy = strategy;
        }
    }
    private static final Random rand = new Random();
    public void addSkill(Skill s) {
        if (s != null) {
            this.skills.add(s);
            System.out.println(getName() + " mempelajari skill: " + s.name());
        } else {
            System.out.println("Gagal menambahkan skill: skill tidak boleh null.");
        }
    }

    @Override
    public void attack(Character target) {
        boolean hasPiercingStrike = false;
        for (Skill s : this.skills) {
            if (s instanceof PiercingStrike) {
                hasPiercingStrike = true;
                break;
            }
        }
        if (hasPiercingStrike && !this.skills.isEmpty()) {
            Skill randomSkill = this.skills.get(rand.nextInt(this.skills.size()));
            System.out.println(getName() + " memutuskan menggunakan skill " + randomSkill.name() + "!");
            randomSkill.apply(this, target);
            
        } else {
            System.out.println(getName() + " melakukan serangan biasa!");
            int damage = this.strategy.computeDamage(this, target);
            target.takeDamage(damage);
        }
    }
    public int getLevel(){
        return level;
    }
}
