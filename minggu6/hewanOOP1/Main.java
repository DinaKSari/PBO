package minggu6.hewanOOP1;
public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Milo");
        kucing.bersuara(); // Output: Meong! (karena metode di-override)
        kucing.mengeong();
    }
}
