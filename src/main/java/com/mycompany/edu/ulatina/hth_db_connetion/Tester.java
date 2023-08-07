package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Tester {

    public static void main(String[] args) throws SQLException, Exception {

        try {
            ProjectService pServ = new ProjectService();
            EmployeeService eServ = new EmployeeService();
            PermitService per= new PermitService();
            ActivityService act= new ActivityService();
            ScheduleVacationService vac = new ScheduleVacationService();
            List<EmployeeTO> list = eServ.getEmployeesFromProyect(3);
            List<EmployeeTO> list2 = eServ.getEmployeesNotOnProyect(3);
            
            System.out.println(act.getActivityName(7));
            
            for(ActivityTO u : act.getSearchActivity(1, 1)){
                System.out.println("id: " + u.getId() );

            }
            
            /*
            for(PermitTO u : per.getOld(1)){
                System.out.println("id: " + u.getId() );

            }
            
            //System.out.println(per.getNew(1));
            
            /*
            for(EmployeeTO e : list){
                System.out.println(" -> NOM: " + e.getFullName());
                System.out.println(" -> ID: " + e.getId());
            }
            System.out.println(" \n\n\n ");
            for(EmployeeTO e : list2){
                System.out.println(" -> NOM: " + e.getFullName());
                System.out.println(" -> ID: " + e.getId());
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            pServ.addCollaborator(3, 5);
            list = eServ.getEmployeesFromProyect(3);
            for(EmployeeTO e : list){
                System.out.println(" -> NOM: " + e.getFullName());
                System.out.println(" -> ID: " + e.getId());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
