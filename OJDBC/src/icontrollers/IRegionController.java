/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Region;

/**
 *
 * @author User
 */
public interface IRegionController {

    String delete(String id);

    List<Region> getAll();

    Region getById(String id);

    String insert(String id, String name);

    List<Region> search(String key);

    String update(String id, String name);
    
}
