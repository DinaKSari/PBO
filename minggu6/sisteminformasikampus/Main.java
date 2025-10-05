package minggu6.sisteminformasikampus;

public class Main {
    public static void main(String[] args) {
        SistemInformasiTataTertib sistem = new SistemInformasiTataTertib();

        System.out.println("\n--- Membuat Data Anggota Kampus ---");
        Mahasiswa mhs1 = new Mahasiswa("Budi Santoso", "MHS-001", "2141720001", "Teknik Informatika");
        Mahasiswa mhs2 = new Mahasiswa("Ani Lestari", "MHS-002", "2141720002", "Sistem Informasi");
        Dosen dsn1 = new Dosen("Dr. Indah Kurniawati", "DSN-001", "198001012005012001", "Departemen Elektro");
        System.out.println("-> Data Budi, Ani, dan Dr. Indah telah dibuat.");

        System.out.println("\n--- Membuat Data Tata Tertib ---");
        TataTertib aturanMerokok = new TataTertib("Dilarang merokok di area gedung", "Peringatan lisan dan denda Rp 50.000");
        TataTertib aturanParkir = new TataTertib("Dilarang parkir di jalur evakuasi", "Ban kendaraan akan dikempeskan");
        TataTertib aturanTugas = new TataTertib("Terlambat mengumpulkan tugas", "Pengurangan nilai sebesar 20 poin");
        System.out.println("-> Data peraturan merokok, parkir, dan tugas telah dibuat.");

        System.out.println("\n--- DEMO: Menerapkan Sanksi Langsung ---");
        aturanMerokok.terapkanSanksi(dsn1);

        System.out.println("\n--- Mencatat Pelanggaran ke Sistem ---");
        Pelanggaran p1 = new Pelanggaran(mhs1, aturanParkir, "01-10-2025");
        sistem.catatPelanggaran(p1);
        Pelanggaran p2 = new Pelanggaran(dsn1, aturanMerokok, "02-10-2025");
        sistem.catatPelanggaran(p2);

        Pelanggaran p3 = new Pelanggaran(mhs1, aturanTugas, "03-10-2025");
        sistem.catatPelanggaran(p3);

        System.out.println("\n--- Menampilkan Riwayat Pelanggaran dari Sistem ---");

        sistem.lihatRiwayatPelanggaran(mhs1);

        sistem.lihatRiwayatPelanggaran(dsn1);

        sistem.lihatRiwayatPelanggaran(mhs2);
    }
}
