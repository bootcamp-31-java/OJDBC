/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Job;

/**
 *
 * @author User
 */
public class JobDAO implements IJobDAO {

    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Job> getAll() {
        List<Job> listJob = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJob.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJob;
    }

    @Override
    public List<Job> getById(String id) {
        List<Job> listJob = new ArrayList<Job>();
        String query = "SELECT * FROM HR.JOBS WHERE JOB_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job r = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJob.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJob;
    }

    @Override
    public List<Job> search(String key) {
        List<Job> listJob = new ArrayList<>();
        String query = "select * from hr.jobs where "
                + "job_id like ? or "
                + "job_title like ? or "
                + "min_salary like ? or "
                + "max_salary like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");
            preparedStatement.setString(4, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j = new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                listJob.add(j);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listJob;
    }

    @Override
    public boolean insert(Job j) {
        boolean result = false;
        String query = "INSERT INTO HR.JOBS(JOB_ID, JOB_TITLE, MIN_SALARY, MAX_SALARY) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJob_id());
            preparedStatement.setString(2, j.getJob_title());
            preparedStatement.setInt(3, j.getMin_salary());
            preparedStatement.setInt(4, j.getMax_salary());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Job j) {
        boolean result = false;
        String query = "UPDATE HR.JOBS SET JOB_TITLE = ?, MIN_SALARY = ?, MAX_SALARY = ? WHERE JOB_ID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(4, j.getJob_id());
            preparedStatement.setString(1, j.getJob_title());
            preparedStatement.setInt(2, j.getMin_salary());
            preparedStatement.setInt(3, j.getMax_salary());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String query = "DELETE HR.JOBS WHERE JOB_ID=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
