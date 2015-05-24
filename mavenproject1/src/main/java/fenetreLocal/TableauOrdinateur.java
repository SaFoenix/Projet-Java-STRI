/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fenetreLocal;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellRenderer;
import mesClasses.*;
/**
 *
 * @author guigui
 */
public class TableauOrdinateur extends javax.swing.JPanel {
    JTable tableau;
    private Routeur routeur;
    private Ordinateur [] ordinateurs;
    private String[] columns={"Nom","Mac","Marque","Power","RAM","CPU","GPU","HDD","NomOS","Version"};
    private String[][] data;
    
    /**
     * Creates new form Tableau
     * @param ordinateurs
     */
    public TableauOrdinateur(Routeur rout) {
       routeur=rout;
       this.ordinateurs=rout.retournerOrdinateurs();        
        data=new String [ordinateurs.length][columns.length];
        initialiseTableau();
        tableau=new JTable(data,columns){
            public boolean isCellEditable(int date,int colums){
                if(colums==1 || colums==2 || colums==8 || colums==9)  {
                    return false;
                }//si mac on peut la changer
                return true;
            } 
            public Object getValueAt(int row, int col) {
                System.out.println("donnée: "+data[row][col]);
                 return data[row][col];
            }
            public void setValueAt(Object value,int row, int col){
                if(col!=1){
                    Ordinateur ordi=routeur.rechercherOrdinateur(data[row][1]);
                    if(ordi!=null){
                        data[row][col]=(String) value;
                        switch(col){
                            case 0: ordi.setNom((String)value);
                                break;
                            case 3: ordi.setPower((((String)value).equals("on")));
                                break;
                            case 4: ordi.setRam((String)value); 
                                break;
                            case 5: ordi.setCpu((String)value);
                                break;
                            case 6:ordi.setGpu((String)value);
                                break;
                            case 7: ordi.setHdd((String)value);
                                break;
                        }
                    }                    
                }
            }
            public void addTableModelListener(TableModelListener l) {

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
        for(Ordinateur ordi:ordinateurs){         
            
            if (ordi != null) {
                System.out.println("ORdinateur tab: "+ordi.toString());
                int j = 0;
                data[i][j] = ordi.getNom();
                j++;
                data[i][j] = ordi.getMac();
                j++;
                data[i][j] = ordi.getMarque();
                j++;
                data[i][j] = (ordi.isPower() ? "on" : "off");
                j++;
                data[i][j] = ordi.getRam();
                j++;
                data[i][j] = ordi.getCpu();
                j++;
                data[i][j] = ordi.getGpu();
                j++;
                data[i][j] = ordi.getHdd();
                j++;
                data[i][j] = (ordi.getOs().getNomOs());
                j++;
                data[i][j] = (ordi.getOs().getVersion());
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
