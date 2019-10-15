/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Account;

/**
 *
 * @author Rezaditya
 */
public interface IAccountController {
    String delete(int id);

    List<Account> getById(int id);

    String insert(Account a);
    
    List<String> getIdEmployee();
    
    public List<String> getPassByUsername(String username);
    
    public boolean login(String username, String password);
}
