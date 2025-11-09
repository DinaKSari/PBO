package minggu11.tugas;

public class WalkingZombie extends Zombie {

    public WalkingZombie(int health, int level) {
        super(health, level);
    }
    @Override
    public void heal() {
        if (level == 1) {
            health = (int) (health * 1.20);
        } else if (level == 2) {
            health = (int) (health * 1.30);
        } else if (level == 3) {
            health = (int) (health * 1.40);
        }
    }

    @Override
    public void destroyed() {
        this.health = (int) (this.health * 0.81); 
    }

    @Override
    public String getZombieInfo() {
        return "Walking Zombie Data =\n" + super.getZombieInfo();
    }
}