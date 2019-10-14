package tools;

import daos.JobDAO;
import daos.RegionDAO;
import idaos.IRegionDAO;
import java.util.List;
import models.Job;
import models.Region;
import tools.DBConnection;
import views.RegionView;
import views.VHome;

public class OJDBC {

    public static void cetakJob(List<Job> jobs) {
        for (Job job : jobs) {
            System.out.println(job.getJob_id());
            System.out.println(job.getJob_title());
            System.out.println(job.getMin_salary());
            System.out.println(job.getMax_salary());
        }
    }

    public static void cetak(List<Region> regions) {
        for (Region reg : regions) {
            System.out.println(reg.getId());
            System.out.println(reg.getName());
        }
    }

    public static void main(String[] args) {
        DBConnection connection = new DBConnection();
        System.out.println(connection.getConnection());

        VHome start = new VHome();
        start.setVisible(true);
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
//              JobDAO jdao = new JobDAO(connection.getConnection());
// 
//        for (Job reg : jdao.getAll()){
//            System.out.println(reg.getJob_id());
//            System.out.println(reg.getJob_title());
//            System.out.println(reg.getMin_salary());
//            System.out.println(reg.getMax_salary());
//        }
//        RegionDAO rdao = new RegionDAO(connection.getConnection());
//        Region r = new Region(5, "Jauh Sekali");
//
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
//        RegionView start = new RegionView();
//        start.setVisible(true);

        JobDAO jdao = new JobDAO(connection.getConnection());
        Job j = new Job("MODEL", "ASIK", 10, 20);

        cetakJob(jdao.search("10"));
//        System.out.println("================");
//        System.out.println("Coba Insert");
//        System.out.println("================");
//        System.out.println("Insert " + jdao.insert(j));
//        cetakJob(jdao.getAll());
//        j = new Job("MODEL", "ASIK LAHH", 10, 20);
//        System.out.println("================");
//        System.out.println("Coba Update");
//        System.out.println("================");
//        System.out.println("Update " + jdao.update(j));
//        cetakJob(jdao.getAll());
//        System.out.println("================");
//        System.out.println("Coba GetById");
//        System.out.println("================");
//        cetakJob(jdao.getById("4000"));
//        System.out.println("================");
//        System.out.println("Coba Delete");
//        System.out.println("================");
//        System.out.println("Delete " + jdao.delete("MODEL"));
//        cetakJob(jdao.getAll());

    }
}
