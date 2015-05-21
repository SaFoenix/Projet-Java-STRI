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
    private Connection connexion;
            
    public MySql(){
        
    this.host="root";
    this.pwd="";
    this.url= "jdbc:mysql://localhost:3306/java?zeroDateTimeBehavior=convertToNull";
    }
    
    public void Connexion(){
         try {
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Driver O.K.");
      
      connexion = DriverManager.getConnection(url, host, pwd);
      System.out.println("Connexion effective !");         
      }
      catch (Exception e) {
      e.printStackTrace();
    }     
         
    }
    
    public void AjoutSociete(String nom,String lieux){
        
        Statement st = null;
        int idMax=0;
        try {
            st=connexion.createStatement();
        
         ResultSet resultat2 = st.executeQuery( "SELECT  max(idSociete)  FROM societe;" );
            while ( resultat2.next() ) {
            idMax = resultat2.getInt( "max(idSociete)" );
            idMax+=1;
            }
               
        String sql="INSERT INTO societe VALUES ('"+idMax+"','"+nom+"','"+lieux+"')";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void AjoutLocal(String nomL, String lieux) {

        Statement st = null;
        int idMax = 0;
        try {
            st = connexion.createStatement();

            ResultSet resultat2 = st.executeQuery("SELECT  max(idLocal)  FROM Local;");
            while (resultat2.next()) {
                idMax = resultat2.getInt("max(idLocal)");
                idMax += 1;
            }

            String sql = "INSERT INTO Local VALUES ('" + idMax + "','" + nomL + "','" + lieux + "')";
            st.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
    
    public void AjoutSalle(int numero , int nbOrdi , int etage){
        
        Statement st = null;
        int idMax=0;
        try {
            st=connexion.createStatement();
        
        ResultSet resultat2 = st.executeQuery( "SELECT  max(idSalle)  FROM Salle;" );
            while ( resultat2.next() ) {
            idMax = resultat2.getInt("max(idSalle)");
            idMax+=1;
            }
               
        
        String sql="INSERT INTO Salle VALUES ('"+idMax+"','"+numero+"','"+nbOrdi+",'"+etage+"')";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void AjoutOrdinateur(String nom , String mac , String marque, boolean power, String ram, String cpu , String gpu , String hdd){
        
        Statement st = null;
        int idMax=0;
        try {
            st=connexion.createStatement();
        
        ResultSet resultat2 = st.executeQuery( "SELECT  max(idEquipement)  FROM Equipement;" );
            while ( resultat2.next() ) {
            idMax = resultat2.getInt("max(idEquipement)");
            idMax+=1;
            }
        String sql="INSERT INTO equipement VALUES ('"+idMax+"','"+nom+"','"+mac+"','"+marque+"',"+power+");";
            st.executeUpdate(sql);
        String sqlOrdinateur="INSERT INTO ordinateur VALUES ('"+idMax+"','"+ram+"','"+cpu+"','"+gpu+"','"+hdd+"')";
            st.executeUpdate(sqlOrdinateur);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}