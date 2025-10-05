package minggu6.sisteminformasikampus;

public class AnggotaKampus {
    private String nama;
    private String id;

    public AnggotaKampus(String nama, String id) {
        this.nama = nama;
        this.id = id;
    }
    
    public String getNama(){
        return nama;
    }

    public String getId(){
        return id;
    }
}
