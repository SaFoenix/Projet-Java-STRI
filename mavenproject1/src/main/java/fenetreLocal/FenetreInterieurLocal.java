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

/**
 *
 * @author guigui
 */
public class FenetreInterieurLocal extends javax.swing.JInternalFrame {

    private Local loc;
    private MySql bdd = new MySql();
    private ArrayList<Salle> salles;
    private Salle salleTemp;
    private Routeur routeurTemp;
    private BorneSansFil borneTemp;
    GridBagConstraints gbc = new GridBagConstraints();
    TableauOrdinateur tabOrdinateur;
    TableauTablette tabTablette;
    TableauEquipement tabEquipement;
    int positionX = 0;
    int positionY = 0;
    private javax.swing.JInternalFrame afficheInformation;
    private javax.swing.JInternalFrame afficheInformationEquipementRacine;

    /**
     * Creates new form frame1
     */
    public FenetreInterieurLocal(Local loc) {
        bdd = new MySql();
        bdd.Connexion();
        this.loc = loc;
        salles = loc.getSalles();
        initComponents();
        menuAjouterRouteur.setEnabled(false);
        menuAjouterBorne.setEnabled(false);
        menuAjouterOrdinateur.setEnabled(false);
        menuAjouterTablette.setEnabled(false);
        setTitle(loc.getNom());
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) tailleEcran.getWidth(), (int) tailleEcran.getHeight());

        AfficheListeSalle.setBackground(Color.white);
        AfficheListeSalle.setLayout(new GridBagLayout());

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        afficheInformation = new javax.swing.JInternalFrame();
        afficheInformation.setSize(600, 300);
        //afficheInformation.setAutoscrolls(true);

        afficheInformationEquipementRacine = new javax.swing.JInternalFrame();
        afficheInformationEquipementRacine.setSize(600, 300);
        initialisationMenuSalle();

        fenetreRouteur.setBackground(Color.white);
        AfficheListeSalle.setBackground(Color.black);
        add(AfficheListeSalle, BorderLayout.WEST);
        add(fenetreRouteur, BorderLayout.NORTH);
    }

    public void initialisationMenuSalle() {
        for (final Salle sa : salles) //phase création bouton salle
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
        salleTemp = sa;
        menuAjouterRouteur.setEnabled(true);
        menuAjouterBorne.setEnabled(true);
        menuAjouterOrdinateur.setEnabled(false);
        menuAjouterTablette.setEnabled(false);
        remove(afficheInformation);
        remove(afficheInformationEquipementRacine);
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
                    routeurTemp = rout;
                    menuAjouterOrdinateur.setEnabled(true);
                    menuAjouterTablette.setEnabled(false);
                    afficheInformationEquipementRacine.setVisible(false);
                    afficheInformation.setVisible(false);
                    if (tabOrdinateur != null) {
                        afficheInformation.remove(tabOrdinateur);
                    }
                    if (tabTablette != null) {
                        afficheInformation.remove(tabTablette);
                    }
                    if (tabEquipement != null) {
                        afficheInformationEquipementRacine.remove(tabEquipement);
                    }
                    remove(afficheInformationEquipementRacine);
                    remove(afficheInformation);
                    tabEquipement = new TableauEquipement(rout);
                    tabOrdinateur = new TableauOrdinateur(rout);
                    afficheInformationEquipementRacine.add(tabEquipement, BorderLayout.NORTH);
                    afficheInformation.add(tabOrdinateur, BorderLayout.EAST);
                    tabEquipement.setVisible(true);
                    tabOrdinateur.setVisible(true);
                    afficheInformation.setVisible(true);
                    afficheInformationEquipementRacine.setVisible(true);
                    afficheBoutonUpdateSuppr();
                    add(afficheInformation, BorderLayout.EAST);
                    add(afficheInformationEquipementRacine, BorderLayout.CENTER);
                    pack();
                    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                    setSize((int) tailleEcran.getWidth(), (int) tailleEcran.getHeight());
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
                    borneTemp = bo;
                    menuAjouterTablette.setEnabled(true);
                    menuAjouterOrdinateur.setEnabled(false);
                    afficheInformationEquipementRacine.setVisible(false);
                    afficheInformation.setVisible(false);
                    if (tabTablette != null) {
                        afficheInformation.remove(tabTablette);
                    }
                    if (tabOrdinateur != null) {
                        afficheInformation.remove(tabOrdinateur);
                    }
                    if (tabEquipement != null) {
                        afficheInformationEquipementRacine.remove(tabEquipement);
                    }
                    remove(afficheInformationEquipementRacine);
                    remove(afficheInformation);
                    tabTablette = new TableauTablette(bo);
                    tabEquipement = new TableauEquipement(bo);
                    afficheInformationEquipementRacine.add(tabEquipement, BorderLayout.NORTH);
                    afficheInformation.add(tabTablette, BorderLayout.EAST);
                    tabTablette.setVisible(true);
                    tabEquipement.setVisible(true);
                    afficheInformation.setVisible(true);
                    afficheInformationEquipementRacine.setVisible(true);
                    afficheBoutonUpdateSuppr();
                    add(afficheInformation, BorderLayout.EAST);

                    add(afficheInformationEquipementRacine, BorderLayout.CENTER);
                    pack();
                    Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
                    setSize((int) tailleEcran.getWidth(), (int) tailleEcran.getHeight());
                }//fin actionPerf
            }
            );
        }
        setVisible(false);
        setVisible(true);
    }

    public void afficheBoutonUpdateSuppr() {
        javax.swing.JPanel afficheInformationEquipementRacinebis;
        afficheInformationEquipementRacinebis = new javax.swing.JPanel();
        afficheInformationEquipementRacinebis.setSize(10, 10);
        GridBagConstraints gbc1 = new GridBagConstraints();
        afficheInformationEquipementRacinebis.setLayout(new GridBagLayout());
        gbc1.insets = new Insets(5, 5, 5, 5);
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        JButton updateOrdiButton2 = new JButton("Update");
        JButton supprOrdiButton2 = new JButton("supprimer");
        updateOrdiButton2.setVisible(true);

        afficheInformationEquipementRacinebis.add(updateOrdiButton2, gbc1);
        updateOrdiButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                updateOrdiButton2ActionPerformed();
            }//fin actionPerf
        }
        );
        gbc1.gridy++;
        supprOrdiButton2.setVisible(true);
        supprOrdiButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                supprOrdiButton2ActionPerformed();
            }//fin actionPerf
        }
        );
        afficheInformationEquipementRacinebis.add(supprOrdiButton2, gbc1);
        afficheInformationEquipementRacinebis.setVisible(true);
        afficheInformationEquipementRacine.add(afficheInformationEquipementRacinebis, BorderLayout.CENTER);
    }

    private void updateOrdiButton2ActionPerformed() {
        UpdateDialog.setVisible(true);
    }

    private void supprOrdiButton2ActionPerformed() {
        SupprDialog.setVisible(true);
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
        RouteurDialog = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        OkRouteur = new javax.swing.JButton();
        CancelRouteur = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NomRouteur = new javax.swing.JTextField();
        MacRouteur = new javax.swing.JTextField();
        NomOs = new javax.swing.JTextField();
        MarqueRouteur = new javax.swing.JTextField();
        PowerRouteur = new javax.swing.JTextField();
        PortRouteur = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        VersionOs = new javax.swing.JTextField();
        BorneDialog = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        OkBorne = new javax.swing.JButton();
        CancelBorne = new javax.swing.JButton();
        NomBorne = new javax.swing.JTextField();
        MacBorne = new javax.swing.JTextField();
        MarqueBorne = new javax.swing.JTextField();
        PowerBorne = new javax.swing.JTextField();
        NomOsBorne = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        VersionOsBorne = new javax.swing.JTextField();
        OrdinateurDialog = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        NomOrdi = new javax.swing.JTextField();
        MacOrdi = new javax.swing.JTextField();
        NomOsOrdi = new javax.swing.JTextField();
        MarqueOrdi = new javax.swing.JTextField();
        PowerOrdi = new javax.swing.JTextField();
        OkOrdi = new javax.swing.JButton();
        CancelOrdi = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        CpuOrdi = new javax.swing.JTextField();
        GpuOrdi = new javax.swing.JTextField();
        RamOrdi = new javax.swing.JTextField();
        HddOrdi = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        VersionOsOrdi = new javax.swing.JTextField();
        TabletteDialog = new javax.swing.JDialog();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        NomTablette = new javax.swing.JTextField();
        MacTablette = new javax.swing.JTextField();
        NomOsTablette = new javax.swing.JTextField();
        MarqueTablette = new javax.swing.JTextField();
        PowerTablette = new javax.swing.JTextField();
        CapaTablette = new javax.swing.JTextField();
        ModeleTablette = new javax.swing.JTextField();
        OkTablette = new javax.swing.JButton();
        CancelTablette = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        VersionOsTablette = new javax.swing.JTextField();
        UpdateDialog = new javax.swing.JDialog();
        OkUpdateOrdi = new javax.swing.JButton();
        CancelUpdateOrdi = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        UpdateMacOrdi = new javax.swing.JTextField();
        UpdateNomOsOrdi = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        UpdateVersionOsOrdi = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        SupprDialog = new javax.swing.JDialog();
        OkSuppr = new javax.swing.JButton();
        CancelSuppr = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        SupprMac = new javax.swing.JTextField();
        SureteDialog = new javax.swing.JDialog();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        OkSurete = new javax.swing.JButton();
        CancelSurete = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        AfficheListeSalle = new javax.swing.JPanel();
        fenetreRouteur = new javax.swing.JPanel();
        barMenu = new javax.swing.JMenuBar();
        barMenuAjouter = new javax.swing.JMenu();
        MenuAjouterSalle = new javax.swing.JMenuItem();
        menuAjouterRouteur = new javax.swing.JMenuItem();
        menuAjouterBorne = new javax.swing.JMenuItem();
        menuAjouterOrdinateur = new javax.swing.JMenuItem();
        menuAjouterTablette = new javax.swing.JMenuItem();

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

        RouteurDialog.setMinimumSize(new java.awt.Dimension(700, 500));

        jLabel1.setText("Création routeur");

        OkRouteur.setBackground(new java.awt.Color(0, 255, 0));
        OkRouteur.setText("Valider");
        OkRouteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkRouteurActionPerformed(evt);
            }
        });

        CancelRouteur.setBackground(new java.awt.Color(255, 0, 0));
        CancelRouteur.setText("Annuler");
        CancelRouteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelRouteurActionPerformed(evt);
            }
        });

        jLabel5.setText("Nom");

        jLabel6.setText("MAC");

        jLabel7.setText("Nom OS");

        jLabel8.setText("Marque");

        jLabel9.setText("Power");

        jLabel10.setText("Nombre de ports");

        jLabel23.setText("Version OS");

        javax.swing.GroupLayout RouteurDialogLayout = new javax.swing.GroupLayout(RouteurDialog.getContentPane());
        RouteurDialog.getContentPane().setLayout(RouteurDialogLayout);
        RouteurDialogLayout.setHorizontalGroup(
            RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RouteurDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
            .addGroup(RouteurDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel23))
                        .addGap(71, 71, 71)
                        .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(RouteurDialogLayout.createSequentialGroup()
                                .addComponent(OkRouteur)
                                .addGap(35, 35, 35)
                                .addComponent(CancelRouteur))
                            .addComponent(NomRouteur)
                            .addComponent(MacRouteur)
                            .addComponent(NomOs)
                            .addComponent(VersionOs)))
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(43, 43, 43)
                        .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PowerRouteur)
                            .addComponent(PortRouteur)
                            .addComponent(MarqueRouteur, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        RouteurDialogLayout.setVerticalGroup(
            RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteurDialogLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(NomRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(MacRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(NomOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(VersionOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(MarqueRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(PowerRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(PortRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkRouteur)
                    .addComponent(CancelRouteur))
                .addContainerGap())
        );

        BorneDialog.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel11.setText("Création Borne");

        jLabel12.setText("Nom");

        jLabel13.setText("MAC");

        jLabel14.setText("Marque");

        jLabel15.setText("Power");

        jLabel16.setText("Nom OS");

        OkBorne.setBackground(new java.awt.Color(51, 255, 0));
        OkBorne.setText("Valider");
        OkBorne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkBorneActionPerformed(evt);
            }
        });

        CancelBorne.setBackground(new java.awt.Color(255, 0, 0));
        CancelBorne.setText("Annuler");
        CancelBorne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelBorneActionPerformed(evt);
            }
        });

        jLabel24.setText("Version OS");

        javax.swing.GroupLayout BorneDialogLayout = new javax.swing.GroupLayout(BorneDialog.getContentPane());
        BorneDialog.getContentPane().setLayout(BorneDialogLayout);
        BorneDialogLayout.setHorizontalGroup(
            BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BorneDialogLayout.createSequentialGroup()
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BorneDialogLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel11))
                    .addGroup(BorneDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel24))
                        .addGap(24, 24, 24)
                        .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NomOsBorne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(PowerBorne)
                            .addComponent(MarqueBorne)
                            .addComponent(MacBorne)
                            .addComponent(NomBorne)
                            .addGroup(BorneDialogLayout.createSequentialGroup()
                                .addComponent(OkBorne)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelBorne))
                            .addComponent(VersionOsBorne))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        BorneDialogLayout.setVerticalGroup(
            BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BorneDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(NomBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(MacBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(MarqueBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(PowerBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(NomOsBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(VersionOsBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkBorne)
                    .addComponent(CancelBorne))
                .addContainerGap())
        );

        OrdinateurDialog.setMinimumSize(new java.awt.Dimension(700, 600));

        jLabel17.setText("Création Ordinateur");

        jLabel18.setText("Nom");

        jLabel19.setText("MAC");

        jLabel20.setText("Nom OS");

        jLabel21.setText("Marque");

        jLabel22.setText("Power");

        NomOrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomOrdiActionPerformed(evt);
            }
        });

        OkOrdi.setBackground(new java.awt.Color(0, 255, 0));
        OkOrdi.setText("Valider");
        OkOrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkOrdiActionPerformed(evt);
            }
        });

        CancelOrdi.setBackground(new java.awt.Color(255, 0, 0));
        CancelOrdi.setText("Cancel");
        CancelOrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelOrdiActionPerformed(evt);
            }
        });

        jLabel35.setText("CPU");

        jLabel36.setText("GPU");

        jLabel37.setText("RAM");

        jLabel38.setText("HDD");

        jLabel25.setText("Version OS");

        javax.swing.GroupLayout OrdinateurDialogLayout = new javax.swing.GroupLayout(OrdinateurDialog.getContentPane());
        OrdinateurDialog.getContentPane().setLayout(OrdinateurDialogLayout);
        OrdinateurDialogLayout.setHorizontalGroup(
            OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrdinateurDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OrdinateurDialogLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(VersionOsOrdi))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OrdinateurDialogLayout.createSequentialGroup()
                        .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PowerOrdi)
                            .addComponent(CpuOrdi)
                            .addComponent(GpuOrdi)
                            .addComponent(RamOrdi)
                            .addComponent(HddOrdi)
                            .addComponent(MarqueOrdi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OrdinateurDialogLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(OkOrdi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(CancelOrdi)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OrdinateurDialogLayout.createSequentialGroup()
                        .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomOrdi)
                            .addComponent(MacOrdi)
                            .addComponent(NomOsOrdi)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, OrdinateurDialogLayout.createSequentialGroup()
                        .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(163, 163, 163))
            .addGroup(OrdinateurDialogLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OrdinateurDialogLayout.setVerticalGroup(
            OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdinateurDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(NomOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(MacOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(NomOsOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(VersionOsOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(MarqueOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(PowerOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(CpuOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(GpuOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(RamOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(HddOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkOrdi)
                    .addComponent(CancelOrdi))
                .addGap(39, 39, 39))
        );

        TabletteDialog.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel27.setText("Création Tablette");

        jLabel28.setText("Nom");

        jLabel29.setText("MAC");

        jLabel30.setText("Nom OS");

        jLabel31.setText("Marque");

        jLabel32.setText("Power");

        jLabel33.setText("Capacité");

        jLabel34.setText("Modèle");

        MacTablette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MacTabletteActionPerformed(evt);
            }
        });

        OkTablette.setBackground(new java.awt.Color(0, 255, 0));
        OkTablette.setText("Valider");
        OkTablette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkTabletteActionPerformed(evt);
            }
        });

        CancelTablette.setBackground(new java.awt.Color(255, 0, 0));
        CancelTablette.setText("Annuler");
        CancelTablette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelTabletteActionPerformed(evt);
            }
        });

        jLabel48.setText("Version OS");

        javax.swing.GroupLayout TabletteDialogLayout = new javax.swing.GroupLayout(TabletteDialog.getContentPane());
        TabletteDialog.getContentPane().setLayout(TabletteDialogLayout);
        TabletteDialogLayout.setHorizontalGroup(
            TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabletteDialogLayout.createSequentialGroup()
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabletteDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel48))
                        .addGap(24, 24, 24)
                        .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(TabletteDialogLayout.createSequentialGroup()
                                .addComponent(OkTablette)
                                .addGap(18, 18, 18)
                                .addComponent(CancelTablette))
                            .addComponent(NomTablette)
                            .addComponent(MacTablette)
                            .addComponent(NomOsTablette)
                            .addComponent(MarqueTablette)
                            .addComponent(PowerTablette)
                            .addComponent(CapaTablette)
                            .addComponent(ModeleTablette)
                            .addComponent(VersionOsTablette)))
                    .addGroup(TabletteDialogLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel27)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        TabletteDialogLayout.setVerticalGroup(
            TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabletteDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(NomTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(MacTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(NomOsTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(VersionOsTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(MarqueTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(PowerTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(CapaTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(ModeleTablette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelTablette)
                    .addComponent(OkTablette))
                .addContainerGap())
        );

        UpdateDialog.setMinimumSize(new java.awt.Dimension(450, 300));

        OkUpdateOrdi.setBackground(new java.awt.Color(0, 255, 0));
        OkUpdateOrdi.setText("Valider");
        OkUpdateOrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkUpdateOrdiActionPerformed(evt);
            }
        });

        CancelUpdateOrdi.setBackground(new java.awt.Color(255, 0, 0));
        CancelUpdateOrdi.setText("Annuler");
        CancelUpdateOrdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelUpdateOrdiActionPerformed(evt);
            }
        });

        jLabel26.setText("Update");

        jLabel39.setText("MAC*");

        jLabel40.setText("Nom OS");

        UpdateMacOrdi.setToolTipText("test");

        jLabel41.setText("Version OS");

        jLabel42.setText("*La MAC doit exister");

        javax.swing.GroupLayout UpdateDialogLayout = new javax.swing.GroupLayout(UpdateDialog.getContentPane());
        UpdateDialog.getContentPane().setLayout(UpdateDialogLayout);
        UpdateDialogLayout.setHorizontalGroup(
            UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateDialogLayout.createSequentialGroup()
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateDialogLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(OkUpdateOrdi)
                        .addGap(39, 39, 39)
                        .addComponent(CancelUpdateOrdi))
                    .addGroup(UpdateDialogLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel26))
                    .addGroup(UpdateDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40)
                            .addComponent(jLabel39))
                        .addGap(18, 18, 18)
                        .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(UpdateMacOrdi, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                                .addComponent(UpdateNomOsOrdi)
                                .addComponent(UpdateVersionOsOrdi)))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        UpdateDialogLayout.setVerticalGroup(
            UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateDialogLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel26)
                .addGap(18, 18, 18)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(UpdateMacOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(UpdateNomOsOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(UpdateVersionOsOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkUpdateOrdi)
                    .addComponent(CancelUpdateOrdi))
                .addContainerGap())
        );

        SupprDialog.setMinimumSize(new java.awt.Dimension(450, 300));

        OkSuppr.setBackground(new java.awt.Color(0, 255, 0));
        OkSuppr.setText("Valider");
        OkSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkSupprActionPerformed(evt);
            }
        });

        CancelSuppr.setBackground(new java.awt.Color(255, 0, 0));
        CancelSuppr.setText("Cancel");
        CancelSuppr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelSupprActionPerformed(evt);
            }
        });

        jLabel43.setText("Suppression");

        jLabel44.setText("MAC");

        javax.swing.GroupLayout SupprDialogLayout = new javax.swing.GroupLayout(SupprDialog.getContentPane());
        SupprDialog.getContentPane().setLayout(SupprDialogLayout);
        SupprDialogLayout.setHorizontalGroup(
            SupprDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupprDialogLayout.createSequentialGroup()
                .addGroup(SupprDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupprDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel44)
                        .addGap(18, 18, 18)
                        .addComponent(SupprMac, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SupprDialogLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel43))
                    .addGroup(SupprDialogLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(OkSuppr)
                        .addGap(46, 46, 46)
                        .addComponent(CancelSuppr)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        SupprDialogLayout.setVerticalGroup(
            SupprDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SupprDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(53, 53, 53)
                .addGroup(SupprDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(SupprMac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SupprDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelSuppr)
                    .addComponent(OkSuppr))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        SureteDialog.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel45.setText("Êtes-vous sür de vouloir supprimer cet équipement?");

        jLabel46.setText("MAC:");

        OkSurete.setBackground(new java.awt.Color(0, 255, 0));
        OkSurete.setText("Valider");
        OkSurete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkSureteActionPerformed(evt);
            }
        });

        CancelSurete.setBackground(new java.awt.Color(255, 0, 0));
        CancelSurete.setText("Annuler");
        CancelSurete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelSureteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SureteDialogLayout = new javax.swing.GroupLayout(SureteDialog.getContentPane());
        SureteDialog.getContentPane().setLayout(SureteDialogLayout);
        SureteDialogLayout.setHorizontalGroup(
            SureteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SureteDialogLayout.createSequentialGroup()
                .addGroup(SureteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SureteDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel45))
                    .addGroup(SureteDialogLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(SureteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SureteDialogLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel47))
                            .addGroup(SureteDialogLayout.createSequentialGroup()
                                .addComponent(OkSurete)
                                .addGap(33, 33, 33)
                                .addComponent(CancelSurete)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        SureteDialogLayout.setVerticalGroup(
            SureteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SureteDialogLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel45)
                .addGap(18, 18, 18)
                .addGroup(SureteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47))
                .addGap(39, 39, 39)
                .addGroup(SureteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkSurete)
                    .addComponent(CancelSurete))
                .addContainerGap(69, Short.MAX_VALUE))
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
            .addGap(0, 425, Short.MAX_VALUE)
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

        MenuAjouterSalle.setText("Ajouter salle");
        MenuAjouterSalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAjouterSalleActionPerformed(evt);
            }
        });
        barMenuAjouter.add(MenuAjouterSalle);

        menuAjouterRouteur.setText("Ajouter Routeur");
        menuAjouterRouteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjouterRouteurActionPerformed(evt);
            }
        });
        barMenuAjouter.add(menuAjouterRouteur);

        menuAjouterBorne.setText("Ajouter Borne");
        menuAjouterBorne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjouterBorneActionPerformed(evt);
            }
        });
        barMenuAjouter.add(menuAjouterBorne);

        menuAjouterOrdinateur.setText("Ajouter Ordinateur");
        menuAjouterOrdinateur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjouterOrdinateurActionPerformed(evt);
            }
        });
        barMenuAjouter.add(menuAjouterOrdinateur);

        menuAjouterTablette.setText("Ajouteur Tablette");
        menuAjouterTablette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAjouterTabletteActionPerformed(evt);
            }
        });
        barMenuAjouter.add(menuAjouterTablette);

        barMenu.add(barMenuAjouter);

        setJMenuBar(barMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NumeroSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroSalleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroSalleActionPerformed

    private void SalleOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleOkActionPerformed

        if (NumeroSalle.getText() != "" && EtageSalle.getText() != "" && NombreOrdinateurSalle.getText() != "") {
            final Salle sa = new Salle(Integer.parseInt(NumeroSalle.getText()), Integer.parseInt(EtageSalle.getText()), Integer.parseInt(NombreOrdinateurSalle.getText()));
            loc.ajouterSalle(Integer.parseInt(NumeroSalle.getText()), Integer.parseInt(EtageSalle.getText()), Integer.parseInt(NombreOrdinateurSalle.getText()));
            bdd.AjoutSalle(loc.getNom(), sa.getNumero(), sa.getEtage(), sa.getNombreOrdinateur());
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
        }
        NumeroSalle.setText("");
        EtageSalle.setText("");
        NombreOrdinateurSalle.setText("");
        SalleDialog.setVisible(false);
        setVisible(false);
        setVisible(true);
    }//GEN-LAST:event_SalleOkActionPerformed

    private void MenuAjouterSalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAjouterSalleActionPerformed
        SalleDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuAjouterSalleActionPerformed

    private void SalleCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalleCancelActionPerformed
        NumeroSalle.setText("");
        EtageSalle.setText("");
        NombreOrdinateurSalle.setText("");
        SalleDialog.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_SalleCancelActionPerformed


    private void menuAjouterRouteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjouterRouteurActionPerformed
        RouteurDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuAjouterRouteurActionPerformed

    private void menuAjouterBorneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjouterBorneActionPerformed
        BorneDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuAjouterBorneActionPerformed

    private void menuAjouterOrdinateurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjouterOrdinateurActionPerformed
        OrdinateurDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuAjouterOrdinateurActionPerformed

    private void menuAjouterTabletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAjouterTabletteActionPerformed
        TabletteDialog.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_menuAjouterTabletteActionPerformed

    private void OkRouteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkRouteurActionPerformed
        if (NomRouteur.getText() != "" && MacRouteur.getText() != "" && MarqueRouteur.getText() != "" && PowerRouteur.getText() != "" && PortRouteur.getText() != "" && NomOs.getText() != "" && VersionOs.getText() != "") {
            Os osRouteur = new Os(NomOs.getText(), VersionOs.getText());
            final Routeur ro = new Routeur(NomRouteur.getText(), MacRouteur.getText(), MarqueRouteur.getText(), PowerRouteur.getText().equalsIgnoreCase("on"), osRouteur, Integer.parseInt(PortRouteur.getText()));
            salleTemp.ajouterRouteur(ro);
            bdd.AjoutRouteur(salleTemp.getNumero(), ro.getNom(), ro.getMac(), ro.getMarque(), osRouteur.getNomOs(), osRouteur.getVersion(), ro.isPower(), ro.getNombrePorts());
            actionMiseEnPlaceBouton(salleTemp);
        }
        NomRouteur.setText("");
        MacRouteur.setText("");
        NomOs.setText("");
        VersionOs.setText("");
        MarqueRouteur.setText("");
        PowerRouteur.setText("");
        PortRouteur.setText("");
        RouteurDialog.setVisible(false);
        setVisible(false);
        setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_OkRouteurActionPerformed

    private void OkBorneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkBorneActionPerformed

        if (NomBorne.getText() != "" && MacBorne.getText() != "" && MarqueBorne.getText() != "" && PowerBorne.getText() != "" && NomOs.getText() != "" && VersionOs.getText() != "") {
            Os osBorne = new Os(NomOsBorne.getText(), VersionOsBorne.getText());
            final BorneSansFil bo = new BorneSansFil(NomBorne.getText(), MacBorne.getText(), MarqueBorne.getText(), PowerBorne.getText().equalsIgnoreCase("on"), osBorne);
            bdd.AjoutBorne(salleTemp.getNumero(),bo.getNom(),bo.getMac(),bo.getMarque(),osBorne.getNomOs(),osBorne.getVersion(),bo.isPower());
            salleTemp.ajouterBorneSansFil(bo);
            actionMiseEnPlaceBouton(salleTemp);

        }
        NomBorne.setText("");
        MacBorne.setText("");
        MarqueBorne.setText("");
        PowerBorne.setText("");
        NomOsBorne.setText("");
        VersionOsBorne.setText("");
        BorneDialog.setVisible(false);
        setVisible(false);
        setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_OkBorneActionPerformed

    private void CancelRouteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelRouteurActionPerformed
        NomBorne.setText("");
        MacBorne.setText("");
        MarqueBorne.setText("");
        PowerBorne.setText("");
        NomOsBorne.setText("");
        VersionOsBorne.setText("");
        BorneDialog.setVisible(false);
        setVisible(false);
        setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_CancelRouteurActionPerformed

    private void CancelBorneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelBorneActionPerformed
        NomBorne.setText("");
        MacBorne.setText("");
        MarqueBorne.setText("");
        PowerBorne.setText("");
        NomOsBorne.setText("");
        VersionOsBorne.setText("");
        BorneDialog.setVisible(false);
        setVisible(false);
        setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_CancelBorneActionPerformed

    private void OkOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkOrdiActionPerformed
        Os osOrdi = new Os(NomOsOrdi.getText(), VersionOsOrdi.getText());
        final Ordinateur ordi = new Ordinateur(MacOrdi.getText(), NomOrdi.getText(), MarqueOrdi.getText(), PowerOrdi.getText().equalsIgnoreCase("on"), osOrdi, RamOrdi.getText(), CpuOrdi.getText(), GpuOrdi.getText(), HddOrdi.getText());
        routeurTemp.connecterOrdinateur(ordi);
        bdd.AjoutOrdinateur(salleTemp.getNumero(), ordi.getNom(), ordi.getMac(), ordi.getMarque(), osOrdi.getNomOs(), osOrdi.getVersion(), ordi.isPower(), ordi.getRam(), ordi.getCpu(), ordi.getGpu(), ordi.getHdd());
        actionMiseEnPlaceBouton(salleTemp);
        MacOrdi.setText("");
        NomOrdi.setText("");
        MarqueOrdi.setText("");
        PowerOrdi.setText("");
        RamOrdi.setText("");
        CpuOrdi.setText("");
        HddOrdi.setText("");
        GpuOrdi.setText("");
        NomOsOrdi.setText("");
        VersionOsOrdi.setText("");
        OrdinateurDialog.setVisible(false);
        setVisible(false);
        setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_OkOrdiActionPerformed

    private void NomOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomOrdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomOrdiActionPerformed

    private void CancelOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelOrdiActionPerformed
        MacOrdi.setText("");
        NomOrdi.setText("");
        MarqueOrdi.setText("");
        PowerOrdi.setText("");
        RamOrdi.setText("");
        CpuOrdi.setText("");
        HddOrdi.setText("");
        GpuOrdi.setText("");
        NomOsOrdi.setText("");
        VersionOsOrdi.setText("");
        OrdinateurDialog.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelOrdiActionPerformed

    private void OkUpdateOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkUpdateOrdiActionPerformed

        salleTemp.miseAJour(UpdateMacOrdi.getText(), new Os(UpdateNomOsOrdi.getText(), UpdateVersionOsOrdi.getText()));
        UpdateMacOrdi.setText("");
        UpdateNomOsOrdi.setText("");
        UpdateVersionOsOrdi.setText("");
        UpdateDialog.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_OkUpdateOrdiActionPerformed

    private void CancelUpdateOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelUpdateOrdiActionPerformed
        UpdateMacOrdi.setText("");
        UpdateNomOsOrdi.setText("");
        UpdateVersionOsOrdi.setText("");
        UpdateDialog.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelUpdateOrdiActionPerformed

    private void OkSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkSupprActionPerformed
        jLabel47.setText(SupprMac.getText());
        SupprMac.setText("");
        SupprDialog.setVisible(false);
        SureteDialog.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_OkSupprActionPerformed

    private void CancelSupprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelSupprActionPerformed
        SupprMac.setText("");
        SupprDialog.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_CancelSupprActionPerformed

    private void CancelSureteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelSureteActionPerformed
        SureteDialog.setVisible(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_CancelSureteActionPerformed

    private void OkSureteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkSureteActionPerformed
        SureteDialog.setVisible(false);
        salleTemp.suppr(jLabel47.getText());
        // TODO add your handling code here:
    }//GEN-LAST:event_OkSureteActionPerformed

    private void OkTabletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkTabletteActionPerformed

