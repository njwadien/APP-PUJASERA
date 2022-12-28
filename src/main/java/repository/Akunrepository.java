/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

/**
 *
 * @author User
 */
public interface Akunrepository <T, ID>{
    T register(String username, String password, String email );
    T login(String username, String password);
}
