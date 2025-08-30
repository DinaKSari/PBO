package minggu1.minuman;

public class Susu extends Minuman{
    private String jenis;
    private String rasa;

    public void setJenis(String newJenis){
        jenis = newJenis;
    }

    public void setRasa(String newRasa){
        rasa = newRasa;
    }

    public void cetakInfo(){
        super.cetakInfo();
        System.out.println("Jenis Susu "+ jenis) ;
        System.out.println("Rasa: " + rasa);
    }
}
