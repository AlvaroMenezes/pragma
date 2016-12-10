package pragma.team.pragmalunch;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import pragma.team.pragmalunch.common.LocationHelper;
import pragma.team.pragmalunch.common.PreferencesHelper;
import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.common.Util;
import pragma.team.pragmalunch.interfaces.ApiService;
import pragma.team.pragmalunch.interfaces.MainPresenter;
import pragma.team.pragmalunch.interfaces.MainView;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.model.service.RestClient;
import pragma.team.pragmalunch.presenters.MainPresenterImpl;
import pragma.team.pragmalunch.view.MainActivity;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("pragma.team.pragmalunch", appContext.getPackageName());
    }

    @Test
    public void location() throws Exception {


        Context appContext = InstrumentationRegistry.getTargetContext();
        LocationHelper location = new LocationHelper(appContext);
        assertTrue(location.getLatitude() != 0 && location.getLongitude() != 0);
    }

    @Test
    public void lisRestaurants() throws Exception {

        ApiService service = new RestClient();
        Context appContext = InstrumentationRegistry.getTargetContext();
        LocationHelper location = new LocationHelper(appContext);
        ArrayList<Restaurant> restaurants = service.getRestaurants(location.getLatitude(), location.getLongitude());

        assertNotNull(restaurants);
    }


    @Test
    public void getIMEI() throws Exception {

        Util util = new Util();
        String imei = util.getIMEI(InstrumentationRegistry.getTargetContext());
        assertNotNull(imei);
        assertTrue(!imei.isEmpty());
    }

    @Test
    public void getCurentDate() throws Exception {

        Util util = new Util();
        String date = util.getCurentDate();
        assertNotNull(date);
        assertTrue(!date.isEmpty());
    }


    @Test
    public void getCurentHour() throws Exception {

        Util util = new Util();
        String hour = util.getCurentHour();
        assertNotNull(hour);
        assertTrue(!hour.isEmpty());
    }


    @Test
    public void preferences() throws Exception {

        Context appContext = InstrumentationRegistry.getTargetContext();

        PreferencesHelper pref = new PreferencesHelper(appContext);

        pref.saveKey(Settings.KEY_RESTAURANT_ID, "TEST XPTO");

        String voteID = pref.getValue(Settings.KEY_RESTAURANT_ID);

        assertEquals(voteID,"TEST XPTO");

    }

}
