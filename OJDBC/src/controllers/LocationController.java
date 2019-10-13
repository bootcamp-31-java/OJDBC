/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.ILocationController;
import daos.LocationDAO;
import java.sql.Connection;
import java.util.List;
import models.Location;

/**
 *
 * @author Rezaditya
 */
public class LocationController implements ILocationController {

    private LocationDAO ldao;

    public LocationController(Connection connection) {
        ldao = new LocationDAO(connection);
    }

    @Override
    public String insert(int id, String streetAdress, String postalCode, String city,
            String stateProvince, String countryId) {
        Location l = new Location(id, streetAdress, postalCode, city, stateProvince, countryId);
        if (ldao.insert(l)) {
            return "Insert data success";
        } else {
            return "Insert data failed";
        }
    }
    
    @Override
    public String update(int id, String streetAdress, String postalCode, String city,
            String stateProvince, String countryId) {
        Location l = new Location(id, streetAdress, postalCode, city, stateProvince, countryId);
        if (ldao.update(l)) {
            return "Update data success";
        } else {
            return "Update data failed";
        }
    }
    
    @Override
    public String delete(int id) {
        if (ldao.delete(id)) {
            return "Delete data success";
        } else {
            return "Delete data failed";
        }
    }
    
    @Override
    public List<Location> getAll(){
        return ldao.getAll();
    }
    
    @Override
    public List<String> getIdCountry(){
        return ldao.getIdCountry();
    }
    
    @Override
    public Location getById(int id){
        return (Location) ldao.getById(id); //????
    }

    @Override
    public List<Location> search(String key){
        return ldao.search(key);
    }
}
