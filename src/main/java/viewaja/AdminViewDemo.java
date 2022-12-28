/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewaja;

import java.util.Scanner;
import pojo.Admin;

/**
 *
 * @author User
 */
public class AdminViewDemo {
     public static void menuAdmin(Admin admin) {
        int menu = 0;
        boolean keluar = false;
        char pilihan;
        Scanner scanner;
     

        do {
            System.out.println("+--------------------------------------");
            System.out.println("|MAIN MENU");
            System.out.println("+--------------------------------------");
            System.out.println("Selamat datang: " + admin.getAkun().getUsername());
            System.out.println("[1] Manage Admin ");
            System.out.println("[2] Manage Barang ");
            System.out.println("[3] Manage History ");
            System.out.println("[4] Manage Pesanan ");
            System.out.println("[5] Manage Pembayaran ");    
            System.out.println("[6] Logout");
            System.out.println("---------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
            
            switch (menu) {
                case 1:
                    ManageAdminViewDemo.viewManageAdmin(admin.getId());
                break;
                case 2:
                    System.out.println("");
                    System.out.println("Apakah ingin logout? [y/n]: ");
                    scanner = new Scanner(System.in);
                    pilihan = scanner.next().charAt(0);
                    if (pilihan == 'y' || pilihan == 'Y') {
                        admin.setLoginStatus(false);
                        System.out.println("Logout!");
                        LandingPageViewDemo.landingPage();
                    }
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
        } while (admin.getLoginStatus());
        System.out.println("Terima kasih sudah menggunakan aplikasi.");
        System.exit(0);
    }
}
    
