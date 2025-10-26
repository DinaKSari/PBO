package minggu9.teori;

public class Supervisor extends Pegawai {
    public Supervisor(String nama, int gaji) {
        super(nama, gaji);
    }

    @Override
    public void naikkanGaji() {
        this.gaji = (int)(this.gaji * 1.05);
    }

    @Override
    public void cetakStatus() {
        super.cetakStatus(); 
        System.out.println("Jabatan: Supervisor");
    }
}
