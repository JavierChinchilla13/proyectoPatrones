/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.SQLException;

/**
 *
 * @author javi
 */
public class Tester {
    
    public static void main(String[] args) throws SQLException {
        
        
        
        try{
            
             /*UserTO i = new UserTO(3, "Javi","123","Chin","Activo");
             ServicioUsuario au2 = new ServicioUsuario();
             au2.Login(i);
             System.out.println(au2.Login(i));*/
             /*
             EmployeeTO i = new EmployeeTO(0,"Javi","Chin","12333333","A@mal","","Active","123","Manager");
             
             EmployeeService au2 = new EmployeeService();
             au2.insert(i);
            
            EmployeeService au = new EmployeeService();
            au.login("master@gmail.com","1234");
            System.out.println(au.login("master@gmail.com","1234"));*/
            EmployeeService au = new EmployeeService();
            
            //au.update(19, "Javier", "Chinchilla", "118980560", "javidilugo@gmail.com", "85058928", 2, 6, "1234");
            
            for(EmployeeTO u : au.getEmployees()){
                System.out.println("id: " + u.getId() );

            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
