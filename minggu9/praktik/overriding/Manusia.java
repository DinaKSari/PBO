package minggu9.praktik.overriding;
public abstract class Manusia {
    private String nama;

    public Manusia(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void bernafas() {
        System.out.println(this.nama + " sedang bernafas.");
    }
    public void makan() {
        System.out.println(this.nama + " sedang makan.");
    }
}
