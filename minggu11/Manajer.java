package minggu11;

public class Manajer extends Pegawai {
    private int tunjangan;

    // Konstruktor Manajer
    public Manajer(String nama, int gaji, int tunjangan) {
        // Memanggil konstruktor superclass (Pegawai)
        super(nama, gaji);
        this.tunjangan = tunjangan;
    }

    // Override method getGaji() dari superclass
    @Override
    public int getGaji() {
        // Gaji total = gaji pokok + tunjangan
        return super.getGaji() + tunjangan;
    }

    // Method khusus Manajer
    public int getTunjangan() {
        return tunjangan;
    }
}