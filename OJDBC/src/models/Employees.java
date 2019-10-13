/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author sandi1713
 */
public class Employees {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String hiredate;
    private String jobid;
    private int salary;
    private int commission;
    private int managerid;
    private int depid;

    public Employees(int id, String firstname, String lastname, String email, String phone, String hiredate, String jobid, int salary, int commission, int managerid, int depid) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.hiredate = hiredate;
        this.jobid = jobid;
        this.salary = salary;
        this.commission = commission;
        this.managerid = managerid;
        this.depid = depid;
    }

    public Employees() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public int getManagerid() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }

    public int getDepid() {
        return depid;
    }

    public void setDepid(int depid) {
        this.depid = depid;
    }

}
