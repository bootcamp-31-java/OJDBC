package tools;

import daos.EmployeesDAO;
import daos.RegionDAO;
import idaos.IRegionDAO;
import java.util.List;
import models.Employees;
import models.Region;
import tools.DBConnection;

public class OJDBC {

    public static void cetak(List<Region> regions) {
        for (Region reg : regions) {
            System.out.println(reg.getId());
            System.out.println(reg.getName());
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
        //RegionDAO rdao = new RegionDAO(connection.getConnection());
        //Region r= new Region(5, "Jauh Sekali");
        /*cetak(rdao.getAll());
        System.out.println("================");
        System.out.println("Coba Insert");
        System.out.println("================");
        System.out.println("Insert "+rdao.insert(r));
        cetak(rdao.getAll());
        r = new Region(5, "Nan Jauh dimato");
        System.out.println("================");
        System.out.println("Coba Update");
        System.out.println("================");
        System.out.println("Update "+rdao.update(r));
        cetak(rdao.getAll());
        System.out.println("================");
        System.out.println("Coba GetById");
        System.out.println("================");
        cetak(rdao.getById(5));
        System.out.println("================");
        System.out.println("Coba Delete");
        System.out.println("================");
        System.out.println("Delete "+rdao.delete(5));
        cetak(rdao.getAll());
         */
        
        EmployeesDAO edao = new EmployeesDAO(connection.getConnection());
        /*for (Employees emp : edao.search("1002")) {
            System.out.println(emp.getId());
            System.out.println(emp.getFirstname());
            System.out.println(emp.getLastname());
            System.out.println(emp.getEmail());
            System.out.println(emp.getPhone());
            System.out.println(emp.getHiredate());
            System.out.println(emp.getJobid());
            System.out.println(emp.getSalary());
            System.out.println(emp.getCommission());
            System.out.println(emp.getManagerid());
            System.out.println(emp.getDepid());
        }*/
        
        //Employees emp1 = new Employees(1002, "sandy", "putra", "sSandypu", "0896", "10-10-2019", "AD_VP", 1000,0 , 100, 80);
        //edao.insert(emp1);
        
       //Employees emp2 = new Employees(1002, "putra", "sandy", "wawawawa", "0812", "10-10-2019", "IT_PROG", 4000, 0, 100, 80);
       //edao.update(emp2);
        
       //edao.delete(1002);
    }
}
