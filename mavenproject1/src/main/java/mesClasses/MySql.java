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
    /*Ca marche*/
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
          System.out.println("Erreur connexion!");           
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
               
        String sql="INSERT INTO societe VALUES ("+idMax+",'"+nom+"','"+lieux+"')";
            st.executeUpdate(sql);
        } catch (SQLException e) {
        }
    }
    
    public void AjoutLocal(String Societe, String nomL, String lieux){

        Statement st;
        ResultSet resultat2;
        ResultSet resultat1;
        int idMax = 0;
        int IdSociete=0;
        try {
            st = connexion.createStatement();
            resultat2 = st.executeQuery("SELECT  max(idLocal)  FROM Local;");
            while (resultat2.next()) {
                idMax = resultat2.getInt("max(idLocal)");
                idMax += 1;
            }

            String sql = "INSERT INTO Local VALUES (" + idMax + ",'" + nomL + "','" + lieux + "')";
            st.executeUpdate(sql);
            resultat1 = st.executeQuery( "SELECT IdSociete FROM Societe WHERE nom='"+Societe+"'" );
            //System.out.println( "Requête \"resultat = st.executeQuery( \"SELECT Nom , Lieux  FROM Local L  WHERE IdLocal = (SELECT IdSociete, IdLocal FROM Contenir WHERE IdSociete='"+nom+"' AND L.IdLocal=IdLocal ;\" );\" effectuée !" );
            while (resultat1.next()){
            IdSociete=resultat1.getInt("IdSociete");
            }
            String sql2 ="INSERT INTO Contenir VALUES ("+IdSociete+","+idMax+")";
            st.executeUpdate(sql2);
            
      } catch (SQLException e) {System.out.println("Erreur AjoutLocal");
        }
    }
    
    public void AjoutSalle(String Local ,int numero , int nbOrdi , int etage){
        ResultSet resultat2;
        ResultSet resultat1;
        Statement st;
        int IdLocal = 0 ; 
        int idMax=0;
        try {
            st=connexion.createStatement();
        
            resultat2 = st.executeQuery( "SELECT  max(idSalle)  FROM Salle;" );
            while ( resultat2.next() ) {
            idMax = resultat2.getInt("max(idSalle)");
            idMax+=1;
            }
              
            String sql="INSERT INTO salle VALUES ("+idMax+","+numero+","+nbOrdi+","+etage+")";
            st.executeUpdate(sql);
            
            resultat1 = st.executeQuery( "SELECT IdLocal FROM Local WHERE nomLocal='"+Local+"'" );
            while (resultat1.next()){
            IdLocal=resultat1.getInt("IdLocal");
            }
            String sql2 ="INSERT INTO Contenirsalle VALUES ("+idMax+","+IdLocal+")";
            st.executeUpdate(sql2);
        } catch (SQLException e) 
        {
            System.out.println("Erreur Ajout Salle");
        }
    }
    
    public void AjoutOrdinateur(int numeroSalle , String nom , String mac , String marque, boolean power, String ram, String cpu , String gpu , String hdd){
        ResultSet resultat2;
        ResultSet resultat1;
        Statement st;
        int idSalle=0;
        int idMax=0;
        try {
            st=connexion.createStatement();
        
            resultat2 = st.executeQuery( "SELECT  max(idEquipement)  FROM Equipement;" );
            while ( resultat2.next() ) {
            idMax = resultat2.getInt("max(idEquipement)");
            idMax+=1;
            }
        String sql="INSERT INTO equipement VALUES ("+idMax+",'"+nom+"','"+mac+"','"+marque+"',"+power+");";
            st.executeUpdate(sql);
            
        String sqlOrdinateur="INSERT INTO ordinateur VALUES ("+idMax+",'"+ram+"','"+cpu+"','"+gpu+"','"+hdd+"')";
            st.executeUpdate(sqlOrdinateur);
            
        resultat1 = st.executeQuery( "SELECT IdSalle FROM Salle WHERE numero="+numeroSalle+"" );
            while (resultat1.next()){
            idSalle=resultat1.getInt("IdSalle");
            }
            String sql2 ="INSERT INTO Contenirequipement VALUES ("+idSalle+","+idMax+")";
            st.executeUpdate(sql2);
        } 
        catch (SQLException e) {
            System.out.println("Erreur Ajout ordinateur");
        }
    }
   
    public Societe RecupererSociete(String nomSociete) {
        ResultSet resultat = null;
        Statement st;
        Societe so=null;
        String Lieux;
        String Nom;
        int IdSociete;
        try {
            st = connexion.createStatement();
            resultat = st.executeQuery("SELECT  IdSociete, Nom,Lieux  FROM Societe WHERE Nom='"+nomSociete+"';");
            /* Récupération des données du résultat de la requête de lecture */
            while (resultat.next()) {
                IdSociete = resultat.getInt("IdSociete");
                Nom = resultat.getString("Nom");
                Lieux = resultat.getString("Lieux");
                so=new Societe(Nom,Lieux);
                so.setIdSociete(IdSociete);
            }
        } catch (SQLException e) {
            System.out.println("Erreur Recuperer Societe!");
        }
        return so;
    }
    
    public ArrayList<Local> SocieteLocal(String nom){
        
        ResultSet resultat;
        ResultSet query;
        Local lo = null;
        Statement st;
        String Lieux;
        String Nom;
        int IdSociete=0;
        ArrayList<Local> locaux;
        locaux = new ArrayList<>();
        
        try {
            st=connexion.createStatement();
            query = st.executeQuery( "SELECT  IdSociete FROM Societe WHERE Nom='"+nom+"';" );
            while(query.next()){
            IdSociete = query.getInt( "IdSociete" );
            }  
            
        resultat = st.executeQuery( "SELECT NomLocal , Lieux  FROM Local L  WHERE IdLocal = (SELECT IdLocal FROM Contenir WHERE IdSociete='"+IdSociete+"' AND L.IdLocal=IdLocal) ;;" );   
        
        /* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
            Nom = resultat.getString( "NomLocal" );
            Lieux = resultat.getString( "Lieux" );
               lo = new Local(Nom,Lieux);
               locaux.add(lo);
            }
   } catch (SQLException e) {
       System.out.println("Erreur SocieteLocal" );
        }
        return locaux;     
    }
      
    public ArrayList<Salle> LocalSalle(String nom){
        
        ResultSet resultat;
        ResultSet query;
        Statement st;
        int numero;
        int etage;
        int nbPc;
        int IdLocal=0;
        ArrayList<Salle> salles;
        salles = new ArrayList<>();
        try {
            st=connexion.createStatement();
            query = st.executeQuery( "SELECT  IdLocal FROM Local WHERE NomLocal='"+nom+"';" );
            while(query.next()){
            IdLocal = query.getInt( "IdLocal" );
            }
            resultat = st.executeQuery( "SELECT numero , etage, NombreOrdinateur FROM Salle S  WHERE IdSalle = (SELECT IdSalle FROM ContenirSalle WHERE IdLocal='"+IdLocal+"' AND S.IdSalle=IdSalle) ;" );
             
        /* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
            numero = resultat.getInt( "numero" );
            etage = resultat.getInt( "etage" );
            nbPc = resultat.getInt( "NombreOrdinateur" );
            salles.add(new Salle (numero,etage,nbPc));
            }
   } catch (SQLException e) {
                    System.out.println( "Erreur LocalSalle !" );
        }
        return salles;     
    }
    
 

}
