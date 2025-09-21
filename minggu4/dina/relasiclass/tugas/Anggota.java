package minggu4.dina.relasiclass.tugas;
public class Anggota {
    private String idAnggota;
    private String nama;
    private TransaksiPeminjaman[] daftarPeminjaman;

    public Anggota(String idAnggota, String nama) {
        this.idAnggota = idAnggota;
        this.nama = nama;
    }

    public void setIdAnggota(String idAnggota){
        this.idAnggota =idAnggota;
    }
    public String getIdAnggota(){
        return idAnggota;
    }
    
}
