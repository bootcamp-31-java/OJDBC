/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Country;
/**
 *
 * @author Aseprudin
 */
public interface ICountryDAO {
    
    List<Country> getAll();
    
    List<Country> getById(String CountryId);
    
    List<Integer> getRegionId();
    
    List<Country> search(String key);
    
    boolean insert (Country c);
    
    boolean update (Country c);
    
    boolean delete (String CountryId);
}
