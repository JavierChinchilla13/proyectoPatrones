package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Date;
import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) throws SQLException, Exception {

        try {
            EmployeeService empServ = new EmployeeService();
            EmployeeTO test = empServ.searchByPK(3);
            
            System.out.println(test.getFirstName());
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
