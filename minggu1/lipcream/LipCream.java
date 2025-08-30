package minggu1.lipcream;

public class LipCream {
    private String merk;
    private String warna;

    public void setMerk(String newMerk){
        merk = newMerk;
    }

    public void setWarna(String newWarna){
        warna = newWarna;
    }

    public void cetakInfo(){
        System.out.println("Merk Lip Cream: " + merk);
        System.out.println("Warna: " + warna);
    }
}
