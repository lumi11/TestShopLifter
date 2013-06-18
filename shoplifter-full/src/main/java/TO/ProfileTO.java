/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TO;

import java.io.Serializable;

/**
 *
 * @author martin
 */
public class ProfileTO implements Serializable {
    
    private String name;
    private String surrname;
    private String city;
    private String street;
    private String streetNo;
    private String zipCode;
    private Long id;

    public ProfileTO() {
        name = "Jan";
        surrname = "Juhas";
        city = "Brno";
        street = "Klacelova";
        streetNo = "2";
        zipCode = "60200";
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurrname() {
        return surrname;
    }

    public void setSurrname(String surrname) {
        this.surrname = surrname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    
    
}
