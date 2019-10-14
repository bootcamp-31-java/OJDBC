/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.EmployeesController;
import daos.EmployeesDAO;
import icontrollers.IEmployeesController;
import java.awt.Component;
import java.sql.Connection;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import models.Employees;
import tools.DBConnection;

/**
 *
 * @author sandi1713
 */
public class VEmployees extends javax.swing.JFrame {

    /**
     * Creates new form VEmployees
     */
    DBConnection con = new DBConnection();
    IEmployeesController iecon = new EmployeesController(con.getConnection());
    EmployeesDAO model;
    List<Employees> list;

    private DefaultTableModel tabelemp;

    public VEmployees() {
        initComponents();
        setLocationRelativeTo(this);
        model = new EmployeesDAO();
        list = iecon.getAll();
        tabelemp = new DefaultTableModel();
        tblemp.setModel(tabelemp);
        tabelemp.addColumn("EMPLOYEE_ID");
        tabelemp.addColumn("FIRST_Name");
        tabelemp.addColumn("LAST_NAME");
        tabelemp.addColumn("EMAIL");
        tabelemp.addColumn("PHONE NUMBER");
        tabelemp.addColumn("HIRE DATE");
        tabelemp.addColumn("JOB ID");
        tabelemp.addColumn("SALARY");
        tabelemp.addColumn("COMMISSION");
        tabelemp.addColumn("MANAGER ID");
        tabelemp.addColumn("DEPARTMENT ID");
        cmbjobid.setModel(new DefaultComboBoxModel<>(new String[]{
            "select job ID"
        }));
        iecon.getJobid().forEach((s) -> {
            cmbjobid.addItem(s);
        });
        cmbmanid.setModel(new DefaultComboBoxModel<>(new String[]{
            "select manager ID"
        }));
        iecon.getManid().forEach((s) -> {
            cmbmanid.addItem(s);
        });
        cmbdepid.setModel(new DefaultComboBoxModel<>(new String[]{
            "select Department ID"
        }));
        iecon.getDepid().forEach((s) -> {
            cmbdepid.addItem(s);
        });
        isitabel();
    }

    public JComboBox<String> getCmbjobid() {
        return cmbjobid;
    }

    public JTextField getTxtsearch() {
        return txtsearch;
    }

    public JTable getTblemp() {
        return tblemp;
    }

    public void SetelKolom() {
        for (int column = 0; column < tblemp.getColumnCount(); column++) {
            TableColumn tableColumn = tblemp.getColumnModel().getColumn(column);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();
            for (int row = 0; row < tblemp.getRowCount(); row++) {
                TableCellRenderer cellRenderer = tblemp.getCellRenderer(row, column);
                Component c = tblemp.prepareRenderer(cellRenderer, row, column);
                int width = c.getPreferredSize().width + tblemp.getIntercellSpacing().width;
                preferredWidth = Math.max(preferredWidth, width);
                if (preferredWidth >= maxWidth) {
                    preferredWidth = maxWidth;
                    break;
                }
            }
            tableColumn.setPreferredWidth(preferredWidth);
        }
    }

    public void bersih() {
        txtempid.setText("");
        txtfname.setText("");
        txtlname.setText("");
        txtemail.setText("");
        txtphone.setText("");
        txthdate.setText("");
//        txtjobid.setText("");
        //cmbjobid.setSelectedItem(0);
        txtsal.setText("");
        txtcom.setText("");
//        txtmanid.setText("");
//        txtdepid.setText("");
    }

    public void isitabel() {
        //mengosongkan textfiled id dan name
        bersih();

        //menghapus isi table region
        tabelemp.getDataVector().removeAllElements();
        tabelemp.fireTableDataChanged();
        //memanggil list data tabel region dari database
        for (Employees r : iecon.getAll()) {
            Object[] obj = new Object[11];
            obj[0] = r.getId();
            obj[1] = r.getFirstname();
            obj[2] = r.getLastname();
            obj[3] = r.getEmail();
            obj[4] = r.getPhone();
            obj[5] = r.getHiredate();
            obj[6] = r.getJobid();
            obj[7] = r.getSalary();
            obj[8] = r.getCommission();
            obj[9] = r.getManagerid();
            obj[10] = r.getDepid();
            tabelemp.addRow(obj);
        }
        SetelKolom();
    }

