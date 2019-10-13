/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import javafx.scene.layout.Region;


/**
 *
 * @author Faisal Dwi Rahmanto
 */
public class Department  {

    private String dep_id;
    private String dep_name;
    private int mgr_id; // manager id
    private  int loc_id;// location id

    public Department() {
    }

    public Department(String dep_id, String dep_name, int mgr_id, int loc_id) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.mgr_id = mgr_id;
        this.loc_id = loc_id;
    }

    public String getDep_id() {
        return dep_id;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public int getMgr_id() {
        return mgr_id;
    }

    public void setMgr_id(int mgr_id) {
        this.mgr_id = mgr_id;
    }

    public int getLoc_id() {
        return loc_id;
    }

    public void setLoc_id(int loc_id) {
        this.loc_id = loc_id;
    }
    
    

}
