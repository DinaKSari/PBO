/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author windows
 */

import java.util.ArrayList;
import java.sql.*;

public class Peminjaman {
    private int idPeminjaman;
    private Anggota anggota = new Anggota(); // Relasi ke Anggota
    private Buku buku = new Buku();          // Relasi ke Buku
    private String tanggalPinjam;
    private String tanggalKembali;

    public Peminjaman() {
    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalPinjam, String tanggalKembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
    }

    // Getter dan Setter
    public int getIdPeminjaman() { return idPeminjaman; }
    public void setIdPeminjaman(int idPeminjaman) { this.idPeminjaman = idPeminjaman; }
    
    public Anggota getAnggota() { return anggota; }
    public void setAnggota(Anggota anggota) { this.anggota = anggota; }
    
    public Buku getBuku() { return buku; }
    public void setBuku(Buku buku) { this.buku = buku; }
    
    public String getTanggalPinjam() { return tanggalPinjam; }
    public void setTanggalPinjam(String tanggalPinjam) { this.tanggalPinjam = tanggalPinjam; }
    
    public String getTanggalKembali() { return tanggalKembali; }
    public void setTanggalKembali(String tanggalKembali) { this.tanggalKembali = tanggalKembali; }

    public Peminjaman getById(int id) {
        Peminjaman pem = new Peminjaman();
        // Query Join 3 Tabel (Peminjaman, Anggota, Buku)
        String query = "SELECT p.*, " +
                       "a.idanggota AS idanggota, a.nama AS nama_anggota, " +
                       "b.idbuku AS idbuku, b.judul AS judul_buku " +
                       "FROM peminjaman p " +
                       "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
                       "LEFT JOIN buku b ON p.idbuku = b.idbuku " +
                       "WHERE p.idpeminjaman = " + id;
        
        ResultSet rs = DBHelper.selectQuery(query);
        try {
            while (rs.next()) {
                pem = new Peminjaman();
                pem.setIdPeminjaman(rs.getInt("idpeminjaman"));
                pem.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pem.getAnggota().setNama(rs.getString("nama_anggota"));
                pem.getBuku().setIdbuku(rs.getInt("idbuku"));
                pem.getBuku().setJudul(rs.getString("judul_buku"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return pem;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        String query = "SELECT p.*, " +
                       "a.idanggota AS idanggota, a.nama AS nama_anggota, " +
                       "b.idbuku AS idbuku, b.judul AS judul_buku " +
                       "FROM peminjaman p " +
                       "LEFT JOIN anggota a ON p.idanggota = a.idanggota " +
                       "LEFT JOIN buku b ON p.idbuku = b.idbuku";
        
        ResultSet rs = DBHelper.selectQuery(query);
        try {
            while (rs.next()) {
                Peminjaman pem = new Peminjaman();
                pem.setIdPeminjaman(rs.getInt("idpeminjaman"));
                pem.getAnggota().setIdanggota(rs.getInt("idanggota"));
                pem.getAnggota().setNama(rs.getString("nama_anggota"));
                pem.getBuku().setIdbuku(rs.getInt("idbuku"));
                pem.getBuku().setJudul(rs.getString("judul_buku"));
                pem.setTanggalPinjam(rs.getString("tanggalpinjam"));
                pem.setTanggalKembali(rs.getString("tanggalkembali"));
                ListPeminjaman.add(pem);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ListPeminjaman;
    }

    public void save() {
        if (getById(idPeminjaman).getIdPeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali) VALUES("
                    + this.getAnggota().getIdanggota() + ", "
                    + this.getBuku().getIdbuku() + ", "
                    + "'" + this.tanggalPinjam + "', "
                    + "'" + this.tanggalKembali + "')";
            this.idPeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                    + "idanggota = " + this.getAnggota().getIdanggota() + ", "
                    + "idbuku = " + this.getBuku().getIdbuku() + ", "
                    + "tanggalpinjam = '" + this.tanggalPinjam + "', "
                    + "tanggalkembali = '" + this.tanggalKembali + "' "
                    + "WHERE idpeminjaman = " + this.idPeminjaman;
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = " + this.idPeminjaman;
        DBHelper.executeQuery(SQL);
    }
}
