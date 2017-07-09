/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrames.MyPanels;

import GestionBancaire.Compte;
import GestionBancaire.CompteCourant;
import GestionBancaire.CompteEpargne;
import GestionBancaire.ConnectionBD;
import MyFrames.FrameClient;
import static MyFrames.MyPanels.VisionnerClientPanel.fillTable;
import static MyFrames.MyPanels.VisionnerClientPanel.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author asus pro
 */
public class TransactionComptePanel extends javax.swing.JPanel {

    Compte compte=null;
    /**
     * Creates new form TransactionComptePanel
     */
    public TransactionComptePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        code_field = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        type_liste = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        montant_field = new javax.swing.JTextField();
        btnConfirmer = new javax.swing.JButton();

        jLabel1.setText("Code compte:");

        jButton1.setText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Type transaction");

        type_liste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deposer", "Retirer" }));
        type_liste.setEnabled(false);

        jLabel3.setText("Montant");

        montant_field.setEnabled(false);
        montant_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montant_fieldActionPerformed(evt);
            }
        });

        btnConfirmer.setText("Confirmer");
        btnConfirmer.setEnabled(false);
        btnConfirmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmer, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(code_field)
                        .addComponent(type_liste, 0, 86, Short.MAX_VALUE)
                        .addComponent(montant_field)))
                .addGap(50, 50, 50)
                .addComponent(jButton1)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(code_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(type_liste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(montant_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnConfirmer)
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void montant_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montant_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montant_fieldActionPerformed

    private void btnConfirmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmerActionPerformed
        
        type_liste.setEnabled(false);
        montant_field.setEnabled(false);
        btnConfirmer.setEnabled(false);
        
        if(type_liste.getSelectedItem() == "Deposer")
        {
            compte.deposer(Double.parseDouble(montant_field.getText()));
        }
        else if(type_liste.getSelectedItem() == "Retirer")
        {
            if( (compte instanceof CompteCourant && (compte.getSolde()+ ((CompteCourant)compte).getDecouvertAutorise() > Double.parseDouble(montant_field.getText()))) || (compte instanceof CompteEpargne && compte.getSolde() >= Double.parseDouble(montant_field.getText()))  )
            {
                compte.retirer(Double.parseDouble(montant_field.getText()));
                
            }
            else  if(compte instanceof CompteCourant) 
            {
                JOptionPane.showMessageDialog(null, "découvert autorisé: "+((CompteCourant)compte).getDecouvertAutorise());
                return;
            }
            else if(compte instanceof CompteEpargne ) {
                JOptionPane.showMessageDialog(null, "vous ne pouvez pas retirer plus que: "+ compte.getSolde());
                return;
            }
        }
        String sql_transaction="";
        try {
       
            ConnectionBD conn = new ConnectionBD();        
            sql_transaction = "insert into transactions(code_compte,montant_transaction,type_transaction,date_transaction) values(?,?,?,NOW());";
            conn.initRequetePreparee(sql_transaction, true, compte.getCode(),Double.parseDouble(montant_field.getText()),type_liste.getSelectedItem() == "Deposer" ? 1:2).executeUpdate();
            
            sql_transaction = "update comptes set solde_compte = ? ,inactif = 0 where code_compte=?;";
            conn.initRequetePreparee(sql_transaction, true,compte.getSolde(), compte.getCode()).executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Transaction éffectué");
            //actualiser la table des clients
            VisionnerClientPanel.model.setRowCount(0);
            String requete = "select code_agence from agences where nom_agence=?";
            ResultSet rs = conn.initRequetePreparee(requete, true, FrameClient.visionnerClientPanel.getListe_agence().getSelectedItem().toString()).executeQuery();
            if (rs.next()) {
                String sql = "select * from clients where code_agence=?;";
                fillTable(sql, rs.getInt("code_agence"));

            }
                conn.disconnect();
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_btnConfirmerActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int code = Integer.parseInt(code_field.getText());

        try {
            ConnectionBD conn = new ConnectionBD();
            String sql = "select * from comptes where code_compte=?";
            PreparedStatement preparedstm = conn.initRequetePreparee(sql, true, code);
            ResultSet rs = preparedstm.executeQuery();

            if (rs.next()) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "code: " + rs.getString("code_compte") + "\nsolde: " + rs.getString("solde_compte") + "\nid client: " + rs.getString("id_client"), "Warning", dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    
                    type_liste.setEnabled(true);
                    montant_field.setEnabled(true);
                    btnConfirmer.setEnabled(true);
                    
                    double solde = rs.getDouble("solde_compte");
                    sql = "select * from comptes_courants where code_compte=?;";
                    rs = conn.initRequetePreparee(sql, true, code).executeQuery();
                    if(rs.next())
                    {
                        compte = new CompteCourant(code,solde,rs.getDouble("decouvert_autorise"));
                        
                    }
                    else{
                        sql = "select * from comptes_epargnes where code_compte=?;";
                        rs = conn.initRequetePreparee(sql, true, code).executeQuery();
                        if (rs.next()) {
                            compte = new CompteEpargne(code,solde, rs.getDouble("taux_interet"));
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "compte inexistant");
            }

            conn.disconnect();
        } catch (Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmer;
    private javax.swing.JTextField code_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField montant_field;
    private javax.swing.JComboBox<String> type_liste;
    // End of variables declaration//GEN-END:variables
}
