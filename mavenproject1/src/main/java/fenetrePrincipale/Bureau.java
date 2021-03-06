/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetrePrincipale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import mesClasses.*;

/**
 *
 * @author STRI_JAVA
 */
public class Bureau extends javax.swing.JFrame {

    private Societe so;
    private MySql bdd;
    private ArrayList<Local> locaux;
    JButton localButton;
    JPanel afficheLesLocaux;
    GridBagConstraints gbc = new GridBagConstraints();
    int positionX = 0;
    int positionY = 0;

    /**
     * Creates new form Bureau
     */
    public Bureau() {
        /*config boite de dialogue*/
        LocalDialog = new javax.swing.JDialog();
        LocalOk = new javax.swing.JButton();
        LocalCancel = new javax.swing.JButton();
        LocalName = new javax.swing.JTextField();
        NomLocal = new javax.swing.JLabel();
        CreationLocal = new javax.swing.JLabel();
        LieuLocal = new javax.swing.JLabel();
        LocalLieu = new javax.swing.JTextField();

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

        bdd = new MySql();
        bdd.Connexion();
        so = bdd.RecupererSociete("STRI");
        locaux = bdd.RecupererLocal(so.getNom());
        for (Local loc : locaux) {
            so.ajouterLocal(loc.getNom(), loc.getlocalisation());
        }
        for (Local loc : locaux) {
            ArrayList<Salle> salles;
            salles = bdd.RecupererSalle(loc.getNom());
            for (Salle sa : salles) {
                so.ajouterSalle(loc.getNom(), sa.getNumero(), sa.getEtage(), sa.getNombreOrdinateur());

                ArrayList<Routeur> routeurs;
                routeurs = bdd.RecupererRouteur(sa.getNumero());
                for (Routeur ro : routeurs) {

                    so.ajouterRouteurSalle(ro, sa.getEtage(), sa.getNumero(), loc.getNom());
                    ArrayList<Ordinateur> ordinateurs;
                    ordinateurs = bdd.RecupererOrdinateur(sa.getNumero());
                    for (Ordinateur ordi : ordinateurs) {
                        so.connecterOrdinateur(ordi, sa.getEtage(), sa.getNumero(), ro.getMac(), loc.getNom());
                    }
                }
                ArrayList<BorneSansFil> bornes = bdd.RecupererBorne(sa.getNumero());
                for (BorneSansFil botemp : bornes) {
                    so.ajouterBorneSansFil(botemp, loc.getNom(), sa.getEtage(), sa.getNumero());
                    ArrayList<Tablette> tablettes;
                    tablettes = bdd.RecupererTablette(sa.getNumero());
                    for (Tablette tab : tablettes) {
                        so.connecterTablette(tab, loc.getNom(), sa.getEtage(), sa.getNumero(), botemp.getMac());
                    }
                }
            }
        }
        locaux = so.getLocaux();

        /*init fenetre principale */
        setTitle("Societe " + so.getNom());
        setSize(960, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        /*init bar menu*/
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu ajouter = new JMenu("Ajouter");
        menuBar.add(ajouter);
        JMenuItem ajouterLocal = new JMenuItem("ajouter Local");
        ajouter.add(ajouterLocal);
        ajouterLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LocalDialogActionPerformed(evt);
            }
        });

        /*init menu local*/
        afficheLesLocaux = new JPanel();
        afficheLesLocaux.setBackground(Color.black);
        afficheLesLocaux.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        initialiseInterface();
        add(afficheLesLocaux, BorderLayout.PAGE_START);
    }

    public void initialiseInterface() {
        for (Local loc : locaux) {
            final JButton localButton2 = new JButton(loc.getNom() + " " + "[" + loc.getlocalisation() + "]");
            localButton2.setName(loc.getNom());
            gbc.gridy = positionY;
            afficheLesLocaux.add(localButton2, gbc);
            positionY++;
            localButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    evenementBoutonLocal(so, localButton2.getName());
                }
            });
        }
    }

    private void evenementBoutonLocal(Societe so, String locNom) {
        Local loc = so.rechercherLocal(locNom);
        FenetreSecondaire f = new FenetreSecondaire(loc);
        f.setVisible(true);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void LocalDialogActionPerformed(java.awt.event.ActionEvent evt) {
        LocalDialog.setVisible(true);
        // TODO add your handling code here:
    }
    private void LocalOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalOkActionPerformed
        Local loc = new Local(LocalName.getText(), LocalLieu.getText());
        so.ajouterLocal(loc.getNom(), loc.getlocalisation());
        bdd.AjoutLocal(so.getNom(), loc.getNom(), loc.getlocalisation());
        final JButton localButton2 = new JButton(loc.getNom() + " " + "[" + loc.getlocalisation() + "]");
        localButton2.setName(loc.getNom());
        gbc.gridy = positionY;
        afficheLesLocaux.add(localButton2, gbc);
        positionY++;
        localButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                evenementBoutonLocal(so, localButton2.getName());
            }
        });

        LocalName.setText("");
        LocalLieu.setText("");
        LocalDialog.setVisible(false);
        this.setVisible(false); //this will close frame i.e. NewJFrame
        this.setVisible(true);
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
                new Bureau();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CreationLocal;
    private javax.swing.JLabel LieuLocal;
    private javax.swing.JButton LocalCancel;
    private javax.swing.JDialog LocalDialog;
    private javax.swing.JTextField LocalLieu;
    private javax.swing.JTextField LocalName;
    private javax.swing.JButton LocalOk;
    private javax.swing.JLabel NomLocal;
    // End of variables declaration//GEN-END:variables
}
