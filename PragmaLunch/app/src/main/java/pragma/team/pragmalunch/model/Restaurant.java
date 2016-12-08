package pragma.team.pragmalunch.model;

import java.io.Serializable;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Restaurant implements Serializable {

    private String id;
    private String name;
    private Location location;
    private String cuisines;
    private String thumb;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCusines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
