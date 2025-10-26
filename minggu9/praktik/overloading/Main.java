package minggu9.praktik.overloading;
public class Main {
    public static void main(String[] args) {
        BangunDatar bd1 = new Segitiga();
        BangunDatar bd2 = new SegitigaSikuSiku();

        System.out.println("--- Memanggil metode info() (Polimorfisme) ---");
        bd1.info();
        bd2.info(); 

        System.out.println("\n--- Demonstrasi Overloading (Polimorfisme Statis) ---");
        Segitiga segitigaBiasa = (Segitiga) bd1;
        segitigaBiasa.totalSudut(60, 40);
        segitigaBiasa.keliling(10, 15, 20);
        segitigaBiasa.keliling(3, 4); 

        System.out.println("\n--- Demonstrasi Overriding ---");
        SegitigaSikuSiku segitigaSiku = (SegitigaSikuSiku) bd2;
        segitigaSiku.totalSudut(30); 
        segitigaSiku.totalSudut(30, 60); 

        System.out.println("\n--- Demonstrasi Encapsulation (Getter/Setter) ---");
        segitigaBiasa.setSudut(90);
        System.out.println("Nilai sudut diambil dari getter: " + segitigaBiasa.getSudut());
    }
}