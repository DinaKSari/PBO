package minggu1.minuman;

public class Minuman {
    private String merk;
    private double kapasitas;

    public void setMerk(String newMerk){
        merk = newMerk;
    }

    public void setKapasitas(double newVolume){
        kapasitas = kapasitas + newVolume;
    }

    public void cetakInfo(){
        System.out.println("Merk Minuman: " + merk);
        System.out.println("Kapasitas/Isi: " + kapasitas);
    }
}
