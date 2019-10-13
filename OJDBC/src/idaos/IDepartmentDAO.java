/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Department;

/**
 *
 * @author Faisal Dwi Rahmanto
 */
public interface IDepartmentDAO {
    
    /**
     * fungsi untuk mendapatkan/menampilakan semua data dari tabel Department
     *
     * @return nilai kembalian berupa list
     */
    public List<Department> getAll();
        
    /**
     * fungsi untuk mendapatkan/menampilkan data
     * dari tabel Departmnet berdasarkan department id
     *
     * @param dptid bertipe string
     * @return nilai yang dibalikan/kembalikan berupa list
     */
    public List<Department> getById(String dptid);
    
    /**
     * fungsi untuk mendapatkan/menampilkan data
     * dari tabel Department berdasarkan inputan
     *
     * @param key bertipe string
     * @return nilai kembalian berupa list
     */
    public List<Department> search(String key);
    
  
    public boolean insertupdate(Department d,boolean isUpdate);
  
    /**
     * fungsi untuk menghapus data pada tabel Department berdasarkan department id
     *
     * @param del bertipe string
     * @return nilai kembalian berupa boolean
     */
    public boolean delete(String del);
    
    /**
     * fungsi untuk mendapatkan/menampilkan data
     * dari tabel Departmnet berdasarkan department name
     *
     * @param dptname bertipe string
     * @return nilai kembalian berupa list
     */
  
}
