package minggu6.sisteminformasikampus;

public class Dosen {
    private String nip;
    private String departemen;

    public Dosen(String nama, String id, String nip, String departemen) {
        this.nip = nip;
        this.departemen = departemen;
    }
    
    public String getNip(){
        return nip;
    }

    public String getDepartemen(){
        return departemen;
    }
}
