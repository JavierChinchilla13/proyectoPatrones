package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Date;
import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) throws SQLException, Exception {

        try {
            

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
            /*EmployeeService au = new EmployeeService();
            PermitService a = new PermitService();
            //a.searchByPK(1);
            for(PermitTO u : a.searchByEmployee(1)){
                System.out.println("id: " + u.getId() );

            }
            
            
             
             
            /*System.out.println(a.searchByEmployee(1));
            for(EmployeeTO u : au.getEmployees()){
                System.out.println("id: " + u.getId() );

            }
            //au.update(19, "Javier", "Chinchilla", "118980560", "javidilugo@gmail.com", "85058928", 2, 6, "1234");
            //hola
            for(EmployeeTO u : au.getEmployees()){
                System.out.println("id: " + u.getId() );

            }*/
 
            /*Bloque de ScheduleVacationService
            ScheduleVacationService s = new ScheduleVacationService();
            java.util.Date currentDate = new java.util.Date();
            Date sqlDate = new Date(currentDate.getTime());
            ScheduleVacationTO svt = new ScheduleVacationTO(1, 10, sqlDate, sqlDate, 15);
            s.insert(90, sqlDate, sqlDate,16);
            s.update(svt, 7, sqlDate, sqlDate, 16);
            for(ScheduleVacationTO x : s.getScheduleVacation()){
                System.out.println("id: " + x.getId() + "\nid_vacation: " + x.getIdVacation() + "\nstart_date: " + x.getStartDate() + "\nend_date: " + x.getEndDate() + "\nId Status: " + x.getIdStatus());
            }
            System.out.println(s.getVacationIdByEmployeeId(900));*/
        
            /*Bloque de VacationService
            VacationService v = new VacationService();
            VacationTO x = new VacationTO(5, 150, 42);
            v.insert(x);
            v.insert(600, 9000);
            v.update(x);
            v.update(x, 320, 0);
            v.delete(x);
            v.delete(4);
            System.out.println(v.searchByPK(3));
            for(VacationTO z : v.getVacations()){
                System.out.println("id: " + z.getId() + "\nId Employee: " + z.getIdEmployee()+ "\nVacation Days: " + z.getVacationDays());
            }*/
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
