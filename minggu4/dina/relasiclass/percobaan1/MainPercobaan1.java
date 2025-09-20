package minggu4.dina.relasiclass.percobaan1;
public class MainPercobaan1 {
    public static void main(String[] args) {
        // Deklarasi dan instansiasi objek Processor
        Processor p = new Processor("Intel i5", 3);

        // Deklarasi dan instansiasi objek Laptop dengan objek Processor yang sudah ada
        Laptop L = new Laptop("Thinkpad", p);
        L.info(); // Memanggil method info() dari objek Laptop

        System.out.println("--------------------"); // Pembatas untuk output

        // Contoh lain dengan setter
        Processor p1 = new Processor();
        p1.setMerk("Intel i5");
        p1.setCache(4);

        Laptop L1 = new Laptop();
        L1.setMerk("Thinkpad");
        L1.setProc(p1); // Mengatur objek Processor untuk Laptop L1
        L1.info();
    }
}
