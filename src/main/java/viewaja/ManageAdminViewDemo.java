/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewaja;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pojo.ManageAdmin;
import service.ManageAdminService;
import serviceImpl.ManageAdminServiceImpl;

/**
 *
 * @author User
 */
public class ManageAdminViewDemo {
    static List<ManageAdmin> listManageAdmin = new ArrayList<>();
    static ManageAdmin manageAdmin;
    static ManageAdminService manageAdminService;
    static Scanner scanner;
    
    public static void viewManageAdmin(){
       int menu =0;
       boolean keluar = false;
       char pilihan;
       Scanner scanner;
       
       do{
            System.out.println("+--------------------------------------");
            System.out.println("|ADMIN DASHBOARD | MANAGE ADMIN ");
            System.out.println("+--------------------------------------");
            System.out.println("1. Insert Admin");
            System.out.println("2. Update Admin");
            System.out.println("3. Delete Admin");
            System.out.println("4. Display All Admin");
            System.out.println("5. Find Admin by ID");
            System.out.println("+--------------------------------------");
            System.out.println("");
            System.out.println("Masukkan pilihan menu: ");
            scanner = new Scanner(System.in);
            menu = scanner.nextInt();
             switch (menu) {
                case 1:
                    char tampil;
                    manageAdmin = new ManageAdmin();
                    insertManageAdmin(manageAdmin); 
                    System.out.println("Apakah ingin menampilkan data? y/Y: ");
                    tampil = scanner.next().charAt(0);
                    if (tampil == 'y' || tampil == 'Y') {
                        manageAdminService= new ManageAdminServiceImpl();
                        listManageAdmin =manageAdminService.findAll();
                        findAllManageAdmin(listManageAdmin);
                    }
                break;
                case 2:
                    int updatedId;
                    ManageAdmin updatedManageAdmin = new ManageAdmin();
                    System.out.println("Masukkan ID Admin: ");
                    updatedId = scanner.nextInt();
                    updatedManageAdmin= findManageAdmin(updatedId);
                    System.out.println("Data jadwal yang akan diupdate: ");
                    if (updatedManageAdmin != null) {
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Hari\t\t: " + updatedManageAdmin.getNama();
                        System.out.println("Jam Mulai\t: " + updatedJadwalPraktek.getJamMulai());
                        System.out.println("Jam Selesai\t: " + updatedJadwalPraktek.getJamSelesai());
                        System.out.println("Dokter\t\t: " + "["+updatedJadwalPraktek.getDokter().getId()+"] " + updatedJadwalPraktek.getDokter().getNama());
                        System.out.println("Poli\t\t: " + "["+updatedJadwalPraktek.getPoli().getId()+"] " + updatedJadwalPraktek.getPoli().getNamaPoli());
                        System.out.println("-----------------------------------------------------------------");
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                    System.out.println("");
                    System.out.println("Masukkan data baru: ");
                    editJadwalPraktek(updatedJadwalPraktek.getId());
                break;
                     case 3:
                    int deletedId;
                    JadwalPraktek deletedJadwalPraktek = new JadwalPraktek();
                    char confirmation;
                    jadwalPraktekService = new JadwalPraktekServiceImpl();
                    
                    System.out.println("Masukkan ID Jadwal: ");
                    deletedId = scanner.nextInt();
                    deletedJadwalPraktek = findJadwalPraktek(deletedId);
                    System.out.println("Apakah Anda yakin untuk menghapus? y/n: ");
                    confirmation = scanner.next().charAt(0);
                    
                    if (confirmation == 'y' || confirmation == 'Y') {
                        if (deletedJadwalPraktek != null) {
                            jadwalPraktekService.delete(deletedId);
                            System.out.println("Data berhasil dihapus...!");
                            System.out.println("");
                        } else {
                            System.out.println("Data tidak ditemukan!");
                        }
                    }
                break;
                case 4:
                    jadwalPraktekService = new JadwalPraktekServiceImpl();
                    listJadwalPraktek = jadwalPraktekService.findAll();
                    findAllJadwalPraktek(listJadwalPraktek);
                break;
                case 5:
                    int searchedId;
                    JadwalPraktek searchedJadwalPraktek = new JadwalPraktek();
                    System.out.println("Masukkan ID: ");
                    searchedId = scanner.nextInt();
                    searchedJadwalPraktek = findJadwalPraktek(searchedId);
                    if (searchedJadwalPraktek != null) {
                        System.out.println("-----------------------------------------------------------------");
                        System.out.println("Hari\t\t: " + searchedJadwalPraktek.getHari());
                        System.out.println("Jam Mulai\t: " + searchedJadwalPraktek.getJamMulai());
                        System.out.println("Jam Selesai\t: " + searchedJadwalPraktek.getJamSelesai());
                        System.out.println("Dokter\t\t: " + "["+searchedJadwalPraktek.getDokter().getId()+"] " + searchedJadwalPraktek.getDokter().getNama());
                        System.out.println("Poli\t\t: " + "["+searchedJadwalPraktek.getPoli().getId()+"] " + searchedJadwalPraktek.getPoli().getNamaPoli());
                        System.out.println("-----------------------------------------------------------------");
                    } else {
                        System.out.println("Data tidak ditemukan!");
                    }
                break;
                default:
                    System.out.println("Pilihan yang Anda masukkan salah!");
                break;
            }
            System.out.println("");
            System.out.println("Apakah ingin melanjutkan? y/n: ");
            scanner = new Scanner(System.in);
            pilihan = scanner.next().charAt(0);
            if (pilihan == 'n' || pilihan == 'N') {
                keluar = true;
            }
            
        } while (!keluar);
        System.out.println("Kembali ke menu utama!");
    }

    private static void findAllManageAdmin(List<ManageAdmin> listManageAdmin) {
        for (JadwalPraktek jadwalPraktek : listJadwalPraktek) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Hari\t\t: " + jadwalPraktek.getHari());
            System.out.println("Jam Mulai\t: " + jadwalPraktek.getJamMulai());
            System.out.println("Jam Selesai\t: " + jadwalPraktek.getJamSelesai());
            System.out.println("Dokter\t\t: " + jadwalPraktek.getDokter().getNama());
            System.out.println("Poli\t\t: " + jadwalPraktek.getPoli().getNamaPoli());
            System.out.println("-----------------------------------------------------------------");
            System.out.println("");
        }
    }

