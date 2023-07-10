package com.mycompany.edu.ulatina.hth_db_connetion;

import java.sql.Date;
import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) throws SQLException, Exception {

        try {
            DocumentTO doc = new DocumentTO(1123, 1, "test","test path");
            DocumentService ds = new DocumentService();
            
            ds.insert(doc);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
