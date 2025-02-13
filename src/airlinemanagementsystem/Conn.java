/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagementsystem;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

/**
 *
 * @author Tanisha singh Pariha
 */
public class Conn {
    
    Connection c;
    Statement s;
     public Conn(){
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
          c= DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem","root","tsc16#1");
          s= c.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
