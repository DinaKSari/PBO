package minggu4.dina.relasiclass.tugas;
public class Anggota {
    private String idAnggota;
    private String nama;

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
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getNama(){
        return nama;
    }
    
    public String info(){
        String info = "";
        info += "ID Anggota: " + idAnggota + "\n";
        info += "Nama Anggota: " + nama + "\n";
        return info;
    }
}
