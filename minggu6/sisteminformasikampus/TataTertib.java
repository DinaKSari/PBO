package minggu6.sisteminformasikampus;

public class TataTertib {
    private String peraturan;
    private String sanksi;

    public TataTertib(String peraturan, String sanksi) {
        this.peraturan = peraturan;
        this.sanksi = sanksi;
    }

    public String getPeraturan(){
        return peraturan;
    }

    public String getSanksi(){
        return sanksi;
    }

    public void terapkanSanksi(AnggotaKampus anggota){
        System.out.println("--- PENERAPAN SANKSI ---");
        System.out.println("Sanksi diterapkan kepada: " + anggota.getNama() + " (ID: " + anggota.getId() + ")");
        System.out.println("Peraturan yang dilanggar: " + this.peraturan);
        System.out.println("Sanksi yang diberikan: " + this.sanksi);
        System.out.println("--------------------------");
    }
}
