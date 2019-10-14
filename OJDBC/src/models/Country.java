/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Aseprudin
 */
public class Country {
    private String CountryId;
    private String CountryName;
    private int RegionId;

    public Country(String CountryId, String CountryName, int RegionId) {
        this.CountryId = CountryId;
        this.CountryName = CountryName;
        this.RegionId = RegionId;
    }
    
    public Country(){
        
    }

    public String getCountryId() {
        return CountryId;
    }

    public void setCountryId(String CountryId) {
        this.CountryId = CountryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String CountryName) {
        this.CountryName = CountryName;
    }

    public int getRegionId() {
        return RegionId;
    }

    public void setRegionId(int RegionId) {
        this.RegionId = RegionId;
    }
    
}
