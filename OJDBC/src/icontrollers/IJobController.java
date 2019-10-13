/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public interface IJobController {
    List<Job> getAll();
    Job getById (String job_id);
    List<Job> search (String key);
    String insert (String job_id, String job_title, int min_salary, int max_salary);
    String update (String job_id, String job_title, int min_salary, int max_salary);
    String delete (String job_id);
    
}
