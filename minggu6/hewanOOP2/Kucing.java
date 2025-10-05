package minggu6.hewanOOP2;
class Kucing extends Hewan {
    String ras;
    public Kucing(String nama, int umur, String ras) {
        super(nama, umur); // Memanggil konstruktor Hewan
        this.ras = ras;
        System.out.println("Konstruktor Kucing dipanggil");
        System.out.println("Ras kucing adalah " + this.ras);
    }
}
