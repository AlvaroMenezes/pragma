package pragma.team.pragmalunch.model.data;

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
    private int votes;
    private int average_cost_for_two;
    private String currency;
    private String book_url;
    private UserRating user_rating;
    private boolean hasVoteToday;

    public boolean hasVoteToday() {
        return hasVoteToday;
    }

    public void setHasVoteToday(boolean hasVoteToday) {
        this.hasVoteToday = hasVoteToday;
    }

    public int getAverage_cost_for_two() {
        return average_cost_for_two;
    }

    public UserRating getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(UserRating user_rating) {
        this.user_rating = user_rating;
    }

    public void setAverage_cost_for_two(int average_cost_for_two) {
        this.average_cost_for_two = average_cost_for_two;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBook_url() {
        return book_url;
    }

    public void setBook_url(String book_url) {
        this.book_url = book_url;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

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
