/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewaja;

import java.util.Scanner;
import pojo.Admin;
import service.AkunService;
import serviceImpl.AkunServiceImpl;

/**
 *
 * @author User
 */
public class LoginViewDemo {
    public static void login() {
        Scanner s = new Scanner(System.in);
        AkunService akunService = new AkunServiceImpl();
        String username, password;
        Admin admin;
        boolean login = false;

        do {
            System.out.println("\n+-------------------------------------------+");
            System.out.println("|LOGIN                                       |");
            System.out.println("+-------------------------------------------+");
            System.out.println("| Username: ");
            username = s.nextLine();
            System.out.println("| Password: ");
            password = s.nextLine();
            System.out.println("+-------------------------------------------+");
            System.out.println();
            admin = akunService.login(username, password);
            if (admin != null) {
                login = true;
                admin.setLoginStatus(true);
                System.out.println("Login berhasil...!");
                System.out.println("");
                LandingPageViewDemo.landingPage();
            } else {
                System.out.println("Username atau password yang Anda masukkan salah, coba lagi...!");
            }
        } while (admin.getRegisterstatus());
         System.out.println("Gagal");
     }

    
}
     