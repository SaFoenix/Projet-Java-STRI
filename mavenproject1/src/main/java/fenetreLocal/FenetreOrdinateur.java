/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetreLocal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import mesClasses.Ordinateur;
import mesClasses.Routeur;

/**
 *
 * @author guigui
 */
public class FenetreOrdinateur extends javax.swing.JPanel {
   private  Routeur routeurs;
    /**
     * Creates new form FenetreOrdinateur
     */
    public FenetreOrdinateur(Routeur routeurs) {
        this.routeurs=routeurs;
        initComponents();
        /* bdd=new MySql();
        bdd.Connexion();*/
        initComponents();
        setLayout(new GridBagLayout());
        /*gbc.insets=new Insets(5, 5, 5, 5);
        gbc.gridx=10;
        gbc.gridy=10;    
        setSize(0 ,0);
        setBackground(Color.WHITE);*/
        initialisationFenetre();
    }

    public void initialisationFenetre() {
        Ordinateur[] ordi = (routeurs.retournerOrdinateurs());
            TableauOrdinateur tab = new TableauOrdinateur(ordi);
            add(tab, BorderLayout.CENTER);
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