// TODO add your handling code here:

        Os osTab = new Os(NomOsTablette.getText(), VersionOsTablette.getText());
        final Tablette tab = new Tablette(NomTablette.getText(), MacTablette.getText(), MarqueTablette.getText(), PowerTablette.getText().equalsIgnoreCase("on"), osTab, CapaTablette.getText(), ModeleTablette.getText());
        bdd.AjoutTablette(salleTemp.getNumero(), tab.getNom() , tab.getMac(),tab.getMarque(), osTab.getNomOs(),osTab.getVersion(),tab.isPower(), tab.getModele(),tab.getCapacite());
        borneTemp.connecterTablette(tab);
        actionMiseEnPlaceBouton(salleTemp);
        NomTablette.setText("");
        MacTablette.setText("");
        NomOsTablette.setText("");
        VersionOsTablette.setText("");
        MarqueTablette.setText("");
        PowerTablette.setText("");
        CapaTablette.setText("");
        ModeleTablette.setText("");
        TabletteDialog.setVisible(false);
        setVisible(false);
        setVisible(true);                // TODO add your handling code here:
    }//GEN-LAST:event_OkTabletteActionPerformed

    private void MacSureteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MacSureteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MacSureteActionPerformed

    private void MacTabletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MacTabletteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MacTabletteActionPerformed

    private void CancelTabletteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelTabletteActionPerformed
        NomTablette.setText("");
        MacTablette.setText("");
        NomOsTablette.setText("");
        VersionOsTablette.setText("");
        MarqueTablette.setText("");
        PowerTablette.setText("");
        CapaTablette.setText("");
        ModeleTablette.setText("");
        TabletteDialog.setVisible(false);
        setVisible(false);
        setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_CancelTabletteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AfficheListeSalle;
    private javax.swing.JDialog BorneDialog;
    private javax.swing.JButton CancelBorne;
    private javax.swing.JButton CancelOrdi;
    private javax.swing.JButton CancelRouteur;
    private javax.swing.JButton CancelSuppr;
    private javax.swing.JButton CancelSurete;
    private javax.swing.JButton CancelTablette;
    private javax.swing.JButton CancelUpdateOrdi;
    private javax.swing.JTextField CapaTablette;
    private javax.swing.JTextField CpuOrdi;
    private javax.swing.JLabel CreationSalle;
    private javax.swing.JTextField EtageSalle;
    private javax.swing.JTextField GpuOrdi;
    private javax.swing.JTextField HddOrdi;
    private javax.swing.JTextField MacBorne;
    private javax.swing.JTextField MacOrdi;
    private javax.swing.JTextField MacRouteur;
    private javax.swing.JTextField MacTablette;
    private javax.swing.JTextField MarqueBorne;
    private javax.swing.JTextField MarqueOrdi;
    private javax.swing.JTextField MarqueRouteur;
    private javax.swing.JTextField MarqueTablette;
    private javax.swing.JMenuItem MenuAjouterSalle;
    private javax.swing.JTextField ModeleTablette;
    private javax.swing.JTextField NomBorne;
    private javax.swing.JTextField NomOrdi;
    private javax.swing.JTextField NomOs;
    private javax.swing.JTextField NomOsBorne;
    private javax.swing.JTextField NomOsOrdi;
    private javax.swing.JTextField NomOsTablette;
    private javax.swing.JTextField NomRouteur;
    private javax.swing.JTextField NomTablette;
    private javax.swing.JTextField NombreOrdinateurSalle;
    private javax.swing.JTextField NumeroSalle;
    private javax.swing.JButton OkBorne;
    private javax.swing.JButton OkOrdi;
    private javax.swing.JButton OkRouteur;
    private javax.swing.JButton OkSuppr;
    private javax.swing.JButton OkSurete;
    private javax.swing.JButton OkTablette;
    private javax.swing.JButton OkUpdateOrdi;
    private javax.swing.JDialog OrdinateurDialog;
    private javax.swing.JTextField PortRouteur;
    private javax.swing.JTextField PowerBorne;
    private javax.swing.JTextField PowerOrdi;
    private javax.swing.JTextField PowerRouteur;
    private javax.swing.JTextField PowerTablette;
    private javax.swing.JTextField RamOrdi;
    private javax.swing.JDialog RouteurDialog;
    private javax.swing.JButton SalleCancel;
    private javax.swing.JDialog SalleDialog;
    private javax.swing.JButton SalleOk;
    private javax.swing.JDialog SupprDialog;
    private javax.swing.JTextField SupprMac;
    private javax.swing.JDialog SureteDialog;
    private javax.swing.JDialog TabletteDialog;
    private javax.swing.JDialog UpdateDialog;
    private javax.swing.JTextField UpdateMacOrdi;
    private javax.swing.JTextField UpdateNomOsOrdi;
    private javax.swing.JTextField UpdateVersionOsOrdi;
    private javax.swing.JTextField VersionOs;
    private javax.swing.JTextField VersionOsBorne;
    private javax.swing.JTextField VersionOsOrdi;
    private javax.swing.JTextField VersionOsTablette;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JMenu barMenuAjouter;
    private javax.swing.JPanel fenetreRouteur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem menuAjouterBorne;
    private javax.swing.JMenuItem menuAjouterOrdinateur;
    private javax.swing.JMenuItem menuAjouterRouteur;
    private javax.swing.JMenuItem menuAjouterTablette;
    // End of variables declaration//GEN-END:variables
}
