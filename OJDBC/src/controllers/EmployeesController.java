/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeesDAO;
import daos.EmployeesDAO;
import icontrollers.IEmployeesController;
import idaos.IEmployeesDAO;
import java.awt.Color;
import java.sql.Connection;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.Employees;
import tools.DBConnection;
import views.VEmployees;

/**
 *
 * @author sandi1713
 */
public class EmployeesController implements IEmployeesController {

    private EmployeesDAO edao;
    VEmployees form;

    public EmployeesController(Connection connection) {
        edao = new EmployeesDAO(connection);
    }
//    
//    public void isiTable() {
//        list = model.getAll();
//        //Script agar jtable tidak bisa di edit
//        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return false;
//            }
//        };
//
//        Object[] data = new Object[header.length];
//        for (Employees e : list) {
//            data[0] = e.getId();
//            data[1] = e.getFirstname();
//            data[2] = e.getLastname();
//            data[3] = e.getEmail();
//            data[4] = e.getPhone();
//            data[5] = e.getHiredate();
//            data[6] = e.getJobid();
//            data[7] = e.getSalary();
//            data[8] = e.getCommission();
//            data[9] = e.getManagerid();
//            data[10] = e.getDepid();
//            tblModel.addRow(data);
//        }
//        form.getTblemp().setModel(tblModel);
//     
//    }

    @Override
    public String delete(String id) {
        String result = "";
        if (edao.delete(Integer.parseInt(id))) {
            result = "Data Berhasil Dihapus";
        } else {
            result = "Maaf data gagal dihapus";
        }
        return result;
    }

    @Override
    public List<Employees> getAll() {
        return edao.getAll();
    }

    @Override
    public Employees getById(String id) {
        return edao.getById(Integer.parseInt(id)).get(0);
    }

    @Override
    public String insert(String id, String firstname, String lastname, String email, String phone, String hiredate, String jobid, String salary, String commission, String managerid, String depid) {
        String result = "";
        Employees employees = new Employees(Integer.parseInt(id), firstname, lastname, email, phone, hiredate, jobid, Integer.parseInt(salary), Float.parseFloat(commission), Integer.parseInt(managerid), Integer.parseInt(depid));
        if (edao.insert(employees)) {
            result = "data berhasil disimpan";
        } else {
            result = "maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public List<Employees> search(String key) {
        return edao.search(key);
    }

    @Override
    public String update(String id, String firstname, String lastname, String email, String phone, String hiredate, String jobid, String salary, String commission, String managerid, String depid) {
        Employees e = new Employees(Integer.parseInt(id), firstname, lastname, email, phone, hiredate, jobid, Integer.parseInt(salary), Float.parseFloat(commission), Integer.parseInt(managerid), Integer.parseInt(depid));
        if (edao.update(e)) {
            return "Update data success";
        } else {
            return "Update data failed";
        }

    }

    public List<String> getJobid() {
        return edao.getJobid();
    }

    public List<String> getManid() {
        return edao.getManid();
    }

    public List<String> getDepid() {
        return edao.getDepid();
    }

}
