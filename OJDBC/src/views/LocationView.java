/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.LocationController;
import icontrollers.ILocationController;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.DBConnection;
import models.Location;

/**
 *
 * @author Rezaditya
 */
public class LocationView extends javax.swing.JFrame {

    private DBConnection connection = new DBConnection();
    private ILocationController ilc = new LocationController(connection.getConnection());

    /**
     * Creates new form LocationView
     */
    public LocationView() {
        initComponents();
        addItemCountryID();
        addRowToJTable();
    }
       
    public void addItemCountryID(){
        //fill ComboBox By Country_id table COUNTRIES  
        comboBoxCountryId.setModel(new DefaultComboBoxModel<>(new String[]{
            "select country ID"
        }));
        ilc.getIdCountry().forEach((s) -> {
            comboBoxCountryId.addItem(s);
        });
    }

    private List<Location> list;

    public void addRowToJTable() {
        DefaultTableModel model = (DefaultTableModel) jTableLocation.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[6];

        for (Location l : ilc.getAll()) {
            rowData[0] = l.getId();
            rowData[1] = l.getStreetAdress();
            rowData[2] = l.getPostalCode();
            rowData[3] = l.getCity();
            rowData[4] = l.getStateProvince();
            rowData[5] = l.getCountryId();
            model.addRow(rowData);
        }
    }
    
    public void cleanField(){
        textFieldLocationID.setText("");
        textFieldStreetAdress.setText("");
        textFieldPostalCode.setText("");
        textFieldCity.setText("");
        textFieldStateProvince.setText("");
        textFieldStreetAdress.setText("");
        addItemCountryID();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocationView().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textFieldLocationID = new javax.swing.JTextField();
        textFieldStreetAdress = new javax.swing.JTextField();
        textFieldPostalCode = new javax.swing.JTextField();
        textFieldCity = new javax.swing.JTextField();
        textFieldStateProvince = new javax.swing.JTextField();
        comboBoxCountryId = new javax.swing.JComboBox<>();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        keterangan = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableLocation = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButtonShowAll = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Montserrat", 1, 14)); // NOI18N
        jLabel1.setText("INSERT NEW LOCATION");

        jLabel2.setText("ID :");

        jLabel3.setText("Street Address :");

        jLabel4.setText("Postal Code :");

        jLabel5.setText("City :");

        jLabel6.setText("State Province :");

        jLabel7.setText("Country ID :");

        textFieldLocationID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLocationIDActionPerformed(evt);
            }
        });

        comboBoxCountryId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCountryId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCountryIdActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel8.setText("Search by Key");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        keterangan.setFont(new java.awt.Font("Consolas", 0, 11)); // NOI18N
        keterangan.setText("detail");

        jTableLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Location ID", "Street Address", "Postal Code", "City", "State Province", "Country ID"
            }
        ));
        jScrollPane2.setViewportView(jTableLocation);

        jLabel9.setFont(new java.awt.Font("Montserrat", 1, 11)); // NOI18N
        jLabel9.setText("Delete by ID :");

        jButtonShowAll.setText("Show All");
        jButtonShowAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShowAllActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(45, 45, 45)
                                .addComponent(textFieldPostalCode))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(textFieldStreetAdress))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(textFieldLocationID, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(insertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textFieldStateProvince, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(textFieldCity, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(comboBoxCountryId, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(keterangan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonShowAll)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldLocationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldPostalCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(comboBoxCountryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldStreetAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(textFieldStateProvince, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch)
                    .addComponent(deleteButton)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keterangan)
                    .addComponent(jButtonShowAll))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldLocationIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLocationIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLocationIDActionPerformed

    private void comboBoxCountryIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCountryIdActionPerformed

    }//GEN-LAST:event_comboBoxCountryIdActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        String idLocation = textFieldLocationID.getText();
        String streetAdress = textFieldStreetAdress.getText();
        String postalCode = textFieldPostalCode.getText();
        String city = textFieldCity.getText();
        String stateProvince = textFieldStateProvince.getText();
        String countryId = comboBoxCountryId.getSelectedItem().toString();
        String ket;
        
        if (countryId.equalsIgnoreCase("select country ID")) {
            JOptionPane.showMessageDialog(rootPane, "Isi Country ID", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            ket = (ilc.insert(Integer.parseInt(idLocation), streetAdress, postalCode, city, stateProvince, countryId));
            keterangan.setText(ket);
            JOptionPane.showMessageDialog(rootPane, ket, "Saved", JOptionPane.INFORMATION_MESSAGE);
            addRowToJTable();
            cleanField();
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        String idLocation = textFieldLocationID.getText();
        String streetAdress = textFieldStreetAdress.getText();
        String postalCode = textFieldPostalCode.getText();
        String city = textFieldCity.getText();
        String stateProvince = textFieldStateProvince.getText();
        String countryId = comboBoxCountryId.getSelectedItem().toString();

        keterangan.setText(ilc.update(Integer.parseInt(idLocation), streetAdress, postalCode, city, stateProvince, countryId));
        addRowToJTable();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        String idLocation = textFieldLocationID.getText();
        String ket = keterangan.toString();

        if (idLocation.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Isi Location ID", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }else{
            keterangan.setText(ilc.delete(Integer.parseInt(idLocation)));
            addRowToJTable();
            textFieldLocationID.setText("");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        String textSearch = jTextFieldSearch.getText();

        DefaultTableModel model = (DefaultTableModel) jTableLocation.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        Object rowData[] = new Object[6];

        for (Location l : ilc.search(textSearch)) {
            rowData[0] = l.getId();
            rowData[1] = l.getStreetAdress();
            rowData[2] = l.getPostalCode();
            rowData[3] = l.getCity();
            rowData[4] = l.getStateProvince();
            rowData[5] = l.getCountryId();
            model.addRow(rowData);
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonShowAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShowAllActionPerformed
        addRowToJTable();
    }//GEN-LAST:event_jButtonShowAllActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Anda ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxCountryId;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonShowAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableLocation;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JLabel keterangan;
    private javax.swing.JTextField textFieldCity;
    private javax.swing.JTextField textFieldLocationID;
    private javax.swing.JTextField textFieldPostalCode;
    private javax.swing.JTextField textFieldStateProvince;
    private javax.swing.JTextField textFieldStreetAdress;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
