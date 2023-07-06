package com.mycompany.edu.ulatina.hth_db_connetion;

import java.util.List;

public interface ICrud <T>{
    public void insert(T obj)throws Exception;
    public void delete(T obj)throws Exception;
}
