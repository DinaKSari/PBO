package minggu9.praktik.overriding;
public class Main {
    public static void main(String[] args) {
        Manusia manusia1 = new Dosen("Pak Budi");
        Manusia manusia2 = new Mahasiswa("Agus");

        System.out.println(" Polymorphism & Overriding");
        
        manusia1.makan(); 
        manusia2.makan(); 

        System.out.println("\nBernapas:");
        manusia1.bernafas();
        manusia2.bernafas();

        System.out.println("\n--- Memanggil Metode Spesial");
        Dosen dosen = (Dosen) manusia1;
        dosen.lembur();
        Mahasiswa mahasiswa = (Mahasiswa) manusia2;
        mahasiswa.tidur();
    }
}
