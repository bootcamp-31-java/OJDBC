/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import icontrollers.IRegionController;
import daos.RegionDAO;
import models.Region;
import idaos.IRegionDAO;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Faisal Dwi Rahmanto
 */
public class RegionController implements IRegionController {

    private IRegionDAO rdao;

    public RegionController(Connection connection) {
        rdao = new RegionDAO(connection);
    }

    @Override
    public String insert(String id, String name) {
        Region r = new Region(Integer.parseInt(id), name);
        if (rdao.insert(r)) {
            return "Insert data success";
        } else {
            return "Insert data failed";
        }
    }

    @Override
    public String update(String id, String name) {
        Region r = new Region(Integer.parseInt(id), name);
        if (rdao.update(r)) {
            return "Update data success";
        } else {
            return "Update data failed";
        }
    }

    @Override
    public String delete(String id) {
        if (rdao.delete(Integer.parseInt(id))) {
            return "Delete data success";
        } else {
            return "Delete data failed";
        }
    }

    @Override
    public List<Region> getAll() {
        return rdao.getAll();
    }

    @Override
    public Region getById(String id) {
//        int intId = Integer.parseInt(id);
//        List<Region> regions = rdao.getById(intId);
//        Region region = regions.get(0);
        return rdao.getById(Integer.parseInt(id)).get(0);
    }

    @Override
    public List<Region> search(String key) {
        return rdao.search(key);
    }
    
  /*@Override
    public List<Region> getByName(String name) {
        return rdao.getByName(name);
    }*/
}
