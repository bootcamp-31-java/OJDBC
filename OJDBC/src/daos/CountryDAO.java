/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;
import idaos.ICountryDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Country;
/**
 *
 * @author Aseprudin
 */
public class CountryDAO implements ICountryDAO{
    
    private Connection connection;
    
    public CountryDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Country> getAll() {
        List<Country> listCountry = new ArrayList<>();
        String query = "select * from hr.countries order by 3";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listCountry.add(c);                
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listCountry;
    }

    @Override
    public List<Country> getById(String CountryId) {
        List<Country> lisCountry = new ArrayList<>();
        String query = "select * from hr.countries where country_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, CountryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                lisCountry.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return lisCountry;
    }

    @Override
    public List<Integer> getRegionId() {
        List<Integer> listRegionId = new ArrayList<>();
        String query = "select region_id from hr.regions";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                Integer r = resultSet.getInt(1);
                listRegionId.add(r);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listRegionId;
    }

    @Override
    public List<Country> search(String key) {
          List<Country> listCountry = new ArrayList<>();
        String query = "select * from hr.countries where country_id like ? or country_name like ? or region_id like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();            
            while (resultSet.next()) {                
                Country c = new Country(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3));
                listCountry.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCountry;
    }

    @Override
    public boolean insert(Country c) {
        boolean result = false;
        String query = "Insert into HR.COUNTRIES(country_id, country_name, region_id) values(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getCountryId());
            preparedStatement.setString(2, c.getCountryName());
            preparedStatement.setInt(3, c.getRegionId());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Country c) {
        boolean result = false;
        String query = "update hr.countries set country_name = ?, region_id = ? where country_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareCall(query);
            preparedStatement.setString(1, c.getCountryName());
            preparedStatement.setInt(2, c.getRegionId());
            preparedStatement.setString(3, c.getCountryId()+ "");
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String CountryId) {
        boolean result = false;
        String query = "delete hr.countries where country_id = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, CountryId);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
