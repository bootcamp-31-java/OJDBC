/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Employees;

/**
 *
 * @author sandi1713
 */
public interface IEmployeesDAO {
    public List<Employees> getAll();
    public List<Employees> getById(int id);
    public List<Employees> search(String key);
    public boolean insert(Employees r);
    public boolean update(Employees r);
    public boolean delete (int id);   
}
