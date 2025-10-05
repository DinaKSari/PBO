package minggu6.kendaraanOOP;
class Truk extends Kendaraan {
    double kapasitasMuatan;

    public Truk(String merk, int tahunProduksi, double kapasitasMuatan) {
        super(merk, tahunProduksi);
        this.kapasitasMuatan = kapasitasMuatan;
    }

    @Override
    void jalankan() {
        System.out.println("Truk " + merk + " berjalan dengan muatan berat...");
    }

    @Override
    void info() {
        super.info();
        System.out.println("Kapasitas Muatan: " + kapasitasMuatan + " ton");
    }
}
