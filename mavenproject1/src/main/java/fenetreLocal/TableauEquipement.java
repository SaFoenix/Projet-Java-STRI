/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetreLocal;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import mesClasses.BorneSansFil;
import mesClasses.Equipement;
import mesClasses.MySql;
import mesClasses.Routeur;

/**
 *
 * @author guigui
 */
public class TableauEquipement extends javax.swing.JPanel {
    JTable tableau;
    private Equipement equipement;
    private String[] columns;
    private String[][] data;
    //private MySql bdd = new MySql();
    /**
     * Creates new form TableauEquipement
     */
    public TableauEquipement(Equipement equi) {
        equipement = equi;
        columns = new String[]{"",""};
        if (equipement instanceof BorneSansFil) {
             data = new String[6][2];
        } else if (equipement instanceof Routeur) {
             data = new String[7][2];
        }       
       
        initialiseTableau();
        tableau = new JTable(data,columns) {
            public boolean isCellEditable(int date, int colums) {
               if (colums==0 || (colums==1&&date==1)|| (colums==1&&date==2) || (colums==1&&date==4) || (colums==1&&date==5)|| (colums==1&&date==6)) {
                    return false;//si mac on peut la changer, marque, os
                }
                return true;
            }

            public Object getValueAt(int row, int col) {
                return data[row][col];
            }

            public void setValueAt(Object value, int row, int col) {

//                bdd.Connexion();
            
                if(col==1){

                    data[row][col] = (String) value;                    
                    switch (row) {

                        case 0:
                            equipement.setNom((String) value);
//                            bdd.ModifierNom(equipement.getNom(),equipement.getMac());
                            break;
                        case 3:
                            equipement.setPower(((String) value).equals("on"));
                            if (equipement instanceof Routeur) {
                                ((Routeur) equipement).activerDesactiverOrdinateur(((String) value).equals("on"));
                            } else if (equipement instanceof BorneSansFil) {
                                ((BorneSansFil) equipement).activerDesactiverTablette(((String) value).equals("on"));
                            }
//                            bdd.ModifierEtat(equipement.isPower(),equipement.getMac());
                            break;
                    }
                }
            }

            public void addTableModelListener(TableModelListener l) {

            }
        };
        tableau.getTableHeader().setReorderingAllowed(false);
        tableau.setPreferredScrollableViewportSize(new Dimension(300, 300));
        tableau.setFillsViewportHeight(true);
        add(tableau);
        JScrollPane jps = new JScrollPane(tableau);
        add(jps);
    }

    public void initialiseTableau() {        
        int i = 0;
        int j=0;
        data[i][j] = "Nom";
        i++;
        data[i][j] ="Mac";
        i++;
        data[i][j] = "Marque";
        i++;
        data[i][j] = "Power";
        i++;
        if (equipement instanceof Routeur) {
            data[i][j] = "Nombre de Port";
            i++;
        }
        data[i][j] ="NomOS";
        i++;
        data[i][j] ="Version";
        i=0;
        j = 1;
        data[i][j] = equipement.getNom();
         i++;
        data[i][j] = equipement.getMac();
        i++;
        data[i][j] = equipement.getMarque();
        i++;
        data[i][j] = (equipement.isPower() ? "on" : "off");
        i++;
        if (equipement instanceof Routeur) {
            data[i][j] = ((Routeur) equipement).getNombrePorts().toString();
            i++;
        }
        data[i][j] = (equipement.getOs().getNomOs());
        i++;
        data[i][j] = (equipement.getOs().getVersion());        
    }

     /* private void LocalOkActionPerformed(java.awt.event.ActionEvent evt) {                                        
        Local loc = new Local(LocalName.getText(), LocalLieu.getText());
        so.ajouterLocal(loc.getNom(), loc.getlocalisation());
//        bdd.AjoutLocal(so.getNom(),loc.getNom(), loc.getlocalisation());
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
    */
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpdateDialog = new javax.swing.JDialog();
        OkUpdateOrdi = new javax.swing.JButton();
        CancelUpdateOrdi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UpdateMacOrdi = new javax.swing.JTextField();
        UpdateNomOsOrdi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UpdateVersionOsOrdi = new javax.swing.JTextField();

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

        jLabel1.setText("Update Ordinateur");

        jLabel2.setText("MAC");

        jLabel3.setText("Nom OS");

        jLabel4.setText("Version OS");

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
                        .addContainerGap()
                        .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UpdateMacOrdi, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                            .addComponent(UpdateNomOsOrdi)
                            .addComponent(UpdateVersionOsOrdi))))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(127, 127, 127))
        );
        UpdateDialogLayout.setVerticalGroup(
            UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpdateDialogLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(UpdateMacOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(UpdateNomOsOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(UpdateVersionOsOrdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(UpdateDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OkUpdateOrdi)
                    .addComponent(CancelUpdateOrdi))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void OkUpdateOrdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OkUpdateOrdiActionPerformed
        
        
        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelUpdateOrdi;
    private javax.swing.JButton OkUpdateOrdi;
    private javax.swing.JDialog UpdateDialog;
    private javax.swing.JTextField UpdateMacOrdi;
    private javax.swing.JTextField UpdateNomOsOrdi;
    private javax.swing.JTextField UpdateVersionOsOrdi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
