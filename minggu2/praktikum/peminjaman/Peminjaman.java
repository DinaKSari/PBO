package praktikum.peminjaman;

public class Peminjaman {
    public int id;
    public String namaMember;
    public String namaGame;
    public double harga;

    public void tampilkanData(){
        System.out.println("id peminjaman: " + id);
        System.out.println("nama member: " + namaMember);
        System.out.println("nama game: " + namaGame);
        System.out.println("harga game: " + harga);
    }

    public double menghitungHarga(double lamaSewa){
        double totalHarga = lamaSewa * harga;
        return totalHarga;
    }
}
