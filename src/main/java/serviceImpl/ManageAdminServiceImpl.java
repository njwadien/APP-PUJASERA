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
import pojo.Admin;
import pojo.ManageAdmin;
import service.ManageAdminService;

/**
 *
 * @author User
 */
public class ManageAdminServiceImpl implements ManageAdminService{
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;

    @Override
    public List<ManageAdmin> findAll() {
        List<ManageAdmin> listManageAdmin = new ArrayList<>();
        ManageAdmin manageAdmin = null;
        Admin admin = null;
       // String sql = "SELECT jp.id_jadwal, jp.hari, jp.jam_mulai, "
       //         + "jp.jam_selesai, d.id, d.nama, p.id_poli, p.nama_poli "
         //       + "FROM jadwal_praktek jp, dokter d, poli p "
           //     + "WHERE jp.id_dokter=d.id AND jp.id_poli=p.id_poli";
        String sql = "SELECT ma.id, ma.nama, ma.umur, "
                + "ma.jenis_kelamin,  ";
        
         conMan = new ConnectionManager();
        conn = conMan.connect();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {                
                manageAdmin = new ManageAdmin();
                
                manageAdmin.setId(rs.getInt("id"));
                manageAdmin.setNama(rs.getString("nama"));
                manageAdmin.setUmur(rs.getInt("umur"));
                manageAdmin.setJenis_kelamin(rs.getString("jenis_kelamin"));
                manageAdmin.setNo_handphone(rs.getInt("no_hp"));
                manageAdmin.setAlamat(rs.getString("alamat"));
                
                admin = new Admin();
                admin.setFirstName(rs.getString("first_name"));
                admin.setLastName(rs.getString("last_name"));
                
                manageAdmin.setAdmin(admin);
                
                listManageAdmin.add(manageAdmin);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ManageAdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
        return listManageAdmin;    
    }

    @Override
    public Integer create(ManageAdmin object) {
        int result = 0;
        String sql = "INSERT INTO manage_admin(nama, umur,jenis_kelamin, first_name, last_name)"
                +"VALUES('"+object.getNama()+"', "
                +"'"+object.getUmur()+"', "
                +"'"+object.getJenis_kelamin()+"',"
                +"'"+object.getAdmin().getFirstName()+"',"
                +"'"+object.getAdmin().getLastName()+"),";
        
          conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return result;
        
    }

    @Override
    public Integer update(ManageAdmin object) {
        int result = 0;
        String sql = "UPDATE manage_admin SET nama='"+object.getNama()+"',"
                +"umur='"+object.getUmur()+"', "
                +"jenis_kelamin='"+object.getJenis_kelamin()+"', "
                +"no_hp='"+object.getNo_handphone()+"', "
                +"alamat='"+object.getAlamat()+"', "
                +"WHERE id_admin="+object.getId()+"";
         conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ManageAdminServiceImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return result;           
    }
    @Override
    public ManageAdmin findById(int id) {
        ManageAdmin manageAdmin = null;
        Admin admin = null;
        
       // String sql = "SELECT ma. "//
        return manageAdmin;
        
    }

    @Override
    public Integer delete(int id) {
       int result = 0;
        String sql = "DELETE FROM jadwal_praktek WHERE id_admin="+id+"";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(ManageAdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
       return result;
    }
}

   