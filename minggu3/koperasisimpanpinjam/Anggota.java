package koperasisimpanpinjam;
public class Anggota {
    private int nomorKtp;
    private String nama;
    private int limit;
    private int pinjaman;
    public Anggota(int nomorKtp, String nama, int limit) {
        this.nomorKtp = nomorKtp;
        this.nama = nama;
        this.limit = limit;
        this.pinjaman = 0;
    }
    public String getNama(){
        return nama;
    }
    public int getLimitPinjaman(){
        return limit;
    }
    public int getJumlahPinjaman(){
        return pinjaman;
    }
    public void pinjam(int newPinjaman){
        if(newPinjaman < limit){
            pinjaman =+ newPinjaman;
        } else{
            System.out.println("Maaf jumlah pinjaman melebihi limit.");
        }
    } 
    public void angsur(int newAngsur){
        int minimalAngsuran = (int)((pinjaman*10)/100);
        if(newAngsur < minimalAngsuran){
            System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman");
        } else if(newAngsur > minimalAngsuran){
            pinjaman -= newAngsur;
        } else{
            System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman");
        }
    }
}
