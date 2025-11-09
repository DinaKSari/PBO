package minggu11;

public class Bayaran {
    
    public int hitungBayaran(Pegawai pg) {
        // Ambil gaji pokok
        int uang = pg.getGaji(); 

        // Cek apakah pg sebenarnya adalah Manajer
        if (pg instanceof Manajer) {
            // Casting pg ke Manajer untuk bisa memanggil .getTunjangan()
            uang += ((Manajer)pg).getTunjangan();
        } 
        // Cek apakah pg sebenarnya adalah Programmer
        else if (pg instanceof Programmer) {
            // Casting pg ke Programmer untuk bisa memanggil .getBonus()
            uang += ((Programmer)pg).getBonus();
        }

        return uang;
    }
}