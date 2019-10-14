/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;
import models.Country;
import java.util.List;
/**
 *
 * @author Aseprudin
 */
public interface ICountryController {
    public List<Country> getAll();
    
    public List<Country> getById(String countryId);
    
    public List<Integer> getIdRegion();
    
    public List<Country> search (String key);
    
    public String insert (String countryId, String countryName, int regionId);
    
    public String update (String countryId, String countryName, int regionId);
    
    public String delete (String countryId);
    
}
