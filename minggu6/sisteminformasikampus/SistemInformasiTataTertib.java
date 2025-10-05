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
        
    }
}
