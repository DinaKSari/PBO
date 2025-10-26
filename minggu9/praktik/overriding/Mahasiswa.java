package minggu9.praktik.overriding;
public class Mahasiswa extends Manusia {
    public Mahasiswa(String nama) {
        super(nama);
    }
    @Override
    public void makan() {
        System.out.println(getNama() + " (Mahasiswa) sedang makan mie instan di kos.");
    }
    public void tidur() {
        System.out.println(getNama() + " sedang tidur di kelas.");
    }
}
