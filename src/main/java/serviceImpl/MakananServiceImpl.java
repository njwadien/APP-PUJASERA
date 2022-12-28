/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceImpl;

import Utilities.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Makanan;
import service.MakananService;

/**
 *
 * @author User
 */
public class MakananServiceImpl implements MakananService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    public List<Makanan> findAll() {
        List<Makanan> listMakanan= new ArrayList<>();
        String sql = "SELECT * FROM Makanan";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Makanan makanan= new Makanan();
                makanan.setIdMakanan(rs.getInt("id_makanan"));
                makanan.setNamaMakanan(rs.getString("nama_makanan"));
                makanan.setJenisMakanan(rs.getString("jenis_makanan"));
                makanan.setHargaMakanan(rs.getDouble("harga"));
                
                
                listMakanan.add(makanan);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listMakanan;
    }

    public Integer create(Makanan object) {
        int result = 0;
        String sql = "INSERT INTO obat(nama_obat, jenis, harga) "
                + "VALUES('"+object.getNamaMakanan()+"', "
                + "'"+object.getJenisMakanan()+"', "
                + "'"+object.getHargaMakanan()+",";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Integer update(Makanan object) {
        int result = 0;
        String sql = "UPDATE obat SET nama_obat='"+object.getNamaMakanan()+"',"
                + " jenis='"+object.getJenisMakanan()+"',"
                + " harga="+object.getHargaMakanan()+","
                + " WHERE id_obat="+object.getIdMakanan()+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public Makanan findById(int id) {
        Makanan makanan = null;
        String sql = "SELECT * FROM obat WHERE id_makanan="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                makanan = new Makanan();
                makanan.setIdMakanan(rs.getInt("id_makanan"));
                makanan.setNamaMakanan(rs.getString("nama_makanan"));
                makanan.setJenisMakanan(rs.getString("jenis_makanan"));
                makanan.setHargaMakanan(rs.getDouble("harga_makanan"));
            
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return makanan;
    }

    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM obat WHERE id_obat="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
