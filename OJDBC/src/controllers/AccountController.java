/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import icontrollers.IAccountController;
import java.sql.Connection;
import java.util.List;
import models.Account;
import tools.BCrypt;

/**
 *
 * @author Rezaditya
 */
public class AccountController implements IAccountController {

    private AccountDAO adao;

    public AccountController(Connection connection) {
        adao = new AccountDAO(connection);
    }

    @Override
    public String delete(int id) {
        if (adao.delete(id)) {
            return "Delete data success";
        } else {
            return "Delete data failed";
        }
    }

    @Override
    public List<Account> getById(int id) {
        return adao.getById(id);
    }

    //private BCrypt bcrypt = new BCrypt();
    
    @Override
    public String insert(Account a) {
        a.setPassword(BCrypt.hashpw(a.getPassword(), BCrypt.gensalt()));
        if (adao.insert(a)) {
            return "Data success";
        } else {
            return "Data failed";
        }
    }

    @Override
    public boolean login(String username, String password) {
        boolean result = false;
        if (BCrypt.checkpw(password, getPassByUsername(username).get(0).toString())) {
            result = true;
        }
        return result;
    }
    
    @Override
    public List<String> getIdEmployee() {
        return adao.getIdEmployee();
    }

    @Override
    public List<String> getPassByUsername(String username) {
        return adao.getPassByUsername(username);
    }

}
