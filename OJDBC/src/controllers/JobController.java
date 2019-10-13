/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobController;
import java.sql.Connection;
import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public class JobController implements IJobController {
    private JobDAO jdao;

    public JobController(Connection connection) {
        jdao = new JobDAO(connection);
    }

    @Override
    public List<Job> getAll() {
        return jdao.getAll();
    }

    @Override
    public Job getById(String job_id) {
        return jdao.getById(job_id).get(0);
    }

    @Override
    public List<Job> search(String key) {
        return jdao.search(key);
    }

    @Override
    public String insert(String job_id, String job_title, int min_salary, int max_salary) {
        Job j = new Job(job_id, job_title, min_salary, max_salary);
        if (jdao.insert(j)) {
            return "Insert data success";            
        } else {
            return "Insert data failed";
        }
    }

    @Override
    public String update(String job_id, String job_title, int min_salary, int max_salary) {
        Job j = new Job(job_id, job_title, min_salary, max_salary);
        if (jdao.update(j)) {
            return "Update data success";            
        } else {
            return "Update data failed";
        }
    }

    @Override
    public String delete(String job_id) {
        if (jdao.delete(job_id)) {
            return "Delete data success";
        } else {
            return "Delete data failed";
        }
    }
    
    
}
