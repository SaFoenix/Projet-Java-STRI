/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetreLocal;

import java.awt.*;
import java.awt.event.*;
import mesClasses.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author guigui
 */
public class FenetreInterieurLocal extends javax.swing.JInternalFrame {

    private Local loc;
    private MySql bdd;
    private ArrayList<Salle> salles;
    GridBagConstraints gbc = new GridBagConstraints();
    TableauOrdinateur tabOrdinateur;
    TableauTablette tabTablette;
    int positionX = 0;
    int positionY = 0;
    private javax.swing.JInternalFrame afficheInformation;

    /**
     * Creates new form frame1
     */
    public FenetreInterieurLocal(Local loc) {
        /* bdd=new MySql();
         bdd.Connexion();*/
        this.loc = loc;
        salles = loc.getSalles();
        initComponents();

        setTitle(loc.getNom());
        setSize(1350, 750);
        AfficheListeSalle.setBackground(Color.red);
        AfficheListeSalle.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        afficheInformation = new javax.swing.JInternalFrame();

        initialisationMenuSalle();

        fenetreRouteur.setBackground(Color.yellow);
        AfficheListeSalle.setBackground(Color.red);
        add(AfficheListeSalle, BorderLayout.WEST);
        add(fenetreRouteur, BorderLayout.NORTH);

    }

