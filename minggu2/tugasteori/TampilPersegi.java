public class TampilPersegi {
    public static void main(String[] args) {
        Persegi p1 = new Persegi();
        Persegi p2 = new Persegi();
        Persegi p3 = new Persegi();

        p1.sisi = 20;
        p1.tampilkanSisi();
        p1.hitungLuas();
        p1.hitungKeliling();

        p2.sisi = 12;
        p2.tampilkanSisi();
        p2.hitungLuas();
        p2.hitungKeliling();
        
        
        p3.sisi = 5;
        p3.tampilkanSisi();
        p3.hitungLuas();
        p3.hitungKeliling();

    }
}