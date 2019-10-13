/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Location;

/**
 *
 * @author Rezaditya
 */
public interface ILocationController {

    String delete(int id);

    List<Location> getAll();
    
    List<String> getIdCountry();

    Location getById(int id);

    String insert(int id, String streetAdress, String postalCode, String city, String stateProvince, String countryId);

    List<Location> search(String key);

    String update(int id, String streetAdress, String postalCode, String city, String stateProvince, String countryId);
    
}
