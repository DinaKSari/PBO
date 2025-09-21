package minggu4.dina.relasiclass.tugas;
import java.time.LocalDate;
public class MainTugas {
    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan("Perpustakaan Kampus");

        // Tambah anggota
        Anggota luna = new Anggota("A001", "Luna", 5);
        Anggota dina = new Anggota("A002", "Dina", 5);
        Anggota budi = new Anggota("A003", "Budi", 5);
        Anggota tono = new Anggota("A004", "Tono", 5);
        Anggota rey = new Anggota("A005", "Rey", 5);

        perpus.tambahAnggota(luna);
        perpus.tambahAnggota(dina);
        perpus.tambahAnggota(budi);
        perpus.tambahAnggota(tono);
        perpus.tambahAnggota(rey);

        // Tambah buku
        Buku b1 = new Buku("Strawberry Shortcake", "Anonim", "B001");
        b1.isTersedia(true);
        Buku b2 = new Buku("Spongeboop", "Anonim", "B002");
        b2.isTersedia(true);
        Buku b3 = new Buku("Harry Potter", "J.K. Rowling", "B003");
        b3.isTersedia(true);
        Buku b4 = new Buku("Romeo dan Julian", "Shakespeare", "B004");
        b4.isTersedia(true);
        Buku b5 = new Buku("Aku dan Bapakku Berlayar di Pantai", "Anonim", "B005");
        b5.isTersedia(true);
        Buku b6 = new Buku("Bintang di Langit", "Anonim", "B006");
        b6.isTersedia(true);
        Buku b7 = new Buku("Kimetsu no Yaiba", "Koyoharu Gotouge", "B007");
        b7.isTersedia(true);
        Buku b8 = new Buku("Silent Witch", "Matsuri Isora", "B008");
        b8.isTersedia(true);

        perpus.tambahBuku(b1);
        perpus.tambahBuku(b2);
        perpus.tambahBuku(b3);
        perpus.tambahBuku(b4);
        perpus.tambahBuku(b5);
        perpus.tambahBuku(b6);
        perpus.tambahBuku(b7);
        perpus.tambahBuku(b8);

        // Simulasi peminjaman
        LocalDate sekarang = LocalDate.now();
        TransaksiPeminjaman trx1 = perpus.pinjamBuku(luna, b1, sekarang.plusDays(7));
        TransaksiPeminjaman trx2 = perpus.pinjamBuku(luna, b2, sekarang.plusDays(7));
        TransaksiPeminjaman trx3 = perpus.pinjamBuku(dina, b3, sekarang.plusDays(7));
        TransaksiPeminjaman trx4 = perpus.pinjamBuku(budi, b4, sekarang.plusDays(7));
        TransaksiPeminjaman trx5 = perpus.pinjamBuku(tono, b5, sekarang.plusDays(7));
        TransaksiPeminjaman trx6 = perpus.pinjamBuku(tono, b6, sekarang.plusDays(7));
        TransaksiPeminjaman trx7 = perpus.pinjamBuku(rey, b7, sekarang.plusDays(7));
        TransaksiPeminjaman trx8 = perpus.pinjamBuku(rey, b8, sekarang.plusDays(7));

        System.out.println("\n=== Pengembalian Buku ===");
        // Luna telat 3 hari
        perpus.kembalkanBuku(trx1, trx1.getTanggalKembaliDiharapkan().plusDays(3));
        System.out.println("Denda Luna: " + trx1.hitungDenda());
        perpus.kembalkanBuku(trx2, trx2.getTanggalKembaliDiharapkan().plusDays(3));
        System.out.println("Denda Luna: " + trx2.hitungDenda());

        // Dina tepat waktu
        perpus.kembalkanBuku(trx3, trx3.getTanggalKembaliDiharapkan());
        System.out.println("Denda Dina: " + trx3.hitungDenda());

        // Budi telat 1 hari
        perpus.kembalkanBuku(trx4, trx4.getTanggalKembaliDiharapkan().plusDays(1));
        System.out.println("Denda Budi: " + trx4.hitungDenda());

        // Tono telat 7 hari
        perpus.kembalkanBuku(trx5, trx5.getTanggalKembaliDiharapkan().plusDays(7));
        System.out.println("Denda Tono: " + trx5.hitungDenda());
        perpus.kembalkanBuku(trx6, trx6.getTanggalKembaliDiharapkan().plusDays(7));
        System.out.println("Denda Tono: " + trx6.hitungDenda());

        // Rey telat 7 hari
        perpus.kembalkanBuku(trx7, trx7.getTanggalKembaliDiharapkan().plusDays(7));
        System.out.println("Denda Rey: " + trx7.hitungDenda());
        perpus.kembalkanBuku(trx8, trx8.getTanggalKembaliDiharapkan().plusDays(7));
        System.out.println("Denda Rey: " + trx8.hitungDenda());

        // Budi nyari buku Harry Potter
        System.out.println("\n=== Pencarian Buku oleh Budi ===");
        Buku hasilCari = perpus.cariBuku("Harry Potter");
        if (hasilCari != null) {
            System.out.println("Budi menemukan buku: " + hasilCari.getJudul() + " | Status: " + (hasilCari.getTersedia() ? "Tersedia" : "Dipinjam"));
        }
    }
}
