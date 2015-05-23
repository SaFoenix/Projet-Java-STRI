/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetrePrincipale;
import java.awt.*;
import java.util.*;
import mesClasses.*;
import fenetreLocal.*;
import static java.awt.SystemColor.desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author guigui
 */
public class FenetreSecondaire extends javax.swing.JFrame {
    /**
     * Creates new form FenetreSecondaire
     * @param loc
     */
    public FenetreSecondaire(Local loc) {
        initComponents();
        FenetreInterieurLocal f=new FenetreInterieurLocal(loc);
        bureau.add(f);
        setTitle(loc.getNom() + " " + "[" + loc.getlocalisation()+ "]");
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

        bureau = new javax.swing.JDesktopPane();

        javax.swing.GroupLayout bureauLayout = new javax.swing.GroupLayout(bureau);
        bureau.setLayout(bureauLayout);
        bureauLayout.setHorizontalGroup(
            bureauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        bureauLayout.setVerticalGroup(
            bureauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bureau, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bureau)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane bureau;
    // End of variables declaration//GEN-END:variables
}
