package tools;

import daos.LocationDAO;
import daos.RegionDAO;
import idaos.IRegionDAO;
import java.util.List;
import models.Location;
import models.Region;
import tools.DBConnection;

public class OJDBC {

    public static void cetak(List<Region> regions) {
        for (Region reg : regions) {
            System.out.println(reg.getId());
            System.out.println(reg.getName());
        }
    }
    
    public static void cetakLocations(List<Location> locations) {
        for (Location loc : locations) {
            System.out.print(loc.getId() + " | ");
            System.out.print(loc.getStreetAdress() + " | ");
            System.out.print(loc.getPostalCode() + " | ");
            System.out.print(loc.getCity() + " | ");
            System.out.print(loc.getStateProvince() + " | ");
            System.out.println(loc.getCountryId());
        }
    }

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());

//        //cara 2 pake method setter
//        Region region = new Region();
//        region.setId(0);
//        region.setName("region");
//        System.out.println(region.getId() + " " + region.getName());
//        
//        //cara 2 pake construction
//        Region r = new Region(1, "Region New");
//        System.err.println(r.getId()+ " " + r.getName());
//        RegionDAO rdao = new RegionDAO(connection.getConnection());
        //insert
//        Region r1 = new Region(8, "Helos");
//        rdao.insert(r1);
        //update
//        Region r1 = new Region(6, "Helowww");
//        rdao.update(r1);
//        //delete
//        rdao.delete(7);
        //Manual Test DAO getAll
//        for (Region reg : rdao.search("a")){
//            System.out.println(reg.getId());
//            System.out.println(reg.getName());
//        }
        
        RegionDAO rdao = new RegionDAO(connection.getConnection());
        Region r = new Region(5, "Jauh Sekali");
        
        LocationDAO ldao = new LocationDAO(connection.getConnection());
        cetakLocations(ldao.getAll()); System.out.println("++++");
        
        cetakLocations(ldao.getById(1000)); System.out.println("++++"); //getById 
        
        cetakLocations(ldao.search("U")); System.out.println("++++"); //search
        
        Location l = new Location(3300, "JL Convair", "10620", "Jakarta Pusat", "Jakarta", "UK"); System.out.println("++++");
        ldao.insert(l); System.out.println("++++");
        
        l = new Location(3300, "JL Convair", "55555", "Jakarta Pusat", "Jakarta", "UK"); System.out.println("++++");
        ldao.update(l);
        cetakLocations(ldao.getAll()); System.out.println("++++");
        
        ldao.delete(3300);
        cetakLocations(ldao.getAll()); System.out.println("++++");
        

//        cetak(rdao.getAll());
//        System.out.println("================");
//        System.out.println("Coba Insert");
//        System.out.println("================");
//        System.out.println("Insert " + rdao.insert(r));
//        cetak(rdao.getAll());
//        r = new Region(5, "Nan Jauh dimato");
//        System.out.println("================");
//        System.out.println("Coba Update");
//        System.out.println("================");
//        System.out.println("Update " + rdao.update(r));
//        cetak(rdao.getAll());
//        System.out.println("================");
//        System.out.println("Coba GetById");
//        System.out.println("================");
//        cetak(rdao.getById(5));
//        System.out.println("================");
//        System.out.println("Coba Delete");
//        System.out.println("================");
//        System.out.println("Delete " + rdao.delete(5));
//        cetak(rdao.getAll());
    }
}
