package minggu11;

public class Manajer extends Pegawai {
    private int tunjangan;

    public Manajer(String nama, int gaji, int tunjangan) {
        super(nama, gaji);
        this.tunjangan = tunjangan;
    }

    // getGaji() tidak di-override

    public int getTunjangan() {
        return tunjangan;
    }
}