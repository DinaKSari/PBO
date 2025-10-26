package minggu9.teori2;

public class MobilMewah extends Mobil {
    public MobilMewah() {
        super.setJenis("Mobil mewah");
    }

    @Override
    public String getJenisBahanBakar() {
        return "Pertamax";
    }
}