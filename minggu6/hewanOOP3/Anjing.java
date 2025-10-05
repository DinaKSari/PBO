package minggu6.hewanOOP3;
class Anjing extends Mamalia {
    String ras;
    public Anjing(String nama, int umur, String ras) {
        super(nama, umur);
        this.ras = ras;
        System.out.println("Konstruktor Anjing dipanggil");
    }
    
    void menggonggong() {
        System.out.println("Guk! Guk!");
    }
}
