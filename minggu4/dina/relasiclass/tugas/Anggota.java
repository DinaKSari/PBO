package minggu4.dina.relasiclass.tugas;
public class Anggota {
    private String idAnggota;
    private String nama;
    private TransaksiPeminjaman daftarPeminjaman[];
    private int jumlahPeminjaman;

    public Anggota(String idAnggota, String nama, int kapasitaPinjam) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.daftarPeminjaman = new TransaksiPeminjaman[kapasitaPinjam];
        this.jumlahPeminjaman = 0;
    }

    public void setIdAnggota(String idAnggota){
        this.idAnggota =idAnggota;
    }
    public String getIdAnggota(){
        return idAnggota;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }

    public void tambahPeminjaman(TransaksiPeminjaman transaksiPeminjaman){

    }
    
    public String info(){
        String info = "";
        info += "ID Anggota: " + idAnggota + "\n";
        info += "Nama Anggota: " + nama + "\n";
        return info;
    }
}
