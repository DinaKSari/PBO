package minggu11;

public class Programmer extends Pegawai {
    private int bonus;

    public Programmer(String nama, int gaji, int bonus) {
        super(nama, gaji);
        this.bonus = bonus;
    }

    // getGaji() tidak di-override

    public int getBonus() {
        return bonus;
    }
}