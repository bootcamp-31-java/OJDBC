/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Location;

/**
 *
 * @author Rezaditya
 */
public class LocationDAO implements ILocationDAO {

    private Connection connection;

    public LocationDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Location> getAll() {
        List<Location> listLocation = new ArrayList<>();
        String query = "select * from hr.locations order by 1";
//        String query = "select l.location_id, l.street_address, l.postal_code, l.city, l.state_province, c.country_name "
//                + "from locations l, countries c "
//                + "where l.country_id=c.country_id "
//                + "order by 1";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6));
                listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return listLocation;
    }

    @Override
    public List<Location> getById(int id) {
        List<Location> listLocation = new ArrayList<>();
        String query = "SELECT * FROM HR.locations WHERE location_ID = (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6));
                listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listLocation;
    }
    
    public List<String> getIdCountry() {
        List<String> listIdCountry = new ArrayList<>();
        String query = "select country_id from hr.countries";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String c = resultSet.getString(1);
                listIdCountry.add(c);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listIdCountry;
    }

    @Override
    public List<Location> search(String key) {
        List<Location> listLocation = new ArrayList<>();
        String query = "select * from hr.locations where "
                + "location_id like ? or "
                + "street_address like ? or "
                + "postal_code like ? or "
                + "city like ? or "
                + "state_province like ? or "
                + "country_id like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + key + "%");
            preparedStatement.setString(2, "%" + key + "%");
            preparedStatement.setString(3, "%" + key + "%");
            preparedStatement.setString(4, "%" + key + "%");
            preparedStatement.setString(5, "%" + key + "%");
            preparedStatement.setString(6, "%" + key + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5),
                        resultSet.getString(6));
                listLocation.add(l);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return listLocation;
    }
    /**
     * Method untuk save data, cek kondisi data sudah ada atau belum
     * jika data tidak ada akan melakukan insert sebaliknya akan melakukan update
     * @param l
     * @return boolean
     */
    public boolean save(Location l) {
        boolean result = false;
        List<Location> list = getById(l.getId());
        //CARA I
//        String query;
//        if (list.isEmpty()) {
//            query = "insert into hr.locations(street_address, postal_code, city, "
//                + "state_province, country_id, location_id) values (?,?,?,?,?,?)";
//        }else{
//            query = "update hr.locations set street_address = ?, postal_code = ?, city = ?,"
//                + "state_province = ?, country_id = ? where location_id=?";
//        }
        //CARA II
        String query = list.isEmpty()
                ? "insert into hr.locations(street_address, postal_code, city, "
                + "state_province, country_id, location_id) values (?,?,?,?,?,?)"
                : "update hr.locations set street_address = ?, postal_code = ?, city = ?,"
                + "state_province = ?, country_id = ? where location_id=?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(6, l.getId());
            preparedStatement.setString(1, l.getStreetAdress());
            preparedStatement.setString(2, l.getPostalCode());
            preparedStatement.setString(3, l.getCity());
            preparedStatement.setString(4, l.getStateProvince());
            preparedStatement.setString(5, l.getCountryId());
            ResultSet resultSet = preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean insert(Location l) {
        boolean result = false;
        String query = "insert into hr.locations(location_id, "
                + "street_address, postal_code, city, "
                + "state_province, country_id) values "
                + "(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, l.getId());
            preparedStatement.setString(2, l.getStreetAdress());
            preparedStatement.setString(3, l.getPostalCode());
            preparedStatement.setString(4, l.getCity());
            preparedStatement.setString(5, l.getStateProvince());
            preparedStatement.setString(6, l.getCountryId());
            ResultSet resultSet = preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Location l) {
        boolean result = false;
        String query = "update hr.locations "
                + "set street_address = ?,"
                + "postal_code = ?,"
                + "city = ?,"
                + "state_province = ?,"
                + "country_id = ?"
                + " where location_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, l.getStreetAdress());
            preparedStatement.setString(2, l.getPostalCode());
            preparedStatement.setString(3, l.getCity());
            preparedStatement.setString(4, l.getStateProvince());
            preparedStatement.setString(5, l.getCountryId());
            preparedStatement.setString(6, l.getId()+"");
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "delete hr.locations where location_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
