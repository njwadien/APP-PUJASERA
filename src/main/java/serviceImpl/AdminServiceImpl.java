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
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Admin;
import pojo.Akun;
import service.AdminService;

/**
 *
 * @author User
 */
public class AdminServiceImpl implements AdminService {
    private ConnectionManager conMan;
    private Connection conn;
    Statement stmt;
    ResultSet rs;
    
     @Override
    public Admin register(String username, String password, String email) {
         Admin admin = null;
        Akun akun = null;
        String sql = "SELECT ad.id, ad.first_name, ad.last_name, "
                + "ak.id_akun, ak.email, ak.username "
                + "FROM admin ad, akun ak "
                + "WHERE ad.id_akun = ak.id_akun "
                + "AND ak.username = '"+username+"' "
                + "AND ak.password = '"+password+"' "
                + "AND ak.email = '"+email+"' ";
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setFirstName(rs.getString("nama_depan"));
                admin.setLastName(rs.getString("nama_belakang"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                admin.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return admin;
    }
 
    public Admin login(String username, String password) {
        Admin admin = null;
        Akun akun = null;
        String sql = "SELECT ad.id, ad.first_name, ad.last_name, "
                + "ak.id_akun, ak.email, ak.username "
                + "FROM admin ad, akun ak "
                + "WHERE ad.id_akun = ak.id_akun "
                + "AND ak.username = '"+username+"' "
                + "AND ak.password = '"+password+"'";
        
        conMan = new ConnectionManager();
        conn = conMan.connect();
        
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setFirstName(rs.getString("nama_depan"));
                admin.setLastName(rs.getString("nama_belakang"));
                akun = new Akun();
                akun.setId(rs.getInt("id_akun"));
                akun.setEmail(rs.getString("email"));
                akun.setUsername(rs.getString("username"));
                admin.setAkun(akun);
            }
            conMan.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(AdminServiceImpl.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return admin;
    }

}