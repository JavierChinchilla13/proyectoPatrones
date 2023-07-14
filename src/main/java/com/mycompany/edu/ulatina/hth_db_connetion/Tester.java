package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Tester {

    public static void main(String[] args) throws SQLException, Exception {

        try {
            DocumentService serv = new DocumentService();
            DocumentTO test = serv.searchByPK(2);
            
            System.out.println(test.getName());
            
            VacationService serv2 = new VacationService();
            
            System.out.println(serv2.getVacationDaysOf(2));
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
