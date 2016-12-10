package pragma.team.pragmalunch.presenters;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.Calendar;

import pragma.team.pragmalunch.R;
import pragma.team.pragmalunch.common.PreferencesHelper;
import pragma.team.pragmalunch.common.Settings;
import pragma.team.pragmalunch.common.Util;
import pragma.team.pragmalunch.interfaces.MainInteractor;
import pragma.team.pragmalunch.interfaces.MainPresenter;
import pragma.team.pragmalunch.interfaces.MainView;
import pragma.team.pragmalunch.model.data.Restaurant;
import pragma.team.pragmalunch.model.iteractors.MainInteractorImpl;
import pragma.team.pragmalunch.model.notification.NotificationReceiver;
import pragma.team.pragmalunch.model.service.NetworkControler;
import pragma.team.pragmalunch.view.MainActivity;
import pragma.team.pragmalunch.view.RestaurantDetailFragment;
import pragma.team.pragmalunch.view.RestaurantsFragment;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainView view;

    public MainPresenterImpl(MainView view) {
        this.view = view;

    }

    @Override
    public void init() {
        view.startApp();
    }

    @Override
    public void onTransaction(Fragment fragment) {
        final String TAG = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) view.getContext()).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main_container, fragment, TAG)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onDetailRestaurant(Restaurant restaurant) {
        RestaurantDetailFragment detailfragment = RestaurantDetailFragment.newInstance(restaurant);

        final String TAG = detailfragment.getClass().getName();

        FragmentManager fm = ((AppCompatActivity) view.getContext()).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.hide(fm.findFragmentByTag(RestaurantsFragment.class.getName()));
        ft.add(R.id.activity_main_container, detailfragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();

    }



    @Override
    public void clearOldVote() {

        String today = new Util().getCurentDate();
        PreferencesHelper pref = new PreferencesHelper(view.getContext());
        String lastVotedDay = pref.getValue(Settings.KEY_VOTE_DAY);

        if (!today.equalsIgnoreCase(lastVotedDay)) {
            pref.saveKey(Settings.KEY_VOTE_DAY, "");
            pref.saveKey(Settings.KEY_RESTAURANT_ID, "");
        }
    }

    @Override
    public void showMostVotedYesterday() {

        MainInteractor interactor = new MainInteractorImpl(this);
        interactor.showMostVoted();

    }

    public void setNotificationScheduler() {

        Context context = view.getContext();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle("Voting Closed")
                .setContentText("See the choosen restaurant")
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));


        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent activity = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(activity);

        Notification notification = builder.build();

        Intent notificationIntent = new Intent(context, NotificationReceiver.class);
        notificationIntent.putExtra(NotificationReceiver.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(NotificationReceiver.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 1, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, Settings.NOTIFICATION_HOUR);
        calendar.set(Calendar.MINUTE, Settings.NOTIFICATION_MINUTE);

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pendingIntent);


    }

    @Override
    public MainView getView() {
        return view;
    }


}
