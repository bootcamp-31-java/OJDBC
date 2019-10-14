/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import idaos.IDepartmentDAO;
import icontrollers.IDepartmentController;
import models.Department;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author Faisal Dwi Rahmanto
 */
public class DepartmentController implements IDepartmentController{
    
    private IDepartmentDAO idepcon;
    

    public DepartmentController(Connection connection){
        idepcon = new DepartmentDAO(connection);
    }

    
  
    @Override
    public List<Department> getAll() {
        return idepcon.getAll();
    }

    /**
     * fungsi untuk mendapatkan/menampilkan data Department berdasarkan department id
     * @param id bertipe string
     * @return nilai kembalian berupa list
     */
    @Override
    public List<Department> getById(String dptid) {
        return idepcon.getById(dptid);
    }



    @Override
    public List<Department> search(String key) {
        return idepcon.search(key);
    }

    
    @Override
    public String insert(String dptid, String dptname, int mgrid, int locid) {
        String result;
        Department d = new Department(dptid, dptname, mgrid, locid);
        if(idepcon.insertupdate(d, false)){
            result = "Insert data success";
        }else{
            result = "Insert data failed";
        }
        return result;
    }
    
    
    @Override
    public String update(String dptid, String dptname, int mgrid, int locid) {
        String result;
        Department d = new Department(dptid, dptname, mgrid, locid);
        if(idepcon.insertupdate(d, true)){
            result = "Update data success";
        }else{
            result = "Update data failed";
        }
        return result;
    }
    
   
    @Override
    public String delete(String id) {
        String result = "";
        if(idepcon.delete(id)){
            result = "Delete data success";
        }else{
            result = "Delete data failed";
        }
        return result;     }

   
}
