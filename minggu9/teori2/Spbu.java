package minggu9.teori2;

public class Spbu {
    private final int HARGA_PERTAMAX = 10000;
    private final int HARGA_PERTALITE = 5000;

    public void isiBahanBakar(Mobil mobil, int bayar) {
        String jenisBBM = mobil.getJenisBahanBakar();

        int liter = 0;
        String namaBBM = "";

        if (jenisBBM.equals("Pertamax")) {
            liter = bayar / HARGA_PERTAMAX;
            namaBBM = "pertamax";
        } else if (jenisBBM.equals("Pertalite")) {
            liter = bayar / HARGA_PERTALITE;
            namaBBM = "pertalite";
        } else {
            System.out.println("Jenis bahan bakar tidak dikenali.");
            return;
        }
        System.out.println(mobil.getJenis() + " diisi " + namaBBM + " sebanyak " + liter + " liter");
    }
}
