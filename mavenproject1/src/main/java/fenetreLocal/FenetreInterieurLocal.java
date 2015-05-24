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
    TableauEquipement tabEquipement;
    int positionX = 0;
    int positionY = 0;
    private javax.swing.JInternalFrame afficheInformation;
    private javax.swing.JInternalFrame afficheInformationEquipementRacine;

    /**
     * Creates new form frame1
     */
    public FenetreInterieurLocal(Local loc) {
        /* bdd=new MySql();
         bdd.Connexion();*/
        this.loc = loc;
        salles = loc.getSalles();
        initComponents();
        menuAjouterRouteur.setEnabled(false);
        menuAjouterBorne.setEnabled(false);
        setTitle(loc.getNom());
        setSize(1020,800);
        AfficheListeSalle.setBackground(Color.red);
        AfficheListeSalle.setLayout(new GridBagLayout());
        
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        afficheInformation = new javax.swing.JInternalFrame();
        afficheInformation.setSize(600,300);
        //afficheInformation.setAutoscrolls(true);
        afficheInformationEquipementRacine=new javax.swing.JInternalFrame();
        afficheInformationEquipementRacine.setSize(600,300);
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
        menuAjouterRouteur.setEnabled(true);
        menuAjouterBorne.setEnabled(true);
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
                    afficheInformationEquipementRacine.setVisible(false);
                    afficheInformation.setVisible(false);
                    if (tabOrdinateur != null) {
                        afficheInformation.remove(tabOrdinateur);
                    }
                    if (tabTablette != null) {
                        afficheInformation.remove(tabTablette);
                    }
                    if(tabEquipement!=null){
                        afficheInformationEquipementRacine.remove(tabEquipement);
                    }
                    remove(afficheInformationEquipementRacine);
                    remove(afficheInformation);
                    tabEquipement=new TableauEquipement(rout);
                    tabOrdinateur = new TableauOrdinateur(rout);
                    afficheInformationEquipementRacine.add(tabEquipement,BorderLayout.WEST);
                    afficheInformation.add(tabOrdinateur, BorderLayout.EAST);
                    tabEquipement.setVisible(true);
                    tabOrdinateur.setVisible(true);
                    afficheInformation.setVisible(true);
                    afficheInformationEquipementRacine.setVisible(true);
                    add(afficheInformation, BorderLayout.EAST);
                    add(afficheInformationEquipementRacine, BorderLayout.CENTER);
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
                    afficheInformationEquipementRacine.setVisible(false);
                    afficheInformation.setVisible(false);
                    if (tabTablette != null) {
                        afficheInformation.remove(tabTablette);
                    }
                    if (tabOrdinateur != null) {
                        afficheInformation.remove(tabOrdinateur);
                    }
                    remove(afficheInformation);
                    tabTablette = new TableauTablette(bo);
                    afficheInformation.add(tabTablette, BorderLayout.EAST);
                    tabTablette.setVisible(true);
                    afficheInformation.setVisible(true);
                    add(afficheInformation, BorderLayout.EAST);
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
        OsRouteur = new javax.swing.JTextField();
        MarqueRouteur = new javax.swing.JTextField();
        PowerRouteur = new javax.swing.JTextField();
        PortRouteur = new javax.swing.JTextField();
        BorneDialog = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        NomBorne = new javax.swing.JTextField();
        MacBorne = new javax.swing.JTextField();
        MarqueBorne = new javax.swing.JTextField();
        PowerBorne = new javax.swing.JTextField();
        OsBorne = new javax.swing.JTextField();
        OrdinateurDialog = new javax.swing.JDialog();
        jLabel17 = new javax.swing.JLabel();
        TabletteDialog = new javax.swing.JDialog();
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

        RouteurDialog.setMinimumSize(new java.awt.Dimension(600, 400));

        jLabel1.setText("Création routeur");

        OkRouteur.setBackground(new java.awt.Color(0, 255, 0));
        OkRouteur.setText("Valider");

        CancelRouteur.setBackground(new java.awt.Color(255, 0, 0));
        CancelRouteur.setText("Annuler");

        jLabel5.setText("Nom");

        jLabel6.setText("MAC");

        jLabel7.setText("OS");

        jLabel8.setText("Marque");

        jLabel9.setText("Power");

        jLabel10.setText("Nombre de ports");

        javax.swing.GroupLayout RouteurDialogLayout = new javax.swing.GroupLayout(RouteurDialog.getContentPane());
        RouteurDialog.getContentPane().setLayout(RouteurDialogLayout);
        RouteurDialogLayout.setHorizontalGroup(
            RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteurDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(43, 43, 43)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
                        .addComponent(OkRouteur)
                        .addGap(35, 35, 35)
                        .addComponent(CancelRouteur))
                    .addComponent(NomRouteur)
                    .addComponent(MacRouteur)
                    .addComponent(OsRouteur)
                    .addComponent(MarqueRouteur)
                    .addComponent(PowerRouteur)
                    .addComponent(PortRouteur))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RouteurDialogLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(145, 145, 145))
        );
        RouteurDialogLayout.setVerticalGroup(
            RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RouteurDialogLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(RouteurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(RouteurDialogLayout.createSequentialGroup()
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
                            .addComponent(OsRouteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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

        jLabel16.setText("OS");

        jButton1.setBackground(new java.awt.Color(51, 255, 0));
        jButton1.setText("Valider");

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Annuler");

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
                            .addComponent(jLabel12))
                        .addGap(28, 28, 28)
                        .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BorneDialogLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(44, 44, 44)
                                .addComponent(jButton2))
                            .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(OsBorne, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                .addComponent(PowerBorne, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MarqueBorne, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MacBorne, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NomBorne, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap(148, Short.MAX_VALUE))
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
                    .addComponent(OsBorne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(BorneDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(34, 34, 34))
        );

        jLabel17.setText("Création Ordinateur");

        javax.swing.GroupLayout OrdinateurDialogLayout = new javax.swing.GroupLayout(OrdinateurDialog.getContentPane());
        OrdinateurDialog.getContentPane().setLayout(OrdinateurDialogLayout);
        OrdinateurDialogLayout.setHorizontalGroup(
            OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdinateurDialogLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jLabel17)
                .addContainerGap(163, Short.MAX_VALUE))
        );
        OrdinateurDialogLayout.setVerticalGroup(
            OrdinateurDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrdinateurDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(275, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TabletteDialogLayout = new javax.swing.GroupLayout(TabletteDialog.getContentPane());
        TabletteDialog.getContentPane().setLayout(TabletteDialogLayout);
        TabletteDialogLayout.setHorizontalGroup(
            TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        TabletteDialogLayout.setVerticalGroup(
            TabletteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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

   /* private void localButton2ActionPerformed (java.awt.ActionEvent evt) {
        menuAjouterRouteur.setEnabled(true);
        menuAjouterBorne.setEnabled(true);
    }
    */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AfficheListeSalle;
    private javax.swing.JDialog BorneDialog;
    private javax.swing.JButton CancelRouteur;
    private javax.swing.JLabel CreationSalle;
    private javax.swing.JTextField EtageSalle;
    private javax.swing.JTextField MacBorne;
    private javax.swing.JTextField MacRouteur;
    private javax.swing.JTextField MarqueBorne;
    private javax.swing.JTextField MarqueRouteur;
    private javax.swing.JMenuItem MenuAjouterSalle;
    private javax.swing.JTextField NomBorne;
    private javax.swing.JTextField NomRouteur;
    private javax.swing.JTextField NombreOrdinateurSalle;
    private javax.swing.JTextField NumeroSalle;
    private javax.swing.JButton OkRouteur;
    private javax.swing.JDialog OrdinateurDialog;
    private javax.swing.JTextField OsBorne;
    private javax.swing.JTextField OsRouteur;
    private javax.swing.JTextField PortRouteur;
    private javax.swing.JTextField PowerBorne;
    private javax.swing.JTextField PowerRouteur;
    private javax.swing.JDialog RouteurDialog;
    private javax.swing.JButton SalleCancel;
    private javax.swing.JDialog SalleDialog;
    private javax.swing.JButton SalleOk;
    private javax.swing.JDialog TabletteDialog;
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JMenu barMenuAjouter;
    private javax.swing.JPanel fenetreRouteur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
