package minggu4.dina.relasiclass.tugas;
import java.time.LocalDate;
import java.util.Arrays;
public class Perpustakaan {
    private String nama;
    private Buku daftarBuku[];
    private Anggota daftarAnggota[];
    private TransaksiPeminjaman daftarTransaksi[];

    private int jumlahBuku;
    private int jumlahAnggota;
    private int jumlahTransaksi;

    public Perpustakaan(String nama) {
        this.nama = nama;
        this.daftarBuku = new Buku[100];
        this.daftarAnggota = new Anggota[100];
        this.daftarTransaksi = new TransaksiPeminjaman[100];
        this.jumlahBuku = 0;
        this.jumlahAnggota = 0;
        this.jumlahTransaksi = 0;
    }
    public String getNama(){
        return nama;
    }
    public void tambahBuku(Buku buku){
        if (buku == null) {
            System.out.println("Gagal menambahkan buku. Objek buku tidak boleh null.");
            return;
        }
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIsbn().equals(buku.getIsbn())) {
                System.out.println("Buku dengan ISBN " + buku.getIsbn() + " sudah ada di perpustakaan.");
                return;
            }
        }
        if (jumlahBuku == daftarBuku.length) {
            System.out.println("Penyimpanan Penuh (>_<)");
        }
        daftarBuku[jumlahBuku] = buku;
        jumlahBuku++;
        System.out.println("Buku '" + buku.getJudul() + "' berhasil ditambahkan.");
    }
    public void hapusBuku(String isbn){
        if (isbn == null || isbn.isEmpty()) {
            System.out.println("Gagal menghapus buku. ISBN tidak boleh kosong.");
            return;
        }
        int indexDitemukan = -1;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getIsbn().equals(isbn)) {
                indexDitemukan = i;
                break;
            }
        }
        if (indexDitemukan != -1) {
            for (int i = indexDitemukan; i < jumlahBuku - 1; i++) {
                daftarBuku[i] = daftarBuku[i + 1];
            }
            daftarBuku[jumlahBuku - 1] = null;
            jumlahBuku--;
            System.out.println("Buku dengan ISBN " + isbn + " berhasil dihapus.");
        } else {
            System.out.println("Buku dengan ISBN " + isbn + " tidak ditemukan.");
        }
    }
    public void tambahAnggota(Anggota anggota){
        if (anggota == null) {
            System.out.println("Gagal menambahkan anggota. Objek anggota tidak boleh null.");
            return;
        }
        
        for (int i = 0; i < jumlahAnggota; i++) {
            if (daftarAnggota[i].getIdAnggota().equals(anggota.getIdAnggota())) {
                System.out.println("Anggota dengan ID " + anggota.getIdAnggota() + " sudah terdaftar.");
                return;
            }
        }
        if (jumlahAnggota == daftarAnggota.length) {
            daftarAnggota = Arrays.copyOf(daftarAnggota, daftarAnggota.length * 2);
        }
        daftarAnggota[jumlahAnggota] = anggota;
        jumlahAnggota++;
        System.out.println("Anggota '" + anggota.getNama() + "' berhasil ditambahkan.");
    }
    public void hapusAnggota(String idAnggota){
        if (idAnggota == null || idAnggota.isEmpty()) {
            System.out.println("Gagal menghapus anggota. ID Anggota tidak boleh kosong.");
            return;
        }
        int indexDitemukan = -1;
        for (int i = 0; i < jumlahAnggota; i++) {
            if (daftarAnggota[i].getIdAnggota().equals(idAnggota)) {
                indexDitemukan = i;
                break;
            }
        }

        if (indexDitemukan != -1) {
            for (int i = indexDitemukan; i < jumlahAnggota - 1; i++) {
                daftarAnggota[i] = daftarAnggota[i + 1];
            }
            daftarAnggota[jumlahAnggota - 1] = null;
            jumlahAnggota--;
            System.out.println("Anggota dengan ID " + idAnggota + " berhasil dihapus.");
        } else {
            System.out.println("Anggota dengan ID " + idAnggota + " tidak ditemukan.");
        }
    }
    public TransaksiPeminjaman pinjamBuku(Anggota anggota, Buku buku, LocalDate tanggalKembaliDiharapkan){
        if (anggota == null || buku == null) {
            System.out.println("Gagal peminjaman. Anggota atau Buku tidak boleh null.");
            return null;
        }
        if (!buku.getTersedia()) {
            System.out.println("Gagal peminjaman. Buku '" + buku.getJudul() + "' sedang tidak tersedia.");
            return null;
        }
        boolean anggotaTerdaftar = false;
        for (int i = 0; i < jumlahAnggota; i++) {
            if (daftarAnggota[i].equals(anggota)) {
                anggotaTerdaftar = true;
                break;
            }
        }
        if (!anggotaTerdaftar) {
            System.out.println("Gagal peminjaman. Anggota '" + anggota.getNama() + "' belum terdaftar di perpustakaan.");
            return null;
        }
        boolean bukuTersediaDiPerpus = false;
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].equals(buku)) {
                bukuTersediaDiPerpus = true;
                break;
            }
        }
        if (!bukuTersediaDiPerpus) {
            System.out.println("Gagal peminjaman. Buku '" + buku.getJudul() + "' tidak ditemukan di perpustakaan.");
            return null;
        }
        String idTransaksi = "TRX" + (jumlahTransaksi + 1);
        TransaksiPeminjaman newTransaksi = new TransaksiPeminjaman(idTransaksi, LocalDate.now(), tanggalKembaliDiharapkan, anggota, buku);

        if (jumlahTransaksi == daftarTransaksi.length) {
            daftarTransaksi = Arrays.copyOf(daftarTransaksi, daftarTransaksi.length * 2);
        }
        daftarTransaksi[jumlahTransaksi] = newTransaksi;
        jumlahTransaksi++;

        buku.isTersedia(false);
        anggota.tambahPeminjaman(newTransaksi);
        
        System.out.println("Peminjaman buku '" + buku.getJudul() + "' oleh '" + anggota.getNama() + "' berhasil. ID Transaksi: " + idTransaksi);
        return newTransaksi;
    }
    public void kembalkanBuku(TransaksiPeminjaman transaksi, LocalDate tanggalKembaliAsli){
        if (transaksi == null) {
            System.out.println("Gagal pengembalian. Objek transaksi tidak boleh null.");
            return;
        }

        int indexDitemukan = -1;
        for (int i = 0; i < jumlahTransaksi; i++) {
            if (daftarTransaksi[i].equals(transaksi)) {
                indexDitemukan = i;
                break;
            }
        }

        if (indexDitemukan != -1) {
            daftarTransaksi[indexDitemukan].setTanggalKembaliAsli(tanggalKembaliAsli);
            daftarTransaksi[indexDitemukan].getBuku().isTersedia(true);
            daftarTransaksi[indexDitemukan].getAnggota().hapusPeminjaman(daftarTransaksi[indexDitemukan]);
            for (int i = indexDitemukan; i < jumlahTransaksi - 1; i++) {
                daftarTransaksi[i] = daftarTransaksi[i + 1];
            }
            daftarTransaksi[jumlahTransaksi - 1] = null;
            jumlahTransaksi--;

            System.out.println("Pengembalian buku '" + transaksi.getBuku().getJudul() + "' oleh '" + transaksi.getAnggota().getNama() + "' berhasil. ID Transaksi: " + transaksi.getIdTransaksi());
        } else {
            System.out.println("Gagal pengembalian. Transaksi dengan ID " + transaksi.getIdTransaksi() + " tidak ditemukan.");
        }
    }

    public Buku cariBuku(String judul){
        if (judul == null || judul.isEmpty()) {
            System.out.println("Judul buku tidak boleh kosong.");
            return null;
        }
        for (int i = 0; i < jumlahBuku; i++) {
            if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
                return daftarBuku[i];
            }
        }
        System.out.println("Buku dengan judul '" + judul + "' tidak ditemukan.");
        return null;
    }

    public String info(){
        String info = "";
        info += "Nama: " + nama + "\n";
        info += "Daftar Buku: " + daftarBuku + "\n";
        info += "Daftar Anggota: " + daftarAnggota + "\n";
        info += "Daftar Transaksi: " + daftarTransaksi + "\n";
        return info;
    }
    
}
