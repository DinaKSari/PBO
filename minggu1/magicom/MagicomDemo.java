package minggu1.magicom;

public class MagicomDemo {
    public static void main(String[] args) {
        Magicom mc1 = new Magicom();
        Magicom mc2 = new Magicom();

        mc1.setMerk("Miyako");
        mc1.tambahKapasitas(1);
        mc1.cetakInfo();

        mc2.setMerk("Cosmos");
        mc2.tambahKapasitas(2);
        mc2.cetakInfo();
    }
}
