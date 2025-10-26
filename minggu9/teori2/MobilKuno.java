package minggu9.teori2;

public class MobilKuno extends Mobil {
    public MobilKuno() {
        super.setJenis("mobil tua");
    }

    @Override
    public String getJenisBahanBakar() {
        return "Pertalite";
    }
}