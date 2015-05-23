/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetrePrincipale;

import java.awt.*;
import java.util.*;
import mesClasses.*;
import fenetreLocal.*;
import static java.awt.SystemColor.desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author guigui
 */
public class Bureau extends javax.swing.JFrame {
    private static Societe so;
    private static MySql bdd;
    private GridLayout grilleLocal;
    /**
     * Creates new form Bureau
     */
    public Bureau() {
        bdd=new MySql();
        /*bdd.Connexion();
        so=bdd.RecupererSociete("STRI");
        so.setLocaux(bdd.SocieteLocal("STRI"));*/
        so=new Societe("Stri", "Toulouse");
        so.ajouterLocal("local1", "bordeaux");
        so.ajouterLocal("local2", "bordeaux");
        so.ajouterSalle("local1", 0, 1, 15);
        so.ajouterSalle("local1", 0, 2, 20);
        initComponents();
        initialiseInterface();
    }
    
    public void initialiseInterface(){        
        ArrayList<Local> locaux=so.getLocaux();
        grilleLocal=new GridLayout(locaux.size(),1);
        setLayout(grilleLocal);
        for(Local loc:locaux){
            //System.out.println(loc);
            final Button boutonLocal = new Button(loc.getNom() + " " + "[" + loc.getlocalisation()+ "]");
            boutonLocal.setName(loc.getNom());
            add(boutonLocal);
            boutonLocal.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){  
                    System.out.println(boutonLocal.getName());
                    Local loc=so.rechercherLocal(boutonLocal.getName());
                    FenetreSecondaire f=new FenetreSecondaire(loc);
                    f.setVisible(true);
                }
                });
            
        }      
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LocalDialog = new javax.swing.JDialog();
        LocalOk = new javax.swing.JButton();
        LocalCancel = new javax.swing.JButton();
        LocalName = new javax.swing.JTextField();
        NomLocal = new javax.swing.JLabel();
        CreationLocal = new javax.swing.JLabel();
        LieuLocal = new javax.swing.JLabel();
        LocalLieu = new javax.swing.JTextField();
        AfficheLocaux = new javax.swing.JPanel();
        BarreMenu = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        MenuQuitter = new javax.swing.JMenuItem();
        MenuAjouter = new javax.swing.JMenu();
        AjouterLocal = new javax.swing.JMenuItem();

        LocalDialog.setBackground(new java.awt.Color(0, 255, 255));
        LocalDialog.setMinimumSize(new java.awt.Dimension(420, 320));

        LocalOk.setBackground(new java.awt.Color(0, 255, 0));
        LocalOk.setText("Valider");
        LocalOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalOkActionPerformed(evt);
            }
        });

        LocalCancel.setBackground(new java.awt.Color(255, 0, 0));
        LocalCancel.setText("Annuler");
        LocalCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalCancelActionPerformed(evt);
            }
        });

        LocalName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalNameActionPerformed(evt);
            }
        });

        NomLocal.setText("Nom");

        CreationLocal.setText("Création Local");

        LieuLocal.setText("Lieu");

        LocalLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalLieuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LocalDialogLayout = new javax.swing.GroupLayout(LocalDialog.getContentPane());
        LocalDialog.getContentPane().setLayout(LocalDialogLayout);
        LocalDialogLayout.setHorizontalGroup(
            LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocalDialogLayout.createSequentialGroup()
                .addGroup(LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LocalDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NomLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(LieuLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(LocalDialogLayout.createSequentialGroup()
                                .addComponent(LocalOk)
                                .addGap(18, 18, 18)
                                .addComponent(LocalCancel))
                            .addComponent(LocalName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(LocalLieu, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(LocalDialogLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(CreationLocal)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        LocalDialogLayout.setVerticalGroup(
            LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LocalDialogLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(CreationLocal)
                .addGap(18, 18, 18)
                .addGroup(LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomLocal))
                .addGap(18, 18, 18)
                .addGroup(LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LieuLocal))
                .addGap(18, 18, 18)
                .addGroup(LocalDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LocalCancel)
                    .addComponent(LocalOk))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout AfficheLocauxLayout = new javax.swing.GroupLayout(AfficheLocaux);
        AfficheLocaux.setLayout(AfficheLocauxLayout);
        AfficheLocauxLayout.setHorizontalGroup(
            AfficheLocauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1141, Short.MAX_VALUE)
        );
        AfficheLocauxLayout.setVerticalGroup(
            AfficheLocauxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 609, Short.MAX_VALUE)
        );

        MenuFile.setText("Menu");

        MenuQuitter.setText("Exit");
        MenuQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuQuitterActionPerformed(evt);
            }
        });
        MenuFile.add(MenuQuitter);

        BarreMenu.add(MenuFile);

        MenuAjouter.setText("Ajouter");

        AjouterLocal.setText("Ajouter Local");
        AjouterLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AjouterLocalActionPerformed(evt);
            }
        });
        MenuAjouter.add(AjouterLocal);

        BarreMenu.add(MenuAjouter);

        setJMenuBar(BarreMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(AfficheLocaux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(AfficheLocaux, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    
    private void AjouterLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AjouterLocalActionPerformed
        LocalDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_AjouterLocalActionPerformed

    private void LocalOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalOkActionPerformed
        Local loc=new Local(LocalName.getText(), LocalLieu.getText());
        so.ajouterLocal(loc.getNom(), loc.getlocalisation());
       // bdd.AjoutLocal(so.getNom(),loc.getNom(), loc.getlocalisation());
        grilleLocal.setRows(so.getLocaux().size());        
        final Button boutonLocal = new Button(loc.getNom() + " " + "[" + loc.getlocalisation()+ "]");
          boutonLocal.setName(loc.getNom());
          add(boutonLocal);
            boutonLocal.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent arg0){  
                    System.out.println(boutonLocal.getName());;
                    Local loc=so.rechercherLocal(boutonLocal.getName());
                    FenetreSecondaire f=new FenetreSecondaire(loc);
                    f.setVisible(true);                    
                }
                });
            
        LocalName.setText("");
        LocalLieu.setText("");
        LocalDialog.setVisible(false);
    }//GEN-LAST:event_LocalOkActionPerformed

    private void LocalCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalCancelActionPerformed
        LocalName.setText("");
        LocalLieu.setText("");
        LocalDialog.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_LocalCancelActionPerformed
    
    private void LocalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocalNameActionPerformed

    private void LocalLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocalLieuActionPerformed

    private void MenuQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuQuitterActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_MenuQuitterActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Bureau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bureau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bureau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bureau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bureau().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AfficheLocaux;
    private javax.swing.JMenuItem AjouterLocal;
    private javax.swing.JMenuBar BarreMenu;
    private javax.swing.JLabel CreationLocal;
    private javax.swing.JLabel LieuLocal;
    private javax.swing.JButton LocalCancel;
    private javax.swing.JDialog LocalDialog;
    private javax.swing.JTextField LocalLieu;
    private javax.swing.JTextField LocalName;
    private javax.swing.JButton LocalOk;
    private javax.swing.JMenu MenuAjouter;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenuItem MenuQuitter;
    private javax.swing.JLabel NomLocal;
    // End of variables declaration//GEN-END:variables
}
