/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetreLocal;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import mesClasses.BorneSansFil;
import mesClasses.MySql;
import mesClasses.Tablette;

/**
 *
 * @author guigui
 */
public class TableauTablette extends javax.swing.JPanel {
    ArrayList<Tablette> tablettes;
    BorneSansFil borne;
    JTable tableau;
    private String[] columns={"Nom","Mac","Marque","Power","Capacité","Modele","NomOS","Version"};
    private String[][] data;
    private MySql bdd = new MySql();
    /**
     * Creates new form FenetreTablette
     */
    public TableauTablette(BorneSansFil bo) {
        //initComponents();
        borne=bo;
        this.tablettes=borne.getTablettes();        
        data=new String [tablettes.size()][columns.length];
        initialiseTableau();
        tableau=new JTable(data,columns){
            public boolean isCellEditable(int date,int colums){
                System.out.println("date: "+date+" colums: "+colums);
                if(colums==1 || colums==2 || colums==6 || colums==7 ||colums==4 || colums==5 ) return false;//si mac on peut la changer, marque, os
                return true;
            } 
            public Object getValueAt(int row, int col) {
                 return data[row][col];
            }
            public void setValueAt(Object value,int row, int col){
                bdd.Connexion();
                if(col!=1){
                    Tablette tab=borne.rechercherTablette(data[row][1]);
                    if(tab!=null){
                        data[row][col]=(String) value;
                        switch(col){
                            case 0: tab.setNom((String)value);
                                    bdd.ModifierNom(tab.getNom(),tab.getMac());
                                break;
                            case 3: tab.setPower((((String)value).equals("on")));
                                    bdd.ModifierEtat(tab.isPower(),tab.getMac());
                                break;
                        }
                    }                    
                }                    
            }
            public void addTableModelListener(TableModelListener l){
                    
            }         
        };
        tableau.getTableHeader().setReorderingAllowed(false);
        tableau.setPreferredScrollableViewportSize(new Dimension(600,300));
        tableau.setFillsViewportHeight(true);
        add(tableau);
        JScrollPane jps=new JScrollPane(tableau);
        add(jps);
    }   
    
    public void initialiseTableau(){
        int i=0;
        for(Tablette tab:tablettes){        
            
            if (tab != null) {
             
                int j = 0;
                data[i][j] = tab.getNom();
                j++;
                data[i][j] = tab.getMac();
                j++;
                data[i][j] = tab.getMarque();
                j++;
                data[i][j] = (tab.isPower() ? "on" : "off");
                j++;
                data[i][j] = tab.getCapacite();
                j++;
                data[i][j] = tab.getModele().toString();                           
                j++;
                data[i][j] = (tab.getOs().getNomOs());
                j++;
                data[i][j] = (tab.getOs().getVersion());
                i++;
            }
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
