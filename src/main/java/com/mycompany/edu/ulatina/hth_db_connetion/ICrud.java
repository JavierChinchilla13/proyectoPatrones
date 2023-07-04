/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.edu.ulatina.hth_db_connetion;

import java.util.List;

public interface ICrud <T>{
    
    
    public void insert(T obj)throws Exception;
    public void delete(T obj)throws Exception;
    
    
}