    private static void insertManageAdmin(ManageAdmin manageAdmin) {
        scanner = new Scanner(System.in);
        jadwalPraktekService = new JadwalPraktekServiceImpl();
        String hari, jamMulai, jamSelesai;
        int id_dokter, id_poli;
        
        System.out.println("Hari: ");
        hari = scanner.nextLine();
        System.out.println("Jam Mulai [HH:mm:ss]: ");
        jamMulai = scanner.nextLine();
        System.out.println("Jam Selesai [HH:mm:ss]: ");
        jamSelesai = scanner.nextLine();
        System.out.println("Dokter: ");
        id_dokter = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Poli: ");
        id_poli = scanner.nextInt();
        scanner.nextLine();
        
        jadwalPraktek.setHari(hari);
        jadwalPraktek.setJamMulai(jamMulai);
        jadwalPraktek.setJamSelesai(jamSelesai);
        
        Dokter dokter = new Dokter();
        dokter.setId(id_dokter);
        
        Poli poli = new Poli();
        poli.setId(id_poli);
        
        jadwalPraktek.setDokter(dokter);
        jadwalPraktek.setPoli(poli);
        
        jadwalPraktekService.create(jadwalPraktek);
        System.out.println("Data berhasil disimpan...!");
        System.out.println("");
    }
    
    private static JadwalPraktek findManageAdmin(int updatedId) {
        jadwalPraktek = new JadwalPraktek();
        jadwalPraktekService = new JadwalPraktekServiceImpl();
        jadwalPraktek = jadwalPraktekService.findById(updatedId);
    
        return jadwalPraktek;
    }
    
    private static void editManageAsmin(Integer id) {
        scanner = new Scanner(System.in);
        jadwalPraktekService = new JadwalPraktekServiceImpl();
        jadwalPraktek = new JadwalPraktek();
        String hari, jamMulai, jamSelesai;
        int id_dokter, id_poli;
        
        System.out.println("Hari: ");
        hari = scanner.nextLine();
        System.out.println("Jam Mulai [HH:mm:ss]: ");
        jamMulai = scanner.nextLine();
        System.out.println("Jam Selesai [HH:mm:ss]: ");
        jamSelesai = scanner.nextLine();
        System.out.println("Dokter: ");
        id_dokter = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Poli: ");
        id_poli = scanner.nextInt();
        scanner.nextLine();
        
        jadwalPraktek.setId(id);
        jadwalPraktek.setHari(hari);
        jadwalPraktek.setJamMulai(jamMulai);
        jadwalPraktek.setJamSelesai(jamSelesai);
        
        Dokter dokter = new Dokter();
        dokter.setId(id_dokter);
        
        Poli poli = new Poli();
        poli.setId(id_poli);
        
        jadwalPraktek.setDokter(dokter);
        jadwalPraktek.setPoli(poli);
        
        jadwalPraktekService.update(jadwalPraktek);
        System.out.println("Data berhasil diperbarui...!");
        System.out.println("");
    }
    
    
}
      