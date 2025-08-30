package minggu1.lipcream;

public class LipCreamDemo {
    public static void main(String[] args) {
        LipCream lp1 = new LipCream();
        LipCream lp2 = new LipCream();

        lp1.setMerk("Pink flash");
        lp1.setWarna("Rose");
        lp1.cetakInfo();

        lp2.setMerk("Hanasui");
        lp2.setWarna("Vanila");
        lp2.cetakInfo();
    }
}
