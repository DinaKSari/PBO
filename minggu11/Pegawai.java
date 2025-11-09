package minggu11;
public class Pegawai {
    // Menggunakan 'protected' agar bisa diakses oleh subclass
    protected String nama;
    protected int gaji;

    // Konstruktor default
    public Pegawai() {
    }

    // Konstruktor dengan parameter
    public Pegawai(String nama, int gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    // Method untuk mendapatkan gaji pokok
    public int getGaji() {
        return gaji;
    }

    // Method tambahan (tidak ada di diagram, tapi logis untuk ada)
    public String getNama() {
        return nama;
    }
}