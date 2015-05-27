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
    private MySql bdd = new MySql();
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

                bdd.Connexion();
            
                if(col==1){

                    data[row][col] = (String) value;                    
                    switch (row) {

                        case 0:
                            equipement.setNom((String) value);
                            bdd.ModifierNom(equipement.getNom(),equipement.getMac());
                            break;
                        case 3:
                            equipement.setPower(((String) value).equals("on"));
                            if (equipement instanceof Routeur) {
                                ((Routeur) equipement).activerDesactiverOrdinateur(((String) value).equals("on"));
                            } else if (equipement instanceof BorneSansFil) {
                                ((BorneSansFil) equipement).activerDesactiverTablette(((String) value).equals("on"));
                            }
                            bdd.ModifierEtat(equipement.isPower(),equipement.getMac());
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

    public void initialiseTableau(){        
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
