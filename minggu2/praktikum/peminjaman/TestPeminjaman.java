package praktikum.peminjaman;

public class TestPeminjaman {
    public static void main(String[] args) {
        Peminjaman pm1 = new Peminjaman();
        Peminjaman pm2 = new Peminjaman();

        pm1.id= 001;
        pm1.namaMember = "Udin";
        pm1.namaGame = "GTA: SAN Andreas";
        pm1.harga = 25000.0;
        pm1.tampilkanData();
        System.out.println("Total harga: " +  pm1.menghitungHarga(3.0));

        pm2.id = 002;
        pm2.namaMember = "Aladudu";
        pm2.namaGame = "Barbie in fantasy";
        pm2.harga = 27000.0;
        pm2.tampilkanData();
        System.out.println("Total harga: " + pm2.menghitungHarga(7.0));
    }
}
