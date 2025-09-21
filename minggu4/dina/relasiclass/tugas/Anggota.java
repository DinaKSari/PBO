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
        if (jumlahPeminjaman < daftarPeminjaman.length) {
            this.daftarPeminjaman[jumlahPeminjaman] = transaksiPeminjaman;
            this.jumlahPeminjaman++;
        } else {
            System.out.println("Gagal menambahkan transaksi. Daftar peminjaman " + this.nama + " sudah penuh.");
        }
    }

    public void hapusPeminjaman(TransaksiPeminjaman transaksi){
        int indeksDitemukan = -1;
        for (int i = 0; i < jumlahPeminjaman; i++) { 
            if (this.daftarPeminjaman[i] != null && this.daftarPeminjaman[i].equals(transaksi)) {
                indeksDitemukan = i;
                break;
            }
        }
        if (indeksDitemukan != -1) {
            for (int i = indeksDitemukan; i < jumlahPeminjaman - 1; i++) {
                this.daftarPeminjaman[i] = this.daftarPeminjaman[i + 1];
            }
            this.daftarPeminjaman[jumlahPeminjaman - 1] = null;
            this.jumlahPeminjaman--;
        }
    }
    
    public String info(){
        String info = "";
        info += "ID Anggota: " + idAnggota + "\n";
        info += "Nama Anggota: " + nama + "\n";
        return info;
    }
}
