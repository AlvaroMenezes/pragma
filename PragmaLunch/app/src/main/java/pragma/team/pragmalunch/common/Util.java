package pragma.team.pragmalunch.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Util {

    public String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI = telephonyManager.getDeviceId();
        return IMEI;
    }

    public String getCurentDate() {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(new Date());

        return data.toString();
    }

    public String getCurentHour() {

        SimpleDateFormat df = new SimpleDateFormat("kkmm");
        String data = df.format(new Date());

        return data.toString();
    }


    public boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
