package minggu11;

public class TestPegawai {
    public static void main(String[] args) {

        // Membuat objek Manajer
        Pegawai manajer = new Manajer("Joko", 8000000, 1500000);
        
        // Membuat objek Programmer
        Pegawai programmer = new Programmer("Budi", 10000000, 2000000);

        System.out.println("Data Manajer:");
        System.out.println("Nama: " + manajer.getNama());
        // Memanggil getGaji() milik Manajer
        System.out.println("Gaji Total: " + manajer.getGaji()); 
        System.out.println("--------------------");

        System.out.println("Data Programmer:");
        System.out.println("Nama: " + programmer.getNama());
        // Memanggil getGaji() milik Programmer
        System.out.println("Gaji Total: " + programmer.getGaji()); 
    }
}