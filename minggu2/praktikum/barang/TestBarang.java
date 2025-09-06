package praktikum.barang;

public class TestBarang {
    public static void main(String[] args) {
        Barang brg1 = new Barang();

        brg1.kode = "100";
        brg1.namaBarang = "keripik kentang";
        brg1.hargaDasar = 10000;
        brg1.diskon = 0.25f;
        brg1.tampilData();

    }
}
