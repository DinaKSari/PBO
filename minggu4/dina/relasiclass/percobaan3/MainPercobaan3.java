package minggu4.dina.relasiclass.percobaan3;
public class MainPercobaan3 {
    public static void main(String[] args) {
        Pegawai masinis = new Pegawai("1234", "Spongebob Squarepants");
        Pegawai asisten = new Pegawai("4567", "Patrick Star");

        KeretaApi keretaApi1 = new KeretaApi("Gaya Baru", "Bisnis", masinis, asisten);
        System.out.println(keretaApi1.info());

        // Contoh membuat objek KeretaApi tanpa asisten (menggunakan constructor 3 parameter)
        Pegawai masinis2 = new Pegawai("8901", "Dora The Explorer");
        KeretaApi keretaApi2 = new KeretaApi("Malabar", "Eksekutif", masinis2);
        System.out.println(keretaApi2.info());
    }
}
