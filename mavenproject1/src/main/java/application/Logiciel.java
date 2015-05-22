/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mesClasses.*;
/**
 *
 * @author guigui
 */
public class Logiciel extends javax.swing.JFrame {
    
    Map<String, javax.swing.JTabbedPane> tabsalle = new HashMap<>();
    private static Societe so;
    private static MySql bdd;
    /**
     * Creates new form Main
     */
    public Logiciel() {

        initialisationSociete();
        initComponents();
        creationOngletLocal();   
    }
   
    public void initialisationSociete(){
        bdd=new MySql();
        /*A tester*/
        bdd.Connexion();
        
       // so=bdd.RecupererSociete("STRI");
        System.out.println(so);
        /*supprimer à la fin test*/
        so=new Societe("Stri", "Toulouse");
        so.ajouterLocal("local1", "bordeaux");
        so.ajouterSalle("local1", 0, 1, 15);
        so.ajouterSalle("local1", 0, 2, 20);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        LocalDialog = new javax.swing.JDialog();
        LocalOk = new javax.swing.JButton();
        LocalCancel = new javax.swing.JButton();
        LocalName = new javax.swing.JTextField();
        NomLocal = new javax.swing.JLabel();
        CreationLocal = new javax.swing.JLabel();
        LieuLocal = new javax.swing.JLabel();
        LocalLieu = new javax.swing.JTextField();
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
        RouteurDialog = new javax.swing.JDialog();
        CreationRouteur = new javax.swing.JLabel();
        NomRouteurT = new javax.swing.JTextField();
        NomRouteur = new javax.swing.JLabel();
        MacRouteur = new javax.swing.JLabel();
        MarqueRouteur = new javax.swing.JLabel();
        OsRouteur = new javax.swing.JLabel();
        PortsRouteur = new javax.swing.JLabel();
        MacRouteurT = new javax.swing.JTextField();
        MarqueRouteurT = new javax.swing.JTextField();
        OsRouteurT = new javax.swing.JTextField();
        PortsRouteurT = new javax.swing.JTextField();
        OkRouteur = new javax.swing.JButton();
        CancelRouteur = new javax.swing.JButton();
        AddLocal = new javax.swing.JButton();
        AddRoom = new javax.swing.JButton();
        AddComputer = new javax.swing.JButton();
        Disable = new javax.swing.JButton();
        Update = new javax.swing.JButton();
        OngletLocal = new javax.swing.JTabbedPane();
        AddRouter = new javax.swing.JButton();
        AddBorne = new javax.swing.JButton();
        AddTablet = new javax.swing.JButton();
        STRI = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

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
                            .addComponent(NomLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
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
        SalleOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalleOkMouseClicked(evt);
            }
        });
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

        EtageSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtageSalleActionPerformed(evt);
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

        CreationRouteur.setText("Création Routeur");

        NomRouteur.setText("Nom");

        MacRouteur.setText("MAC");

        MarqueRouteur.setText("Marque");

        OsRouteur.setText("OS");

        PortsRouteur.setText("Nombre de ports");

        OkRouteur.setBackground(new java.awt.Color(0, 255, 0));
        OkRouteur.setText("Valider");
        OkRouteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkRouteurActionPerformed(evt);
            }
        });

        CancelRouteur.setBackground(new java.awt.Color(255, 0, 0));
        CancelRouteur.setText("Annuler");

        javax.swing.GroupLayout RouteurDialogLayout = new javax.swing.GroupLayout(RouteurDialog.getContentPane());
        RouteurDialog.getContentPane().setLayout(RouteurDialogLayout);
        RouteurDialogLayout.setHorizontalGroup(
            RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteurDialogLayout.createSequentialGroup()
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(CreationRouteur))
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(RouteurDialogLayout.createSequentialGroup()
                                .addComponent(PortsRouteur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(PortsRouteurT, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(RouteurDialogLayout.createSequentialGroup()
                                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MarqueRouteur)
                                    .addComponent(OsRouteur))
                                .addGap(54, 54, 54)
                                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(OsRouteurT)
                                    .addComponent(MarqueRouteurT)))
                            .addGroup(RouteurDialogLayout.createSequentialGroup()
                                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MacRouteur)
                                    .addComponent(NomRouteur))
                                .addGap(68, 68, 68)
                                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NomRouteurT, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(MacRouteurT)))))
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(OkRouteur)
                        .addGap(66, 66, 66)
                        .addComponent(CancelRouteur)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        RouteurDialogLayout.setVerticalGroup(
            RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteurDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CreationRouteur)
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomRouteurT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomRouteur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MacRouteur)
                    .addComponent(MacRouteurT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MarqueRouteur)
                    .addComponent(MarqueRouteurT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OsRouteur)
                    .addComponent(OsRouteurT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PortsRouteur)
                    .addComponent(PortsRouteurT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkRouteur)
                    .addComponent(CancelRouteur))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1300, 730));

        AddLocal.setBackground(new java.awt.Color(0, 204, 204));
        AddLocal.setText("Ajouter Local");
        AddLocal.setFocusable(false);
        AddLocal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AddLocal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, AddLocal, org.jdesktop.beansbinding.ELProperty.create("${componentPopupMenu.componentPopupMenu}"), AddLocal, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

        AddLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddLocalActionPerformed(evt);
            }
        });

        AddRoom.setBackground(new java.awt.Color(0, 204, 204));
        AddRoom.setText("Ajouter Salle");
        AddRoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                AddRoomStateChanged(evt);
            }
        });
        AddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRoomActionPerformed(evt);
            }
        });

        AddComputer.setBackground(new java.awt.Color(0, 204, 204));
        AddComputer.setText("Ajouter Ordinateur");

        Disable.setBackground(new java.awt.Color(0, 204, 204));
        Disable.setText("Désactiver");
        Disable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisableActionPerformed(evt);
            }
        });

        Update.setBackground(new java.awt.Color(0, 204, 204));
        Update.setText("Mettre à jour");

        OngletLocal.setToolTipText("");
        OngletLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OngletLocalMouseClicked(evt);
            }
        });

        AddRouter.setBackground(new java.awt.Color(0, 204, 204));
        AddRouter.setText("Ajouter Routeur");
        AddRouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRouterActionPerformed(evt);
            }
        });

        AddBorne.setBackground(new java.awt.Color(0, 204, 204));
        AddBorne.setText("Ajouter Borne");

        AddTablet.setBackground(new java.awt.Color(0, 204, 204));
        AddTablet.setText("Ajouter Tablette");

        STRI.setText("STRI");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AddComputer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddLocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddRouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddBorne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AddTablet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Disable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(STRI)))
                .addGap(12, 12, 12)
                .addComponent(OngletLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OngletLocal)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(STRI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddLocal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddRoom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddRouter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddComputer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddBorne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AddTablet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Disable)
                        .addGap(0, 238, Short.MAX_VALUE)))
                .addContainerGap())
        );

        /* Tous les boutons sauf "ajouter local" sont désactivés de base, et ne seront activés que par intermédiaire d'événement */
        AddRoom.setEnabled(false);
        AddComputer.setEnabled(false);
        Disable.setEnabled(false);
        Update.setEnabled(false);
        AddRouter.setEnabled(false);
        AddBorne.setEnabled(false);
        AddTablet.setEnabled(false);

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddLocalActionPerformed
        LocalDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_AddLocalActionPerformed

    private void DisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DisableActionPerformed

    private void LocalLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocalLieuActionPerformed

    private void LocalOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalOkActionPerformed
        JTabbedPane testlocal = new JTabbedPane();
        Local loc =new Local(LocalName.getText(), LocalLieu.getText());
        OngletLocal.addTab(loc.getNom()+" ["+loc.getlocalisation()+"]", testlocal);
        so.ajouterLocal(loc.getNom(), loc.getlocalisation());
        LocalName.setText("");
        LocalLieu.setText("");
        LocalDialog.setVisible(false);
        AddRoom.setEnabled(true);
        // OngletLocal.setToolTipText("LocalLieu");
        bdd.AjoutLocal(so.getNom(),loc.getNom(), loc.getlocalisation());
    }//GEN-LAST:event_LocalOkActionPerformed

    private void AddRouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRouterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddRouterActionPerformed

    private void LocalNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LocalNameActionPerformed

    private void LocalCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LocalCancelActionPerformed
        LocalName.setText("");
        LocalLieu.setText("");
        LocalDialog.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_LocalCancelActionPerformed

    private void AddRoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_AddRoomStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_AddRoomStateChanged

    private void AddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddRoomActionPerformed
        SalleDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_AddRoomActionPerformed

    private void SalleOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalleOkMouseClicked
        JPanel testsalle = new JPanel();
        String nomlocal = OngletLocal.getTitleAt(OngletLocal.getSelectedIndex());
        if (!tabsalle.containsKey(nomlocal)) {
            JTabbedPane o = new JTabbedPane();
            ((JTabbedPane) OngletLocal.getSelectedComponent()).add(o);
            tabsalle.put(nomlocal, o);
        }
         Salle sa=new Salle(Integer.parseInt(NumeroSalle.getText()),Integer.parseInt(EtageSalle.getText()),Integer.parseInt(NombreOrdinateurSalle.getText()));
        tabsalle.get(nomlocal).addTab("etage:"+sa.getEtage()+"|numero:"+sa.getNumero(), testsalle);
        bdd.AjoutSalle(nomlocal,sa.getNumero(),sa.getNombreOrdinateur(),sa.getEtage());
        NumeroSalle.setText("");
        EtageSalle.setText("");
        NombreOrdinateurSalle.setText("");
        SalleDialog.setVisible(false);                
    }//GEN-LAST:event_SalleOkMouseClicked

    private void NumeroSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroSalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroSalleActionPerformed

    private void EtageSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtageSalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EtageSalleActionPerformed

    private void SalleCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleCancelActionPerformed
        NumeroSalle.setText("");
        EtageSalle.setText("");
        NombreOrdinateurSalle.setText("");
        SalleDialog.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_SalleCancelActionPerformed

    private void SalleOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleOkActionPerformed
        SalleDialog.setVisible(false);
        AddComputer.setEnabled(true);
        Disable.setEnabled(true);
        Update.setEnabled(true);
        AddRouter.setEnabled(true);
        AddBorne.setEnabled(true);
        AddTablet.setEnabled(true);        // TODO add your handling code here:
    }//GEN-LAST:event_SalleOkActionPerformed

    private void OngletLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OngletLocalMouseClicked
        AddRoom.setEnabled(true);
        AddComputer.setEnabled(false);
        Disable.setEnabled(false);
        Update.setEnabled(false);
        AddRouter.setEnabled(false);
        AddBorne.setEnabled(false);
        AddTablet.setEnabled(false);  
    }//GEN-LAST:event_OngletLocalMouseClicked
