/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mesClasses;


import java.sql.*;
import java.util.*;

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
      catch (ClassNotFoundException | SQLException e) {
    }     
         
    }
    
    public void AjoutSociete(String nom,String lieux){
        
        Statement st;
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
        }
    }
    
    public void AjoutLocal(String nomL, String lieux){

        Statement st=null;
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
            String sql2 ="INSERT INTO Contenir VALUES (1,'"+idMax+"')";
            st.executeUpdate(sql2);
            
      } catch (SQLException e) {
        }
    }
    
    public void AjoutSalle(String nomL,int numero , int nbOrdi , int etage){
        
        Statement st;
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
        }
    }
    
    public ArrayList RecupererSociete(){
        ResultSet resultat = null;
        Statement st;
        int idMax=0;
        String Lieux;
        String Nom;
        int IdSociete;
        ArrayList societe = new ArrayList();
        try {
            st=connexion.createStatement();
        
        resultat = st.executeQuery( "SELECT  IdSociete, Nom,Lieux  FROM Societe;" );
             System.out.println( "Requête \"SELECT  IdSociete, Nom,Lieux  FROM Societe;\" effectuée !" );
             
        /* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
            IdSociete = resultat.getInt( "IdSociete" );
            Nom = resultat.getString( "Nom" );
            Lieux = resultat.getString( "Lieux" );
            societe.add(IdSociete);
            societe.add (Nom);
            societe.add (Lieux);
            }
   } catch (SQLException e) {
        }
        return societe;
    }
    
    public ArrayList SocieteLocal(String nom){
        
        ResultSet resultat = null;
        ResultSet query = null;
        Statement st;
        String Lieux;
        String Nom;
        int IdSociete;
        ArrayList societe = new ArrayList();
        try {
            st=connexion.createStatement();
        
            query = st.executeQuery( "SELECT  IdSociete FROM Societe WHERE Nom='"+nom+"';" );
            IdSociete = query.getInt( "IdSociete" );
            System.out.println("La societe a l'ID : "+IdSociete);
            resultat = st.executeQuery( "SELECT NomLocal , Lieux  FROM Local L  WHERE IdLocal = (SELECT IdLocal FROM Contenir WHERE IdSociete='"+nom+"' AND L.IdLocal=IdLocal) ;;" );
            System.out.println( "Requête \"resultat = st.executeQuery( \"SELECT Nom , Lieux  FROM Local L  WHERE IdLocal = (SELECT IdSociete, IdLocal FROM Contenir WHERE IdSociete='\"+nom+\"' AND L.IdLocal=IdLocal ;\" );\" effectuée !" );
             
        /* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
            Nom = resultat.getString( "NomLocal" );
            Lieux = resultat.getString( "Lieux" );
            societe.add (Nom);
            societe.add (Lieux);
            societe.add ("\n");
            }
   } catch (SQLException e) {
        }
        return societe;     
    }
    public void AjoutOrdinateur(String nom , String mac , String marque, boolean power, String ram, String cpu , String gpu , String hdd){
        
        Statement st;
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
        }
    }
}