package minggu11.tugas;

public class JumpingZombie extends Zombie {

    public JumpingZombie(int health, int level) {
        super(health, level);
    }

    @Override
    public void heal() {
        if (level == 1) {
            health = (int) (health * 1.30);
        } else if (level == 2) {
            health = (int) (health * 1.40);
        } else if (level == 3) {
            health = (int) (health * 1.50);
        }
    }

    @Override
    public void destroyed() {
        // Logika disesuaikan agar output 100 -> 66 dalam 4 langkah
        this.health = (int) Math.round(this.health * 0.9);
    }

    @Override
    public String getZombieInfo() {
        // Menambahkan header spesifik
        return "Jumping Zombie Data =\n" + super.getZombieInfo();
    }
}