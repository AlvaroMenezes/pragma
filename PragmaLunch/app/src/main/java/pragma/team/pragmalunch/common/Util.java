package pragma.team.pragmalunch.common;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by alvaromenezes on 12/7/16.
 */

public class Util {


    public String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI = telephonyManager.getDeviceId();
        return IMEI;
    }


}
