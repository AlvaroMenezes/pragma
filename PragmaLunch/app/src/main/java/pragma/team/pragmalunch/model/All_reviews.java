package pragma.team.pragmalunch.model;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class All_reviews {
    private String timestamp;

    private String rating_text;

    private String id;

    private String comments_count;

    private String rating_color;

    private String likes;

    private String rating;

    private User user;

    private String review_text;

    private String review_time_friendly;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getRating_text() {
        return rating_text;
    }

    public void setRating_text(String rating_text) {
        this.rating_text = rating_text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments_count() {
        return comments_count;
    }

    public void setComments_count(String comments_count) {
        this.comments_count = comments_count;
    }

    public String getRating_color() {
        return rating_color;
    }

    public void setRating_color(String rating_color) {
        this.rating_color = rating_color;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public String getReview_time_friendly() {
        return review_time_friendly;
    }

    public void setReview_time_friendly(String review_time_friendly) {
        this.review_time_friendly = review_time_friendly;
    }

    @Override
    public String toString() {
        return "ClassAll_reviews [timestamp = " + timestamp + ", rating_text = " + rating_text + ", id = " + id + ", comments_count = " + comments_count + ", rating_color = " + rating_color + ", likes = " + likes + ", rating = " + rating + ", user = " + user + ", review_text = " + review_text + ", review_time_friendly = " + review_time_friendly + "]";
    }
}


