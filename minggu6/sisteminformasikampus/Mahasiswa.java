package minggu6.sisteminformasikampus;

public class Mahasiswa {
    private String nim;
    private String programStudi;

    public Mahasiswa(String nama, String id, String nim, String programStudi) {
        this.nim = nim;
        this.programStudi = programStudi;
    }
    
    public String getNim(){
        return nim;
    }

    public String getProgramStudi(){
        return programStudi;
    }
}
