package minggu6.sisteminformasikampus;

public class Pelanggaran {
    private AnggotaKampus pelanggar;
    private TataTertib peraturanDilanggar;
    private String tanggal;

    public Pelanggaran(AnggotaKampus pelanggar, TataTertib peraturanDilanggar, String tanggal) {
        this.pelanggar = pelanggar;
        this.peraturanDilanggar = peraturanDilanggar;
        this.tanggal = tanggal;
    }
    
    public TataTertib getPeraturanDilanggar(){
        return peraturanDilanggar;
    }

    public AnggotaKampus getPelanggar(){
        return pelanggar;
    }
    public String getTanggal(){
        return tanggal;
    }
}
