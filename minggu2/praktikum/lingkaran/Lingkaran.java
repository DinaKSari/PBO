package praktikum.lingkaran;

public class Lingkaran {
    public double phi;
    public double r;

    public double hitungLuas(){
        double luas = phi * r * r;
        return luas;
    }

    public double hitungKeliling(){
        double keliling = 2 * phi * r;
        return keliling;
    }
}
