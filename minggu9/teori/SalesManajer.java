package minggu9.teori;

public class SalesManajer extends Manajer {
    private String departemen;
    public SalesManajer(String nama, String departemen, int gaji) {
        super(nama, gaji); 
        this.departemen = departemen;
    }

    @Override
    public void cetakStatus() {
        super.cetakStatus(); 
        
        // Tambahkan informasi baru
        System.out.println("Departemen: " + this.departemen);
    }
}
