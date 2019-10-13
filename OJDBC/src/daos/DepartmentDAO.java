/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import models.Department;
import idaos.IDepartmentDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Faisal Dwi Rahmanto
 */
public class DepartmentDAO implements IDepartmentDAO {

    private Connection connection;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * fungsi untuk mendapatkan/menampilkan semua data pada yaitu department id,
     * department name, manager id dan location id dari tabel Department
     *
     * @return nilai kembalian berupa list
     */
    @Override
    public List<Department> getAll() {
        List<Department> listdepartment = new ArrayList<Department>();
        String query = "SELECT * FROM HR.DEPARTMENTS ORDER BY DEPARTMENT_ID";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department dep = new Department(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                dep.setDep_id(resultSet.getString(1));
                dep.setDep_name(resultSet.getString(2));
                dep.setMgr_id(resultSet.getInt(3));
                dep.setLoc_id(resultSet.getInt(4));
                listdepartment.add(dep);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listdepartment;
    }

    
    @Override
    public List<Department> getById(String dptid) {
        List<Department> listdepartment = new ArrayList<Department>();
        String query = "SELECT * FROM HR.DEPARTMENTS WHERE DEPARTMENT_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dptid);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Department department = new Department(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listdepartment.add(department);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listdepartment;
    }

    
    @Override
    public List<Department> search(String key) {
        List<Department> listdepartment = new ArrayList<Department>();
        String query = "SELECT * FROM HR.DEPARTMENTS WHERE REGEXP_LIKE(DEPARTMENT_ID, (?), 'i') OR REGEXP_LIKE(DEPARTMENT_NAME, (?), 'i') ORDER BY DEPARTMENT_ID";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Department department = new Department(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listdepartment.add(department);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return listdepartment;
    }

    @Override
    public boolean insertupdate(Department d, boolean isUpdate) {
        boolean result = false;
        String query = "INSERT INTO HR.DEPARTMENTS (DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID, DEPARTMENT_ID) VALUES (?,?,?,?) ";
        if (isUpdate) {
            query = "UPDATE HR.DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? WHERE DEPARTMENT_ID = ?";
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, d.getDep_name());
            preparedStatement.setInt(2, d.getMgr_id());
            preparedStatement.setInt(3, d.getLoc_id());
            preparedStatement.setString(4, d.getDep_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String del) {
        boolean result = false;
        String query = "DELETE FROM HR.DEPARTMENTS WHERE DEPARTMENT_ID = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, del);
            preparedStatement.execute();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    

}
