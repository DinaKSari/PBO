package minggu1.minuman;

public class MinumanDemo {
    public static void main(String[] args) {
         Minuman mn1 = new Minuman();
         AirMineral mr1 = new AirMineral();
         Susu ss = new Susu();

         mn1.setMerk("Ichitan");
         mn1.setKapasitas(1.5);
         mn1.cetakInfo();

         mr1.setMerk("Aqua");
         mr1.setKapasitas(1.2);
         mr1.setTipe("Mineral Murni");
         mr1.setKemasan("Botol");
         mr1.cetakInfo();

         ss.setMerk("Oatside");
         ss.setKapasitas(0.6);
         ss.setJenis("Gandum");
         ss.setRasa("Original");
         ss.cetakInfo();
    }
}
