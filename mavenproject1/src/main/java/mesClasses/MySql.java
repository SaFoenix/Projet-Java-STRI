/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesClasses;

import java.sql.*;

/**
 *
 * @author ROG ASUS
 */
public class MySql {
    private String host;
    private String pwd;
    private String url;
    private Connection connection;
            
    public MySql(){
        
    this.host="root";
    this.pwd="";
    this.url= "jdbc:mysql://localhost:3306/java?zeroDateTimeBehavior=convertToNull";
    }
    
    public void Connection(){
     
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver O.K.");
      
      connection = DriverManager.getConnection(url, host, pwd);
      System.out.println("Connexion effective !");         
      
         
    }
    
    public void AjoutSociete(String nom,String lieux) throws SQLException{
        
        Statement st;
        st=connection.createStatement();
        String sql="INSERT INTO societe VALUES ('','"+nom+"','"+lieux+"')";
        st.executeUpdate(sql);
    }
    
}
