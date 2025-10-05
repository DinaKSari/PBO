package minggu6.hewanOOP2;
class Kucing extends Hewan {
    public Kucing(String nama, int umur) {
        super(nama, umur); // Memanggil konstruktor Hewan
        System.out.println("Konstruktor Kucing dipanggil");
    }
}
