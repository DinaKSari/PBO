package minggu1.minuman;

public class AirMineral extends Minuman{
    private String tipe;
    private String kemasan;

    public void setTipe(String newTipe){
        tipe = newTipe;
    }

    public void setKemasan(String newKemasan){
        kemasan = newKemasan;
    }

    public void cetakInfo(){
        super.cetakInfo();
        System.out.println("Tipe mineral (mineral murni/demineral): " + tipe);
        System.out.println("Bentuk wadah: " + kemasan);
    }

}
