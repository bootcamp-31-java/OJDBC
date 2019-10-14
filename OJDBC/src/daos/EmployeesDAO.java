/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeesDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Employees;
import tools.DBConnection;

/**
 *
 * @author sandi1713
 */
public class EmployeesDAO implements IEmployeesDAO{
    
    public EmployeesDAO() {
       this.connection=connection;
    }
    
    private Connection connection;
    
    public EmployeesDAO(Connection connection){
        this.connection=connection;
    }
   
    
    @Override
    public List<Employees> getAll() {
        List<Employees> listEmployees = new ArrayList<Employees>();
        String query = "SELECT employee_id,first_name,last_name,email,phone_number,to_char(hire_date,'dd-mm-yyyy'),job_id,salary,commission_pct,manager_id,department_id FROM HR.EMPLOYEES";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employees e = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11));
                listEmployees.add(e);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listEmployees;
    }

    @Override
    public List<Employees> getById(int id) {
        List<Employees> listEmployees = new ArrayList<Employees>();
        String query = "SELECT * FROM HR.EMPLOYEES WHERE EMPLOYEE_ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employees e = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11));
                listEmployees.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listEmployees;
    }

    @Override
    public List<Employees> search(String key) {
        List<Employees> listEmployees = new ArrayList<Employees>();
        String query = "SELECT employee_id,first_name,last_name,email,phone_number,to_char(hire_date,'dd-mm-yyyy'),job_id,salary,commission_pct,manager_id,department_id  FROM HR.EMPLOYEES WHERE EMPLOYEE_ID like ? or LAST_NAME like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employees e = new Employees(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getFloat(9), rs.getInt(10), rs.getInt(11));
                listEmployees.add(e);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listEmployees;
    }

    @Override
    public boolean insert(Employees e) {
        boolean result = false;
        String query = "INSERT INTO HR.EMPLOYEES(EMPLOYEE_id, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY,COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID) VALUES (?,?,?,?,?,To_date(?, 'dd-mm-yyyy'),?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, e.getId());
            preparedStatement.setString(2, e.getFirstname());
            preparedStatement.setString(3, e.getLastname());
            preparedStatement.setString(4, e.getEmail());
            preparedStatement.setString(5, e.getPhone());
            preparedStatement.setString(6, e.getHiredate());
            preparedStatement.setString(7, e.getJobid());        
            preparedStatement.setInt(8, e.getSalary());
            preparedStatement.setFloat(9, e.getCommission());
            preparedStatement.setInt(10, e.getManagerid());
            preparedStatement.setInt(11, e.getDepid());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception f){
            f.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Employees em) {
        boolean result = false;
        String query = "UPDATE HR.EMPLOYEES SET first_name=?, last_name=?, email=?,phone_number=?, hire_date=to_date(?, 'dd-mm-yyyy'),job_id=?,salary=?,commission_pct=?,manager_id=?,department_id=? WHERE EMPLOYEE_ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(11, em.getId());
            preparedStatement.setString(1, em.getFirstname());
            preparedStatement.setString(2, em.getLastname());
            preparedStatement.setString(3, em.getEmail());
            preparedStatement.setString(4, em.getPhone());
            preparedStatement.setString(5, em.getHiredate());
            preparedStatement.setString(6, em.getJobid());
            preparedStatement.setInt(7, em.getSalary());
            preparedStatement.setFloat(8, em.getCommission());
            preparedStatement.setInt(9, em.getManagerid());
            preparedStatement.setInt(10, em.getDepid());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM HR.EMPLOYEES WHERE EMPLOYEE_ID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<String> getJobid() {
        List<String> listIdCountry = new ArrayList<>();
        String query = "select job_id from hr.jobs";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String c = resultSet.getString(1);
                listIdCountry.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listIdCountry;
    }
    
        public List<String> getManid() {
        List<String> listIdCountry = new ArrayList<>();
        String query = "select employee_id , last_name from hr.employees order by employee_id asc";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String c = resultSet.getString(1);
                listIdCountry.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listIdCountry;
    }
        public List<String> getDepid() {
        List<String> listIdCountry = new ArrayList<>();
        String query = "select Department_id from hr.departments";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String c = resultSet.getString(1);
                listIdCountry.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listIdCountry;
    }
    
}
