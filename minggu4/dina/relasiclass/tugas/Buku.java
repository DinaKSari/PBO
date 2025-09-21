package minggu4.dina.relasiclass.tugas;
public class Buku {
    private String judul;
    private String penulis;
    private String isbn;
    private boolean tersedia;

    public Buku(String judul, String penulis, String isbn) {
        this.judul = judul;
        this.penulis = penulis;
        this.isbn = isbn;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }

    public String getJudul(){
        return judul;
    }
    public void setPenulis(String penulis){
        this.penulis = penulis;
    }
    public String getPenulis(){
        return penulis;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getIsbn(){
        return isbn;
    }
    public void isTersedia(boolean tersedia){
        this.tersedia = tersedia;
    }
    public boolean getTersedia(){
        return tersedia;
    }
    public String info(){
        String info = "";
        info += "Judul: " + judul + "\n";
        info += "Penulis: " + penulis + "\n";
        info += "Isbn: " + isbn + "\n";
        info += "Kesediaan: " + tersedia + "\n";
        return info;
    }
}
