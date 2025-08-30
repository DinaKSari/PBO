package minggu1.paracetamol;

public class ParacetamolDemo {
    public static void main(String[] args) {
        paracetamol pc1 = new paracetamol();
        paracetamol pc2 = new paracetamol();
        paracetamol pc3 = new paracetamol();

        pc1.setMerk("Bodrex");
        pc1.setBentuk("Kapsul");
        pc1.cetakInfo();

        pc2.setMerk("Dumin");
        pc2.setBentuk("Kapsul");
        pc2.cetakInfo();

        pc3.setMerk("Anfa");
        pc3.setBentuk("Sirup");
        pc3.cetakInfo(); 
    }
}
