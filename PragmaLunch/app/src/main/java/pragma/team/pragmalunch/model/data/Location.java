package pragma.team.pragmalunch.model.data;

import java.io.Serializable;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Location implements Serializable {
    private String address;

    private String country_id;
    
    private String zipcode;

    private String locality;

    private String longitude;

    private String latitude;

    private String city;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ClassPojo [address = " + address + ", country_id = " + country_id + ", zipcode = " + zipcode + ", locality = " + locality + ", longitude = " + longitude + ", latitude = " + latitude + ", city = " + city + "]";
    }
}


