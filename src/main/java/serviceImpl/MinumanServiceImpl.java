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
import pojo.Minuman;
import service.MinumanService;

/**
 *
 * @author User
 */
public class MinumanServiceImpl implements MinumanService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
    public List<Minuman> findAll() {
        List<Minuman> listMakanan= new ArrayList<>();
        String sql = "SELECT * FROM Minuman";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                Minuman minuman = new Minuman();
                minuman .setIdMinuman(rs.getInt("id_minuman"));
                minuman .setNamaMinuman(rs.getString("nama_minuman"));
                minuman .setJenisMinuman(rs.getString("jenis_minuman"));
                minuman .setHargaMinuman(rs.getDouble("harga_minuman"));
                
                
                listMakanan.add(minuman);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listMakanan;
    }

    public Integer create(Minuman object) {
        int result = 0;
        String sql = "INSERT INTO obat(nama_obat, jenis, harga) "
                + "VALUES('"+object.getNamaMinuman()+"', "
                + "'"+object.getJenisMinuman()+"', "
                + "'"+object.getHargaMinuman()+",";
        
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

    public Integer update(Minuman object) {
        int result = 0;
        String sql = "UPDATE obat SET nama_minuman'"+object.getNamaMinuman()+"',"
                + " jenis='"+object.getJenisMinuman()+"',"
                + " harga="+object.getHargaMinuman()+","
                + " WHERE id_obat="+object.getIdMinuman()+"";
        
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

    public Minuman findById(int id) {
        Minuman minuman = null;
        String sql = "SELECT * FROM obat WHERE id_minuman="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                minuman =  new Minuman();
                minuman .setIdMinuman(rs.getInt("id_minuman"));
                minuman .setNamaMinuman(rs.getString("nama_minuman"));
                minuman .setJenisMinuman(rs.getString("jenis_minuman"));
                minuman .setHargaMinuman(rs.getDouble("harga_minuman"));
       
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(MakananServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return minuman;
    }

    public Integer delete(int id) {
        int result = 0;
        String sql = "DELETE FROM obat WHERE id_minuman="+id+"";
        
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