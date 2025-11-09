package minggu11.tugas;

public class Barrier implements Destroyable {
    private int strength;

    public Barrier(int strength) {
        this.strength = strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public void destroyed() {
        this.strength = (int) (this.strength * 0.9);
    }

    public String getBarrierInfo() {
        return "Barrier Strength = " + this.strength;
    }
}