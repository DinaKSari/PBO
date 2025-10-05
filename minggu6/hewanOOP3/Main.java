package minggu6.hewanOOP3;
public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo", 2);
        kucing.berjalan(); // Catatan: Ini akan error karena metode berjalan() belum didefinisikan
        kucing.menyusui();
    }
}
