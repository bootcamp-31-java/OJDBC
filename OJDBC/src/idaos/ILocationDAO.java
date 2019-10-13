/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author Rezaditya
 */
public interface ILocationDAO {

    boolean delete(int id);

    List<Location> getAll();
    
    List<String> getIdCountry();

    List<Location> getById(int id);

    boolean insert(Location l);

    List<Location> search(String key);

    boolean update(Location l);
    
}
