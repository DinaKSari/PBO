package minggu9.teori2;

public class TestSpbu {
    public static void main(String[] args) {
        MobilMewah alphard = new MobilMewah();
        MobilKuno carry = new MobilKuno();

        Spbu gs = new Spbu();

        gs.isiBahanBakar(carry, 20000);

        gs.isiBahanBakar(alphard, 20000);
    }
}
