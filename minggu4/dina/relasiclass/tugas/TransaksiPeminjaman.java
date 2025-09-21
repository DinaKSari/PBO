package minggu4.dina.relasiclass.tugas;
import java.time.LocalDate;
public class TransaksiPeminjaman {
    private String idTransaksi;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembaliDiharapkan;
    private LocalDate tanggalKembaliAsli;
    private Anggota anggota;
    private Buku buku;

    public TransaksiPeminjaman(String idTransaksi, LocalDate tanggalPinjam, LocalDate tanggalKembaliDiharapkan, Anggota anggota, Buku buku) {
        this.idTransaksi = idTransaksi;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembaliDiharapkan = tanggalKembaliDiharapkan;
        this.anggota = anggota;
        this.buku = buku;
    }
    public String getIdTransaksi(){
        return idTransaksi;
    }
    public LocalDate getTanggalPinjam(){
        return tanggalPinjam;
    }
    public LocalDate getTanggalKembaliDiharapkan(){
        return tanggalKembaliDiharapkan;
    }
    public LocalDate getTanggalKembaliAsli(){
        return tanggalKembaliAsli;
    }
    public Anggota getAnggota(){
        return anggota;
    }
    public Buku getBuku(){
        
    }

}
