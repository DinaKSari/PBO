package minggu4.dina.relasiclass.percobaan2;
public class MainPercobaan2 {
    public static void main(String[] args) {
        Mobil m = new Mobil();
        m.setMerk("Avanza");
        m.setBiaya(350000);

        Sopir s = new Sopir();
        s.setNama("John Doe");
        s.setBiaya(200000);

        Pelanggan p = new Pelanggan();
        p.setNama("Jane Doe");
        p.setMobil(m); // Menghubungkan objek Mobil ke objek Pelanggan
        p.setSopir(s); // Menghubungkan objek Sopir ke objek Pelanggan
        p.setHari(2);

        System.out.println("Biaya Total = " + p.hitungBiayaTotal());
    }
}
