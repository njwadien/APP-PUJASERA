/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewaja;

import java.util.Scanner;
import pojo.Admin;
import service.AdminService;
import serviceImpl.AdminServiceImpl;

/**
 *
 * @author User
 */
public class RegistrasiViewDemo {
  

     public static void registrasi() {
        Scanner s = new Scanner(System.in);
        AdminService adminService = new AdminServiceImpl();
        Admin admin;
        String username, password, email,name;
        boolean registrasi = false;
    
do {
            System.out.println("+-------------------------------------------+");
            System.out.println("|REGISTRASI ADMIN                                |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| Name: ");
            name = s.nextLine();
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Email: ");
            email = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("| Re-type password: ");
            password = s.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            admin = adminService.register(username, password, email);
            if (admin != null) {
                registrasi = true;
                admin.setRegisterstatus(true);
                System.out.println("Register berhasil...!");
                System.out.println("");
                LoginViewDemo.login();
            } else {
                System.out.println("Gagal melakukan register");
            }
        } while (!registrasi);
    }
}