    public void initialisationMenuSalle() {
        for (final Salle sa : salles) //phase cration bouton salle
        {
            final JButton localButton2 = new JButton("numero " + sa.getNumero() + "| etage: " + sa.getEtage());
            localButton2.setName(loc.getNom());
            gbc.gridy = positionY;
            AfficheListeSalle.add(localButton2, gbc);
            positionY++;
            localButton2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    actionMiseEnPlaceBouton(sa);
                }//fin actionPerf
            }
            );
        }
    }//fin init

    private void actionMiseEnPlaceBouton(Salle sa) {
        remove(afficheInformation);
        fenetreRouteur.removeAll();
        ArrayList<Routeur> routeurs = sa.getRouteurs();
        ArrayList<BorneSansFil> bornes = sa.getBornes();
        int positionX = 0;
        int positionY = 0;
        GridBagConstraints gbc = new GridBagConstraints();
        fenetreRouteur.setLayout(new GridBagLayout());
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        for (final Routeur rout : routeurs) {
            final JButton bouton = new JButton("Mac: " + rout.getMac() + "/nom: " + rout.getNom());
            bouton.setName(rout.getMac());
            gbc.gridx = positionX;
            fenetreRouteur.add(bouton, gbc);
            positionX++;
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    afficheInformation.setVisible(false);
                    if (tabOrdinateur != null) {
                        afficheInformation.remove(tabOrdinateur);
                    }
                    if (tabTablette != null) {
                        afficheInformation.remove(tabTablette);
                    }
                    remove(afficheInformation);
                    Ordinateur[] ordi = (rout.retournerOrdinateurs());
                    tabOrdinateur = new TableauOrdinateur(ordi);
                    afficheInformation.add(tabOrdinateur, BorderLayout.CENTER);
                    tabOrdinateur.setVisible(true);
                    afficheInformation.setVisible(true);
                    add(afficheInformation, BorderLayout.CENTER);
                }//fin actionPerf
            }
            );
        }
        for (final BorneSansFil bo : bornes) {
            final JButton bouton = new JButton("Mac: " + bo.getMac() + "/nom: " + bo.getNom());
            bouton.setName(bo.getMac());
            gbc.gridx = positionX;
            fenetreRouteur.add(bouton, gbc);
            positionX++;
            bouton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    afficheInformation.setVisible(false);
                    if (tabTablette != null) {
                        afficheInformation.remove(tabTablette);
                    }
                    if (tabOrdinateur != null) {
                        afficheInformation.remove(tabOrdinateur);
                    }
                    remove(afficheInformation);
                    ArrayList<Tablette> tablet = bo.getTablettes();
                    tabTablette = new TableauTablette(tablet);
                    afficheInformation.add(tabTablette, BorderLayout.CENTER);
                    tabTablette.setVisible(true);
                    afficheInformation.setVisible(true);
                    add(afficheInformation, BorderLayout.CENTER);
                }//fin actionPerf
            }
            );
        }
        setVisible(false);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SalleDialog = new javax.swing.JDialog();
        CreationSalle = new javax.swing.JLabel();
        NumeroSalle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SalleOk = new javax.swing.JButton();
        SalleCancel = new javax.swing.JButton();
        EtageSalle = new javax.swing.JTextField();
        NombreOrdinateurSalle = new javax.swing.JTextField();
        AfficheListeSalle = new javax.swing.JPanel();
        fenetreRouteur = new javax.swing.JPanel();
        barMenu = new javax.swing.JMenuBar();
        barMenuAjouter = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        SalleDialog.setMinimumSize(new java.awt.Dimension(420, 320));

        CreationSalle.setText("Création Salle");

        NumeroSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroSalleActionPerformed(evt);
            }
        });

        jLabel2.setText("numéro");

        jLabel3.setText("étage");

        jLabel4.setText("nombre ordinateur");

        SalleOk.setBackground(new java.awt.Color(51, 255, 51));
        SalleOk.setText("Valider");
        SalleOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalleOkActionPerformed(evt);
            }
        });

        SalleCancel.setBackground(new java.awt.Color(255, 0, 0));
        SalleCancel.setText("Annuler");
        SalleCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalleCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SalleDialogLayout = new javax.swing.GroupLayout(SalleDialog.getContentPane());
        SalleDialog.getContentPane().setLayout(SalleDialogLayout);
        SalleDialogLayout.setHorizontalGroup(
            SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalleDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalleDialogLayout.createSequentialGroup()
                        .addComponent(CreationSalle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(NumeroSalle)
                    .addComponent(EtageSalle)
                    .addComponent(NombreOrdinateurSalle))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SalleDialogLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(SalleOk)
                .addGap(40, 40, 40)
                .addComponent(SalleCancel)
                .addGap(81, 81, 81))
        );
        SalleDialogLayout.setVerticalGroup(
            SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalleDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CreationSalle)
                .addGap(18, 18, 18)
                .addGroup(SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumeroSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(EtageSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NombreOrdinateurSalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(SalleDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalleCancel)
                    .addComponent(SalleOk))
                .addGap(24, 24, 24))
        );

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        AfficheListeSalle.setBackground(new java.awt.Color(153, 255, 255));

        javax.swing.GroupLayout AfficheListeSalleLayout = new javax.swing.GroupLayout(AfficheListeSalle);
        AfficheListeSalle.setLayout(AfficheListeSalleLayout);
        AfficheListeSalleLayout.setHorizontalGroup(
            AfficheListeSalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        AfficheListeSalleLayout.setVerticalGroup(
            AfficheListeSalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(AfficheListeSalle, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout fenetreRouteurLayout = new javax.swing.GroupLayout(fenetreRouteur);
        fenetreRouteur.setLayout(fenetreRouteurLayout);
        fenetreRouteurLayout.setHorizontalGroup(
            fenetreRouteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1122, Short.MAX_VALUE)
        );
        fenetreRouteurLayout.setVerticalGroup(
            fenetreRouteurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(fenetreRouteur, java.awt.BorderLayout.PAGE_START);

        barMenuAjouter.setText("Ajouter");

        jMenuItem1.setText("Ajouter salle");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        barMenuAjouter.add(jMenuItem1);

        barMenu.add(barMenuAjouter);

        setJMenuBar(barMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NumeroSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroSalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroSalleActionPerformed


    private void SalleOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleOkActionPerformed

        final Salle sa = new Salle(Integer.parseInt(NumeroSalle.getText()), Integer.parseInt(EtageSalle.getText()), Integer.parseInt(NombreOrdinateurSalle.getText()));
        loc.ajouterSalle(Integer.parseInt(NumeroSalle.getText()), Integer.parseInt(EtageSalle.getText()), Integer.parseInt(NombreOrdinateurSalle.getText()));
        // bdd.AjoutSalle(loc.getNom(), sa.getNumero(), sa.getEtage(), sa.getNombreOrdinateur());
        final JButton localButton2 = new JButton("numero " + sa.getNumero() + "| etage: " + sa.getEtage());
        localButton2.setName(loc.getNom());
        gbc.gridy = positionY;
        AfficheListeSalle.add(localButton2, gbc);
        positionY++;
        localButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                actionMiseEnPlaceBouton(sa);
            }//fin action
        });
        NumeroSalle.setText("");
        EtageSalle.setText("");
        NombreOrdinateurSalle.setText("");
        SalleDialog.setVisible(false);
        setVisible(false);
        setVisible(true);
    }//GEN-LAST:event_SalleOkActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        SalleDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void SalleCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleCancelActionPerformed
        NumeroSalle.setText("");
        EtageSalle.setText("");
        NombreOrdinateurSalle.setText("");
        SalleDialog.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_SalleCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AfficheListeSalle;
    private javax.swing.JLabel CreationSalle;
    private javax.swing.JTextField EtageSalle;
    private javax.swing.JTextField NombreOrdinateurSalle;
    private javax.swing.JTextField NumeroSalle;
    private javax.swing.JButton SalleCancel;
    private javax.swing.JDialog SalleDialog;
    private javax.swing.JButton SalleOk;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JMenu barMenuAjouter;
    private javax.swing.JPanel fenetreRouteur;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
