package pragma.team.pragmalunch.model;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Locality {
    private String city_id;

    private String city_name;

    private String title;

    private String country_id;

    private String longitude;

    private String latitude;

    private String entity_id;

    private String entity_type;

    private String country_name;

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
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

    public String getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getEntity_type() {
        return entity_type;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    @Override
    public String toString() {
        return "ClassLocality [city_id = " + city_id + ", city_name = " + city_name + ", title = " + title + ", country_id = " + country_id + ", longitude = " + longitude + ", latitude = " + latitude + ", entity_id = " + entity_id + ", entity_type = " + entity_type + ", country_name = " + country_name + "]";
    }
}


