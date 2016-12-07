package pragma.team.pragmalunch.model;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Popularity {
    private String[] top_cuisines;

    private String nightlife_index;

    private String popularity;

    public String[] getTop_cuisines() {
        return top_cuisines;
    }

    public void setTop_cuisines(String[] top_cuisines) {
        this.top_cuisines = top_cuisines;
    }

    public String getNightlife_index() {
        return nightlife_index;
    }

    public void setNightlife_index(String nightlife_index) {
        this.nightlife_index = nightlife_index;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "ClassPopularity [top_cuisines = " + top_cuisines + ", nightlife_index = " + nightlife_index + ", popularity = " + popularity + "]";
    }
}


