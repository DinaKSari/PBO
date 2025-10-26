package minggu9.praktik.overriding;
public class Dosen extends Manusia {
    public Dosen(String nama) {
        super(nama);
    }
    @Override
    public void makan() {
        System.out.println(getNama() + " (Dosen) sedang makan di kantin dosen.");
    }
    public void lembur() {
        System.out.println(getNama() + " sedang lembur menilai tugas.");
    }
}