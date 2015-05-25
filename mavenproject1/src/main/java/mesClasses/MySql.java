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
        ResultSet verif;
        int idMax = 0;
        int IdSociete=0;
        try {
            st = connexion.createStatement();
            resultat2 = st.executeQuery("SELECT  max(idLocal)  FROM Local;");
            while (resultat2.next()) {
                idMax = resultat2.getInt("max(idLocal)");
                idMax += 1;
            }
            
            verif=st.executeQuery("SELECT  NomLocal  FROM Local WHERE NomLocal='"+nomL+"';");
            if (verif!=null)
                {
                int nbLignes = 0;
                while (verif.next()) 
                { 
                nbLignes ++;  
                } 

                if (nbLignes == 0) 
                {
            String sql = "INSERT INTO Local VALUES (" + idMax + ",'" + nomL + "','" + lieux + "')";
            st.executeUpdate(sql);
            resultat1 = st.executeQuery( "SELECT IdSociete FROM Societe WHERE nom='"+Societe+"'" );
            while (resultat1.next()){
            IdSociete=resultat1.getInt("IdSociete");
            }
            String sql2 ="INSERT INTO Contenir VALUES ("+IdSociete+","+idMax+")";
            st.executeUpdate(sql2);
                }else{System.out.println("Le local "+nomL+" existe deja.");}
                }
                else
                {System.out.println("res est null");
                }
      } 
        catch (SQLException e) {
            System.out.println("Erreur AjoutLocal");
        }
    }
    
    public void AjoutSalle(String Local ,int numero , int etage, int nbOrdi){
        ResultSet resultat2;
        ResultSet resultat1;
        ResultSet resultatSalle;
        ResultSet verif;
        Statement st;
        int IdLocal = 0 ; 
        int IdSalle=0;
        int idMax=0;
        try {
            st=connexion.createStatement();
        
            resultat2 = st.executeQuery( "SELECT  max(idSalle)  FROM Salle;" );
            while ( resultat2.next() ) {
            idMax = resultat2.getInt("max(idSalle)");
            idMax+=1;
            }
            resultat1 = st.executeQuery( "SELECT IdLocal FROM Local WHERE nomLocal='"+Local+"'" );
            while (resultat1.next()){
            IdLocal=resultat1.getInt("IdLocal");
            }
            resultatSalle = st.executeQuery( "SELECT IdSalle FROM Salle WHERE numero='"+numero+"'" );
            while (resultatSalle.next()){
            IdSalle=resultatSalle.getInt("IdSalle");
            }
            verif=st.executeQuery("SELECT  numero FROM Salle S WHERE IdSalle=(SELECT IdSalle FROM contenirsalle WHERE IdLocal="+IdLocal+" AND IdSalle="+IdSalle+")");
            if (verif!=null)
                {
                int nbLignes = 0;
                while (verif.next()) 
                { 
                nbLignes ++;  
                } 

                if (nbLignes == 0) 
                {
                    String sql="INSERT INTO salle VALUES ("+idMax+","+numero+","+etage+","+nbOrdi+")";
                    st.executeUpdate(sql);
                    String sql2 ="INSERT INTO Contenirsalle VALUES ("+IdLocal+","+idMax+")";
                    st.executeUpdate(sql2);
                }else{System.out.println("La Salle "+numero+" existe deja dans le Local "+Local+".");}
                }
                else
                {System.out.println("res est null");
                }
              
            
        } catch (SQLException e) 
        {
            System.out.println("Erreur Ajout Salle");
        }
    }
    
    public void AjoutRouteur(int numeroSalle, String nom , String mac , String marque, String os , String versionOs, boolean power, int nombrePort){
        ResultSet resultat1;
        ResultSet resultat2;
        ResultSet resultat3;
        ResultSet resultat4;
        Statement st;
        int idSalle=0;
        int idMax=0;
        int idMaxOs = 0 ; 
        int idOs = 0 ; 
        boolean verificationE;
        boolean verificationOs;
try {
            st=connexion.createStatement();
            verificationE=VerifierEquipement(mac);
            if(verificationE!=true){
                System.out.println("Erreur, l'addresse MAC : "+mac+" existe deja");
            }else{
            resultat1 = st.executeQuery( "SELECT  max(idEquipement)  FROM Equipement;" );
            while ( resultat1.next() ) {
            idMax = resultat1.getInt("max(idEquipement)");
            idMax+=1;
            }
            
        String sql="INSERT INTO equipement VALUES ("+idMax+",'"+nom+"','"+mac+"','"+marque+"',"+power+");";
            st.executeUpdate(sql);
            
        String sqlRouteur="INSERT INTO routeur VALUES ("+idMax+","+nombrePort+")";
            st.executeUpdate(sqlRouteur);
            
        resultat2 = st.executeQuery( "SELECT IdSalle FROM Salle WHERE numero="+numeroSalle+"" );
            while (resultat2.next()){
            idSalle=resultat2.getInt("IdSalle");
            }
        String sql2 ="INSERT INTO Contenirequipement VALUES ("+idSalle+","+idMax+")";
            st.executeUpdate(sql2);   
            
        verificationOs=VerifierOs(os,versionOs);
        resultat3 = st.executeQuery( "SELECT  max(IdOs)  FROM os;" );
            while ( resultat3.next() ) {
            idMaxOs = resultat3.getInt("max(IdOs)");
            idMaxOs+=1;
            }
        if(verificationOs!=true){
            resultat4=st.executeQuery("SELECT IdOs FROM os WHERE NomOs='"+os+"'AND Version='"+versionOs+"'");
            while(resultat4.next()){
               idOs = resultat4.getInt("IdOs");
           }    
            String sql3 = "INSERT INTO estinstaller VALUES ("+idMax+","+idOs+")";
            st.executeUpdate(sql3);
       }else{
           String sql4 = "INSERT INTO os VALUES ("+idMaxOs+",'"+os+"','"+versionOs+"')";
            st.executeUpdate(sql4);
            String sql5 = "INSERT INTO estinstaller VALUES ("+idMax+","+idMaxOs+")";
            st.executeUpdate(sql5);
       }
       }
}catch (SQLException e) {
            System.out.println("Erreur Ajout Routeur");
        }
        
    }
    
    public void AjoutOrdinateur(int numeroSalle , String nom , String mac , String marque,String os , String versionOs , boolean power, String ram, String cpu , String gpu , String hdd){
        ResultSet resultat1;
        ResultSet resultat2;
        ResultSet resultat3;
        ResultSet resultat4;
        ResultSet resultat5;
        ResultSet resultat6;
        ResultSet verif;
        Statement st;
        int idSalle=0;
        int idMax=0;
        int idMaxOs=0;
        int idRouteur=0;
        int numeroPort=0;
        int idOs=0;
        boolean verification;
        boolean verificationOs;
        try {
            st=connexion.createStatement();
            verification=VerifierEquipement(mac);
            if(verification!=true){
                System.out.println("Erreur, l'addresse MAC : "+mac+" existe deja");
            }else{
        resultat1 = st.executeQuery( "SELECT  max(idEquipement)  FROM Equipement;" );
            while ( resultat1.next() ) {
            idMax = resultat1.getInt("max(idEquipement)");
            idMax+=1;
            }
        String sql="INSERT INTO equipement VALUES ("+idMax+",'"+nom+"','"+mac+"','"+marque+"',"+power+");";
            st.executeUpdate(sql);
            
        String sqlOrdinateur="INSERT INTO ordinateur VALUES ("+idMax+",'"+ram+"','"+cpu+"','"+gpu+"','"+hdd+"')";
            st.executeUpdate(sqlOrdinateur);
            
        resultat2 = st.executeQuery( "SELECT IdSalle FROM Salle WHERE numero="+numeroSalle+"" );
            while (resultat2.next()){
            idSalle=resultat2.getInt("IdSalle");
            }
            String sql2 ="INSERT INTO Contenirequipement VALUES ("+idSalle+","+idMax+")";
            st.executeUpdate(sql2);
            
        resultat3 = st.executeQuery( "SELECT IdRouteur FROM routeur r WHERE IdRouteur IN (SELECT IdEquipement FROM contenirequipement WHERE IdSalle="+idSalle+" )  " );    
        while (resultat3.next()){
            idRouteur=resultat3.getInt("IdRouteur");
            }
        resultat4 = st.executeQuery( "SELECT max(NumeroPort) FROM connecter WHERE IdRouteur="+idRouteur+"");
        while (resultat4.next()){
            numeroPort=resultat4.getInt("max(NumeroPort)");
            numeroPort+=1;
            }
            String sql3 ="INSERT INTO connecter VALUES ("+idRouteur+","+idMax+","+numeroPort+")";
            st.executeUpdate(sql3);
            
            verificationOs=VerifierOs(os,versionOs);
        resultat5 = st.executeQuery( "SELECT  max(IdOs)  FROM os;" );
            while ( resultat5.next() ) {
            idMaxOs = resultat5.getInt("max(IdOs)");
            idMaxOs+=1;
            }
        if(verificationOs!=true){
        resultat6=st.executeQuery("SELECT IdOs FROM os WHERE NomOs='"+os+"'AND Version='"+versionOs+"'");
            while(resultat6.next()){
               idOs = resultat6.getInt("IdOs");
           }    
        String sql4 = "INSERT INTO estinstaller VALUES ("+idMax+","+idOs+")";
            st.executeUpdate(sql4);
       }else{
        String sql5 = "INSERT INTO os VALUES ("+idMaxOs+",'"+os+"','"+versionOs+"')";
            st.executeUpdate(sql5);
        String sql6 = "INSERT INTO estinstaller VALUES ("+idMax+","+idMaxOs+")";
            st.executeUpdate(sql6);
       }
        }
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
    
    public ArrayList<Local> RecupererLocal(String nom){
        
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
            
        resultat = st.executeQuery( "SELECT NomLocal , Lieux  FROM Local L  WHERE IdLocal IN (SELECT IdLocal FROM Contenir WHERE IdSociete='"+IdSociete+"' AND L.IdLocal=IdLocal) ;;" );   
        
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
      
    public ArrayList<Salle> RecupererSalle(String nom){
        
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
            resultat = st.executeQuery( "SELECT numero , etage, NombreOrdinateur FROM Salle S  WHERE IdSalle IN (SELECT IdSalle FROM ContenirSalle WHERE IdLocal='"+IdLocal+"' AND S.IdSalle=IdSalle) ;" );
             
        /* Récupération des données du résultat de la requête de lecture */
        while ( resultat.next() ) {
            numero = resultat.getInt( "numero" );
            nbPc = resultat.getInt( "NombreOrdinateur" );
            etage = resultat.getInt( "etage" );
            
            salles.add(new Salle (numero,etage,nbPc));
            }
   } catch (SQLException e) {
                    System.out.println( "Erreur LocalSalle !" );
        }
        return salles;     
    }
    
    public ArrayList<Ordinateur> RecupererOrdinateur(int numero){
        /*Information Equipement + Os*/
        ResultSet resultat;
        ResultSet query;
        Statement st;
        String Nom = null;
        String NomEquipement;
        String Mac;
        String Marque;
        boolean Power;
        String NomOs;
        String Version;
        
        /*Information ordinateur*/
        String GPU;
        String CPU;
        String HDD;
        String RAM;
        
        ArrayList<Ordinateur> ordinateur;
        ordinateur = new ArrayList<>();
        Os os;
        
        int IdSalle=0;
        
        try {
            st=connexion.createStatement();
            query = st.executeQuery( "SELECT  IdSalle FROM Salle WHERE numero='"+numero+"';" );
            while(query.next()){
            IdSalle = query.getInt( "IdSalle" );
            }
            resultat = st.executeQuery( "SELECT * FROM ordinateur o, Equipement e, OS os  WHERE e.IdEquipement = o.IdOrdinateur AND os.IdOs IN (SELECT IdOs FROM estinstaller WHERE e.IdEquipement = IdEquipement) AND e.IdEquipement IN (SELECT IdEquipement FROM contenirEquipement WHERE IdSalle="+IdSalle+") AND o.IdOrdinateur IN (SELECT IdOrdinateur FROM connecter)" );
        while ( resultat.next() ) {
            NomEquipement=resultat.getString("Nom");
            Mac=resultat.getString("MAC");
            Marque=resultat.getString("Marque");
            Power=resultat.getBoolean("Power");
            CPU=resultat.getString("CPU");
            HDD=resultat.getString("HDD");
            GPU=resultat.getString("GPU");
            RAM=resultat.getString("RAM");
            NomOs=resultat.getString("NomOs");
            Version=resultat.getString("Version");
            os = new Os (NomOs,Version);
            ordinateur.add(new Ordinateur (NomEquipement,Mac,Marque,Power,os,RAM,CPU,GPU,HDD));
            }
   } catch (SQLException e) {
                    System.out.println( "Erreur Recuperation Ordinateur !" );
        }
        return ordinateur;     
}
    
    public ArrayList<Routeur> RecupererRouteur(int numero){
        
        /*Information Equipement + Os*/
        ResultSet resultat;
        ResultSet query;
        Statement st;
        String Nom = null;
        String NomEquipement;
        String Mac;
        String Marque;
        boolean Power;
        String NomOs;
        String Version;
        
        //Information routeur : 
        int numeroPort;
        int nbPort;
        ArrayList<Routeur> routeur;
        routeur = new ArrayList<>();
        int IdSalle=0;
        Os os;
        
        try {
            st=connexion.createStatement();
            query = st.executeQuery( "SELECT  IdSalle FROM Salle WHERE numero='"+numero+"';" );
            while(query.next()){
            IdSalle = query.getInt( "IdSalle" );
            }
            
            
        resultat=st.executeQuery("SELECT * FROM Equipement e , Routeur r , Os os WHERE e.power=1 AND e.IdEquipement=r.IdRouteur AND os.IdOs IN (SELECT IdOs FROM estinstaller WHERE e.IdEquipement = IdEquipement) AND e.IdEquipement IN (SELECT IdEquipement FROM contenirEquipement WHERE IdSalle="+IdSalle+") ");
           while ( resultat.next() ) {
            NomEquipement=resultat.getString("Nom");
            Mac=resultat.getString("MAC");
            Marque=resultat.getString("Marque");
            nbPort=resultat.getInt("NombreDePort");
            Power=resultat.getBoolean("Power");
            NomOs=resultat.getString("NomOs");
            Version=resultat.getString("Version");
            os = new Os (NomOs,Version);
            routeur.add(new Routeur (NomEquipement,Mac,Marque,Power,os,nbPort));
           }
        } catch (SQLException e) {
                    System.out.println( "Erreur Recuperation Ordinateur !" );
        }
    return routeur;
    }
        
    public boolean VerifierOs(String nom, String version){
    ResultSet verif= null;
    Statement st;
    
    try{
        st=connexion.createStatement();
        verif=st.executeQuery("SELECT IdOs FROM Os WHERE NomOs='"+nom+"'AND Version='"+version+"'");
        if(verif!=null){
        int nbLignes = 0;
                while (verif.next()) 
                {nbLignes ++;
                }
        if(nbLignes == 0){
            return true;
        }
         else{
                return false;
             }
    }else{
            System.out.println("Erreur verifierOs");
    }
    }catch (SQLException e){
            System.out.println("VerifierOs!");
        }
    System.out.println("On ne fais pas le test il y a une erreur.");
    return false;
    }
    
    public boolean VerifierEquipement(String mac){
    ResultSet verif= null;
    Statement st;
    int equipementok =0 ; 
    
    try{
        st=connexion.createStatement();
        verif=st.executeQuery("SELECT MAC FROM equipement WHERE MAC='"+mac+"'");
        if(verif!=null){
        int nbLignes = 0;
                while (verif.next()) 
                {nbLignes ++;
                }
        if (nbLignes == 0){
            return true;
        }
         else{
                return false;
             }
    }else{
            System.out.println("Erreur verifierEquipemet");
    }
    }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    return false;
    }
        
    public void ModifierNom(String nom, String mac){
        
        ResultSet resultat;
        Statement st;
        try{
            st=connexion.createStatement();
            String sql=("UPDATE equipement SET Nom = '"+nom+"' WHERE Mac='"+mac+"'");
            st.executeUpdate(sql); 
        }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    }
    
    public void ModifierGpu(String gpu, String mac){
        
        ResultSet resultat;
        Statement st;
        try{
            st=connexion.createStatement();
            String sql=("UPDATE equipement SET gpu = '"+gpu+"' WHERE Mac='"+mac+"'");
            st.executeUpdate(sql); 
        }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    }
    
    public void ModifierCpu(String cpu, String mac){
        
        ResultSet resultat;
        Statement st;
        try{
            st=connexion.createStatement();
            String sql=("UPDATE equipement SET cpu = '"+cpu+"' WHERE Mac='"+mac+"'");
            st.executeUpdate(sql); 
        }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    }
    
    public void ModifierEtat(boolean etat, String mac){
        
        ResultSet resultat;
        Statement st;
        try{
            st=connexion.createStatement();
            String sql=("UPDATE equipement SET power = '"+etat+"' WHERE Mac='"+mac+"'");
            st.executeUpdate(sql); 
        }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    }
    
    public void ModifierRam(String ram, String mac){
        
        ResultSet resultat;
        Statement st;
        try{
            st=connexion.createStatement();
            String sql=("UPDATE equipement SET Nom = '"+ram+"' WHERE Mac='"+mac+"'");
            st.executeUpdate(sql); 
        }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    }
    
    public void ModifierHdd(String Hdd, String mac){
        
        ResultSet resultat;
        Statement st;
        try{
            st=connexion.createStatement();
            String sql=("UPDATE equipement SET Nom = '"+Hdd+"' WHERE Mac='"+mac+"'");
            st.executeUpdate(sql); 
        }catch (SQLException e){
            System.out.println("VerifierOrdinateur!");
        }
    }
}
