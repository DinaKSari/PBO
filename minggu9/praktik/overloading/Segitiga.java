package minggu9.praktik.overloading;

public class Segitiga extends BangunDatar {
    private int sudut;
    public int getSudut() {
        return this.sudut;
    }
    public void setSudut(int sudut) {
        this.sudut = sudut;
    }
    public int totalSudut(int sudutA) {
        this.sudut = 180 - sudutA;
        System.out.println("Sisa sudut (versi 1 param): " + this.sudut);
        return this.sudut;
    }
    public int totalSudut(int sudutA, int sudutB) {
        this.sudut = 180 - (sudutA + sudutB);
        System.out.println("Sudut ketiga adalah: " + this.sudut);
        return this.sudut;
    }
    public int keliling(int sisiA, int sisiB, int sisiC) {
        int keliling = sisiA + sisiB + sisiC;
        System.out.println("Keliling segitiga (3 sisi) adalah: " + keliling);
        return keliling;
    }
    public double keliling(int sisiA, int sisiB) {
        // (a^2 + b^2 = c^2)
        double sisiMiring = Math.sqrt((sisiA * sisiA) + (sisiB * sisiB));
        System.out.println("Sisi miring (Pythagoras) adalah: " + sisiMiring);
        return sisiMiring;
    }
    @Override
    public void info() {
        System.out.println("Ini adalah sebuah Segitiga.");
    }
}