package minggu9.teori;

public class Manajer extends Pegawai {
    public Manajer(String nama, int gaji) {
        super(nama, gaji);
    }

    @Override
    public void naikkanGaji() {
        this.gaji = (int)(this.gaji * 1.10); 
    }

    @Override
    public void cetakStatus() {
        super.cetakStatus(); 
        System.out.println("Jabatan: Manajer");
    }
}
