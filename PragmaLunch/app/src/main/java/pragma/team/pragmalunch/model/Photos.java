package pragma.team.pragmalunch.model;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Photos {
    private String likes_count;

    private String timestamp;

    private String id;

    private String comments_count;

    private String height;

    private String width;

    private String res_id;

    private String thumb_url;

    private String caption;

    private String friendly_time;

    private User user;

    private String url;

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getFriendly_time() {
        return friendly_time;
    }

    public void setFriendly_time(String friendly_time) {
        this.friendly_time = friendly_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ClassPhotos [likes_count = " + likes_count + ", timestamp = " + timestamp + ", id = " + id + ", comments_count = " + comments_count + ", height = " + height + ", width = " + width + ", res_id = " + res_id + ", thumb_url = " + thumb_url + ", caption = " + caption + ", friendly_time = " + friendly_time + ", user = " + user + ", url = " + url + "]";
    }
}