    public void Cari() {
        //mengosongkan textfiled id dan name
        bersih();

        //menghapus isi table region
        tabelemp.getDataVector().removeAllElements();
        tabelemp.fireTableDataChanged();
        //memanggil list data tabel region dari database
        for (Employees r : iecon.search(txtsearch.getText().toString())) {
            Object[] obj = new Object[11];
            obj[0] = r.getId();
            obj[1] = r.getFirstname();
            obj[2] = r.getLastname();
            obj[3] = r.getEmail();
            obj[4] = r.getPhone();
            obj[5] = r.getHiredate();
            obj[6] = r.getJobid();
            obj[7] = r.getSalary();
            obj[8] = r.getCommission();
            obj[9] = r.getManagerid();
            obj[10] = r.getDepid();
            tabelemp.addRow(obj);
//            txtempid.setText(r.getId());   //menampilkan ke text
//            txtfname.setText(r.getFirstname());   //menampilkan ke text
//            txtlname.setText(r.getLastname());   //menampilkan ke text
//            txtemail.setText(r.getEmail());   //menampilkan ke text
//            txtphone.setText(r.getPhone());   //menampilkan ke text
//            txthdate.setText(r.getHiredate());   //menampilkan ke text
//            txtjobid.setText(r.getJobid());   //menampilkan ke text
//            txtsal.setText(r.getSalary());   //menampilkan ke text
//            txtcom.setText(r.getCommission());   //menampilkan ke text
//            txtmanid.setText(r.);   //menampilkan ke text
//            txtdepid.setText(r.getDepid());   //menampilkan ke text
        }
        SetelKolom();

    }

//    public void tampiljobid() {
//        cmbjobid.setModel(new DefaultComboBoxModel<>(new String[]{
//            "select job ID"
//        }));
//        iecon.getJobid().forEach((s) -> {
//            cmbjobid.addItem(s);
//        });
//        isitabel();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblemp = new javax.swing.JTable();
        txtempid = new javax.swing.JTextField();
        txtfname = new javax.swing.JTextField();
        txtlname = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtphone = new javax.swing.JTextField();
        txthdate = new javax.swing.JTextField();
        txtsal = new javax.swing.JTextField();
        txtcom = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        bexit = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bupdate = new javax.swing.JButton();
        bdelete = new javax.swing.JButton();
        breset = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        bsearch = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmbjobid = new javax.swing.JComboBox<>();
        cmbmanid = new javax.swing.JComboBox<>();
        cmbdepid = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblemp.setModel(new javax.swing.table.DefaultTableModel(
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
        tblemp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblempMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblemp);

        txtfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfnameActionPerformed(evt);
            }
        });

        txtlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlnameActionPerformed(evt);
            }
        });

        txthdate.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("EMPLOYEES");

        jLabel2.setText("Employee id");

        jLabel3.setText("First name");

        jLabel4.setText("Last name");

        jLabel5.setText("Email");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Hire Date");

        jLabel8.setText("Job ID");

        jLabel9.setText("Salary");

        jLabel10.setText("Commission");

        jLabel11.setText("Manager Id");

        jLabel12.setText("Dep Id");

        bexit.setText("EXIT");
        bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bexitActionPerformed(evt);
            }
        });

        bsimpan.setText("INSERT");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bupdate.setText("UPDATE");
        bupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bupdateActionPerformed(evt);
            }
        });

        bdelete.setText("DELETE");
        bdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdeleteActionPerformed(evt);
            }
        });

        breset.setText("RESET");
        breset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bresetActionPerformed(evt);
            }
        });

        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        bsearch.setText("SEARCH");
        bsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsearchActionPerformed(evt);
            }
        });

        jLabel13.setText("* dd-mm-yyyy");

        cmbjobid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbjobid.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbjobidItemStateChanged(evt);
            }
        });

        cmbmanid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbdepid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addComponent(txtempid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cmbjobid, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txthdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel10))
                                        .addGap(54, 54, 54))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(137, 137, 137)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbmanid, 0, 108, Short.MAX_VALUE)
                                    .addComponent(txtcom, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbdepid, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bupdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bdelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(breset, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(bexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtempid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(bsimpan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(bupdate)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(bdelete)
                            .addComponent(cmbjobid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbmanid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(cmbdepid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(breset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bsearch)
                    .addComponent(bexit))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfnameActionPerformed

    private void bexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bexitActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            dispose();
        }
    }//GEN-LAST:event_bexitActionPerformed

    private void tblempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblempMouseClicked
        tabelemp = (DefaultTableModel) tblemp.getModel();
        int i = tblemp.getSelectedRow();
        txtempid.setText(tabelemp.getValueAt(i, 0).toString());
        txtfname.setText(tabelemp.getValueAt(i, 1).toString());
        txtlname.setText(tabelemp.getValueAt(i, 2).toString());
        txtemail.setText(tabelemp.getValueAt(i, 3).toString());
        txtphone.setText(tabelemp.getValueAt(i, 4).toString());
        txthdate.setText(tabelemp.getValueAt(i, 5).toString());
        cmbjobid.setSelectedItem(tabelemp.getValueAt(i, 6).toString());
        txtsal.setText(tabelemp.getValueAt(i, 7).toString());
        txtcom.setText(tabelemp.getValueAt(i, 8).toString());
//        txtmanid.setText(tabelemp.getValueAt(i, 9).toString());
        cmbmanid.setSelectedItem(tabelemp.getValueAt(i, 9).toString());
//        txtdepid.setText(tabelemp.getValueAt(i, 10).toString());
        cmbdepid.setSelectedItem(tabelemp.getValueAt(i, 10).toString());
        txtempid.setEditable(false);
        bsimpan.setEnabled(false);
    }//GEN-LAST:event_tblempMouseClicked

    private void txtlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlnameActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        if (txtempid.getText().equals("") || (txtfname.getText().equals("")) || (txtlname.getText().equals("")) || (txtemail.getText().equals("")) || (txtphone.getText().equals("")) || (txthdate.getText().equals("")) || (cmbjobid.getSelectedItem().toString().equals("")) || (txtsal.getText().equals("")) || (txtcom.getText().equals("")) || (cmbmanid.getSelectedItem().toString().equals("")) || (cmbdepid.getSelectedItem().toString().equals(""))) {
            JOptionPane.showMessageDialog(rootPane, "Mohon Data di Isi Secara Lengkap !", "Warning", JOptionPane.INFORMATION_MESSAGE);
            bersih();
        } else {
            iecon.insert(txtempid.getText(), txtfname.getText(), txtlname.getText(), txtemail.getText(), txtphone.getText(), txthdate.getText(), cmbjobid.getSelectedItem().toString(), txtsal.getText(), txtcom.getText(), cmbmanid.getSelectedItem().toString(), cmbdepid.getSelectedItem().toString());
            isitabel();
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan", "Saved", JOptionPane.INFORMATION_MESSAGE);
        }

        txtempid.setEditable(true);
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bupdateActionPerformed
        if (txtempid.getText().equals("") || (txtfname.getText().equals("")) || (txtlname.getText().equals("")) || (txtemail.getText().equals("")) || (txtphone.getText().equals("")) || (txthdate.getText().equals("")) || (cmbjobid.getSelectedItem().toString().equals("")) || (txtsal.getText().equals("")) || (txtcom.getText().equals("")) || (cmbmanid.getSelectedItem().toString().equals("")) || (cmbdepid.getSelectedItem().toString().equals(""))) {
            JOptionPane.showMessageDialog(rootPane, "Mohon Data di Isi Secara Lengkap !", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            iecon.update(txtempid.getText(), txtfname.getText(), txtlname.getText(), txtemail.getText(), txtphone.getText(), txthdate.getText(), cmbjobid.getSelectedItem().toString(), txtsal.getText(), txtcom.getText(), cmbmanid.getSelectedItem().toString(), cmbdepid.getSelectedItem().toString());

            txtempid.setEditable(true);
            bsimpan.setEnabled(true);
            JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan", "Saved", JOptionPane.INFORMATION_MESSAGE);
        }
        isitabel();
    }//GEN-LAST:event_bupdateActionPerformed

    private void bdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdeleteActionPerformed
        tabelemp = (DefaultTableModel) tblemp.getModel();
        int i = tblemp.getSelectedRow();

        if (i == -1) {
            JOptionPane.showMessageDialog(rootPane, "Pilih Data Yang Mana", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {

            String del = tblemp.getModel().getValueAt(i, 0).toString();
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Yakin Akan Menghapus Data ", "Delete", dialogButton);
            if (dialogResult == 0) {
                iecon.delete(del);
                JOptionPane.showMessageDialog(rootPane, "Data Berhasil Dihapus", "Deleted", JOptionPane.INFORMATION_MESSAGE);
                isitabel();
                txtempid.setEditable(true);
                bsimpan.setEnabled(true);
            } else {
                isitabel();
                txtempid.setEditable(true);
                bsimpan.setEnabled(true);
            }
        }
    }//GEN-LAST:event_bdeleteActionPerformed

    private void bresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bresetActionPerformed
        bersih();
    }//GEN-LAST:event_bresetActionPerformed

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchKeyReleased

    private void bsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsearchActionPerformed
        Cari();
    }//GEN-LAST:event_bsearchActionPerformed

    private void cmbjobidItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbjobidItemStateChanged
        // TODO add your handling code here:
        //tampiljobid();
    }//GEN-LAST:event_cmbjobidItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VEmployees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VEmployees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bdelete;
    private javax.swing.JButton bexit;
    private javax.swing.JButton breset;
    private javax.swing.JButton bsearch;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bupdate;
    private javax.swing.JComboBox<String> cmbdepid;
    private javax.swing.JComboBox<String> cmbjobid;
    private javax.swing.JComboBox<String> cmbmanid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblemp;
    private javax.swing.JTextField txtcom;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtempid;
    private javax.swing.JTextField txtfname;
    private javax.swing.JTextField txthdate;
    private javax.swing.JTextField txtlname;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtsal;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
