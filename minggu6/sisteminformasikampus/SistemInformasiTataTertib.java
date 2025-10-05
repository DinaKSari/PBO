package minggu6.sisteminformasikampus;

public class SistemInformasiTataTertib {
    private Pelanggaran daftarPelanggaran[];
    private int jumlahPelanggaran;

    public SistemInformasiTataTertib(Pelanggaran[] daftarPelanggaran, int jumlahPelanggaran) {
        daftarPelanggaran = new Pelanggaran[100];
        jumlahPelanggaran = 0;
    }

    
    public void cataPelanggaran(Pelanggaran pelanggaran){
        if (jumlahPelanggaran < daftarPelanggaran.length){
            daftarPelanggaran[jumlahPelanggaran] = pelanggaran;
            jumlahPelanggaran++;
        } else {
            System.out.println("Gagal mencatat! Penyimpanan data pelanggaran sudah penuh.");
        }
    }

    public void lihatRiwayatPelanggaran(AnggotaKampus anggota){
        for (int i = 0; i < jumlahPelanggaran; i++) {
            Pelanggaran p = daftarPelanggaran[i];
            System.out.println("Data ke-" + (i + 1) + ":");
            System.out.println("Nama Pelanggar : " + p.getPelanggar().getNama());
            System.out.println("ID Pelanggar   : " + p.getPelanggar().getId());
            System.out.println("Tanggal        : " + p.getTanggal());
            System.out.println("Peraturan      : " + p.getPeraturanDilanggar().getPeraturan());
            System.out.println("Sanksi         : " + p.getPeraturanDilanggar().getSanksi());
        }
    }
}
