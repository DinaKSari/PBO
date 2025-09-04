public class Persegi {
    int sisi;

    public void tampilkanSisi(){
        System.out.println("Panjang sisi persegi: " + sisi);
    }

    public void hitungLuas(){
        int luas = sisi * sisi;
        System.out.println("Luas persegi: " + luas);
    }

    public void hitungKeliling(){
        int keliling = 4 * sisi;
        System.out.println("Keliling persegi: " + keliling);
    }
}
