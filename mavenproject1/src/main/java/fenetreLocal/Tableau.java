/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetreLocal;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import mesClasses.*;
import java.lang.*;
/**
 *
 * @author guigui
 */
public class Tableau extends javax.swing.JPanel {
    JTable tableau;
    private Ordinateur [] ordinateurs;
    private String[] columns={"Nom","Mac","Marque","Power","RAM","CPU","GPU","HDD","NomOS","Version"};
    private String[][] data;
    
    /**
     * Creates new form Tableau
     */
    public Tableau(Ordinateur [] ordinateurs) {
        initComponents();
        this.ordinateurs=ordinateurs;        
        data=new String [columns.length][ordinateurs.length];
        tableau=new JTable(data,columns){
            public boolean isCellEditable(int date,int colums){
                return false;
            }            
        };
        initialiseTableau();
        tableau.setPreferredScrollableViewportSize(new Dimension());
        tableau.setFillsViewportHeight(true);
        JScrollPane jps=new JScrollPane(tableau);
        add(jps);
    }   
    
    public void initialiseTableau(){
        int i=0;
        for(Ordinateur ordi:ordinateurs){
                int j=0;
                data[i][j]=ordi.getNom();
                j++;
                data[i][j]=ordi.getMac();
                j++;
                data[i][j]=ordi.getMarque();
                 j++;
                data[i][j]=(ordi.isPower()?"on":"off");
                 j++;
                data[i][j]=ordi.getRam();
                 j++;
                data[i][j]=ordi.getCpu();
                 j++;
                data[i][j]=ordi.getGpu();
                 j++;
                data[i][j]=ordi.getHdd();
                 j++;
                data[i][j]=(ordi.getOs().getNomOs());
                 j++;
                data[i][j]=(ordi.getOs().getVersion());
                
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
