package minggu6.hewanOOP1;
class Anjing extends Hewan {
    public Anjing(String nama) {
        super(nama);
    }
    
    @Override
    void bersuara() {
        System.out.println("Guk!"); // Meng-override metode bersuara() dari Hewan
    }

    void menggonggong() {
        System.out.println("Guk...Guuk!");
    }
}
