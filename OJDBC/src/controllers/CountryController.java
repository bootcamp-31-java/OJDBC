/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import daos.CountryDAO;
import java.sql.Connection;
import java.util.List;
import models.Country;
/**
 *
 * @author Aseprudin
 */
public class CountryController implements ICountryController{
    private ICountryDAO icdao;

    public CountryController(Connection connection) {
        icdao =  new CountryDAO(connection);
    }
    
    public CountryController() {
    }

    @Override
    public List<Country> getAll() {
        return icdao.getAll();
    }

    @Override
    public List<Country> getById(String countryId) {
        return icdao.getById(countryId);
    }

    @Override
    public List<Integer> getIdRegion() {
        return icdao.getRegionId();
    }

    @Override
    public List<Country> search(String key) {
        return icdao.search(key);
    }

    @Override
    public String insert(String countryId, String countryName, int regionId) {
        String result = "";
        Country country = new Country(countryId, countryName, regionId);
        if (icdao.insert(country)) {
            result = "Insert Success";
        } else {
            result = "Insert Failed";
        }
        return result;
    }

    @Override
    public String update(String countryId, String countryName, int regionId) {
        String result = "";
        Country country = new Country(countryId, countryName, regionId);
        if (icdao.update(country)) {
            result = "Update Success";
        } else {
            result = "Update Failed";
        }
        return result;
    }

    @Override
    public String delete(String countryId) {
        String result = "";
        if (icdao.delete(countryId)) {
            result = "Delete Success";
        } else {
            result = "Delete Failed";
        }
        return result;
    }
    
}
