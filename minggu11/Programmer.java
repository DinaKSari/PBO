package minggu11;

public class Programmer extends Pegawai {
    private int bonus;

    // Konstruktor Programmer
    public Programmer(String nama, int gaji, int bonus) {
        // Memanggil konstruktor superclass (Pegawai)
        super(nama, gaji);
        this.bonus = bonus;
    }

    // Override method getGaji() dari superclass
    @Override
    public int getGaji() {
        // Gaji total = gaji pokok + bonus
        return super.getGaji() + bonus;
    }

    // Method khusus Programmer
    public int getBonus() {
        return bonus;
    }
}