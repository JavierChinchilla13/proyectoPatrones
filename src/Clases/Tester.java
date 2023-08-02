/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author javi
 */
public class Tester {
    public static void main(String[] args) throws SQLException, Exception {

        try {
            
            LibroService lib = new LibroService();
            //LibroTO l = new LibroTO(0,"Jav", 2020, "4093032");
            
            lib.update(19, "ODISEA", 2020, "JAVI");
            //lib.insert(l);
            
            /*for(LibroTO u : lib.getLibros()){
                System.out.println("Name: " + u.getTitulo() );

            }*/
            
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