/*
    private void OkRouteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkRouteurActionPerformed
        JPanel testrouteur = new JPanel();
        
        String nomsalle = o.getTitleAt(o.getSelectedIndex());
                
                
         String nomlocal = OngletLocal.getTitleAt(OngletLocal.getSelectedIndex());
        if (!tabsalle.containsKey(nomlocal)) {
            JTabbedPane o = new JTabbedPane();
            ((JTabbedPane) OngletLocal.getSelectedComponent()).add(o);
            tabsalle.put(nomlocal, o);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_OkRouteurActionPerformed
*/                            
           private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {                                                  
/*
        AddComputer.setEnabled(true);
        Disable.setEnabled(true);
        Update.setEnabled(true);
        AddRouter.setEnabled(true);
        AddBorne.setEnabled(true);
        AddTablet.setEnabled(true);    // TODO add your handling code here:
               // TODO add your handling code here: */
    }                                         
                          
  
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logiciel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Logiciel().setVisible(true);                
            }
        });
    }
    
    public void creationOngletLocal(){
        ArrayList <Local>locaux=so.getLocaux();
        for(Local loc : locaux){
            JTabbedPane localOnglet = new JTabbedPane();
            OngletLocal.addTab(loc.getNom()+" ["+loc.getlocalisation()+"]", localOnglet);
            ArrayList<Salle> salles=loc.getSalles();
            for (Salle sa : salles) {
                JPanel testsalle = new JPanel();
                String nomlocal = loc.getNom();
                if (!tabsalle.containsKey(nomlocal)) {
                    JTabbedPane o = new JTabbedPane();
                    ((JTabbedPane) OngletLocal.getSelectedComponent()).add(o);
                    tabsalle.put(nomlocal, o);
                }
                tabsalle.get(nomlocal).addTab("etage:"+sa.getEtage()+"|numero:"+sa.getNumero(), testsalle);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBorne;
    private javax.swing.JButton AddComputer;
    private javax.swing.JButton AddLocal;
    private javax.swing.JButton AddRoom;
    private javax.swing.JButton AddRouter;
    private javax.swing.JButton AddTablet;
    private javax.swing.JButton CancelRouteur;
    private javax.swing.JLabel CreationLocal;
    private javax.swing.JLabel CreationRouteur;
    private javax.swing.JLabel CreationSalle;
    private javax.swing.JButton Disable;
    private javax.swing.JTextField EtageSalle;
    private javax.swing.JLabel LieuLocal;
    private javax.swing.JButton LocalCancel;
    private javax.swing.JDialog LocalDialog;
    private javax.swing.JTextField LocalLieu;
    private javax.swing.JTextField LocalName;
    private javax.swing.JButton LocalOk;
    private javax.swing.JLabel MacRouteur;
    private javax.swing.JTextField MacRouteurT;
    private javax.swing.JLabel MarqueRouteur;
    private javax.swing.JTextField MarqueRouteurT;
    private javax.swing.JLabel NomLocal;
    private javax.swing.JLabel NomRouteur;
    private javax.swing.JTextField NomRouteurT;
    private javax.swing.JTextField NombreOrdinateurSalle;
    private javax.swing.JTextField NumeroSalle;
    private javax.swing.JButton OkRouteur;
    private javax.swing.JTabbedPane OngletLocal;
    private javax.swing.JLabel OsRouteur;
    private javax.swing.JTextField OsRouteurT;
    private javax.swing.JLabel PortsRouteur;
    private javax.swing.JTextField PortsRouteurT;
    private javax.swing.JDialog RouteurDialog;
    private javax.swing.JLabel STRI;
    private javax.swing.JButton SalleCancel;
    private javax.swing.JDialog SalleDialog;
    private javax.swing.JButton SalleOk;
    private javax.swing.JButton Update;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
