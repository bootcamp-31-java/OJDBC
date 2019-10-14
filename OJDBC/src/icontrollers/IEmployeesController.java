/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Employees;

/**
 *
 * @author sandi1713
 */
public interface IEmployeesController {
    String delete(String id);

    List<Employees> getAll();

    Employees getById(String id);
    
    List<String> getJobid();
    
    List<String> getManid();
    
    List<String> getDepid();

    String insert(String id, String firstname, String lastname, String email, String phone, String hiredate, String jobid, String salary, String commission, String managerid, String depid);

    List<Employees> search(String key);

    String update(String id, String firstname, String lastname, String email, String phone, String hiredate, String jobid, String salary, String commission, String managerid, String depid);
}
