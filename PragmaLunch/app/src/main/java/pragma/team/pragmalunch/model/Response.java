package pragma.team.pragmalunch.model;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Response {


    private String link;

    private Locality locality;

    private Nearby_restaurants[] nearby_restaurants;

    private Popularity popularity;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public Nearby_restaurants[] getNearby_restaurants() {
        return nearby_restaurants;
    }

    public void setNearby_restaurants(Nearby_restaurants[] nearby_restaurants) {
        this.nearby_restaurants = nearby_restaurants;
    }

    public Popularity getPopularity() {
        return popularity;
    }

    public void setPopularity(Popularity popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "ClassResponse [link = " + link + ", locality = " + locality + ", nearby_restaurants = " + nearby_restaurants + ", popularity = " + popularity + "]";
    }
}

