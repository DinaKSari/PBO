package minggu1.paracetamol;

public class paracetamol {
    private String merk;
    private String bentuk;

    public void setMerk(String newMerk){
        merk = newMerk;
    }

    public void setBentuk(String newBentuk){
        bentuk = newBentuk;
    }

    public void cetakInfo(){
        System.out.println("Merk: " + merk);
        System.out.println("Bentuk: " + bentuk);
    }
}
