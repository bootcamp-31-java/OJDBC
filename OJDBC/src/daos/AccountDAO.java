/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IAccountDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Account;

/**
 *
 * @author Rezaditya
 */
public class AccountDAO implements IAccountDAO {

    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Account> getById(int id) {
        List<Account> listAccount = new ArrayList<>();
        String query = "SELECT * FROM HR.account WHERE employee_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Account l = new Account(resultSet.getInt(1),
                        resultSet.getString(3), resultSet.getString(2));
                listAccount.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listAccount;
    }
    
    @Override
    public List<String> getIdEmployee() {
        List<String> listIdEmployee = new ArrayList<>();
        String query = "select employee_id from hr.employees";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String c = resultSet.getString(1);
                listIdEmployee.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listIdEmployee;
    }
   
    @Override
    public List<String> getPassByUsername(String username) {
        List<String> listIdEmployee = new ArrayList<>();
        String query = "select password from hr.account where username=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String l = resultSet.getString(1);
                listIdEmployee.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listIdEmployee;
    }
    
    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "delete hr.account where employee_id=(?)";
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

    @Override
    public boolean insert(Account a) {
        boolean result = false;
        String query = "insert into hr.account(employee_id, password, username)"
                + " values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, a.getEmployeeId());
            preparedStatement.setString(2, a.getPassword());
            preparedStatement.setString(3, a.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }
}
