/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Account;

/**
 *
 * @author Rezaditya
 */
public interface IAccountDAO {

    boolean delete(int id);

    List<Account> getById(int id);

    boolean insert(Account a);
    
    List<String> getIdEmployee();
    
    public List<String> getPassByUsername(String username);
    
}
