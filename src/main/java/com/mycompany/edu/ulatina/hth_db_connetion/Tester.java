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
            FeedbackService fed = new FeedbackService();
            List<EmployeeTO> list = eServ.getEmployeesFromProyect(3);
            List<EmployeeTO> list2 = eServ.getEmployeesNotOnProyect(3);
            
            System.out.println(act.getActivityName(7));
            
            for(FeedbackTO u : fed.getFeedback(1, 1)){
                System.out.println("id: " + u.getId() );

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
