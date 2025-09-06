package praktikum.lingkaran;

public class TestLingkaran {
    public static void main(String[] args) {
        Lingkaran l1 = new Lingkaran();

        l1.phi = 3.14;
        l1.r = 11;
        System.out.println("Luas lingkaran: " + l1.hitungLuas());
        System.out.println("Keliling lingkaran " + l1.hitungKeliling());
    }
}
