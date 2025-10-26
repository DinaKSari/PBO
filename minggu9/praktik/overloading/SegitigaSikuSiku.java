package minggu9.praktik.overloading;

public class SegitigaSikuSiku extends Segitiga {
    @Override
    public void info() {
        System.out.println("Ini adalah Segitiga SIKU-SIKU.");
    }
    @Override
    public int totalSudut(int sudutA) {
        int sudutPasti = 90;
        int sisaSudut = 180 - sudutPasti - sudutA;
        setSudut(sisaSudut); 
        
        System.out.println("Sudut sisa (versi Siku-Siku): " + sisaSudut);
        return sisaSudut;
    }
}
