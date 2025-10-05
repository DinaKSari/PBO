package minggu6.kendaraanOOP;
public class Main {
    public static void main(String[] args) {
        Mobil mobil = new Mobil("Toyota", 2022, 4);
        Motor motor = new Motor("Honda", 2023, 150);

        mobil.info();
        mobil.jalankan();

        System.out.println("------");

        motor.info();
        motor.jalankan();
    }
}
