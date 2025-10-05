package minggu6.hewanOOP4;
public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo", 2, "Oranye");
        Anjing anjing = new Anjing("Jes", 3, "Bulu pendek");
        anjing.info();
        anjing.berjalan();
        kucing.info();
        kucing.berjalan();

        // System.out.println(kucing.nama); // Error, 'nama' adalah private
        System.out.println(kucing.umur); // Valid, 'umur' adalah protected dan bisa diakses oleh subclass
    }
}
