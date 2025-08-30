package minggu1.magicom;

public class Magicom {
    private String merk;
    private int kapasitas;

    public void cetakInfo(){
        System.out.println("Merk : " + merk);
        System.out.println("Kapasitas: " + kapasitas);
    }

    public void setMerk(String newMerk){
        merk = newMerk;
    }

    public void tambahKapasitas(int increment){
        kapasitas = kapasitas + increment;
    }
}
