package pragma.team.pragmalunch.interfaces;

/**
 * Created by alvaromenezes on 12/8/16.
 */

public interface RestaurantsInteractor {

    void syncronize();

    void saveVote(String restaurantID);

    boolean hasVotedToday();

    String getVoteID();

    void syncronizeVote(String restaurantID);


}
