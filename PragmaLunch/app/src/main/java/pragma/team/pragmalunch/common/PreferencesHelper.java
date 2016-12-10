package pragma.team.pragmalunch.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by alvaromenezes on 12/9/16.
 */

public class PreferencesHelper {
    private SharedPreferences sharedPreferences;

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("PRAGMA", Context.MODE_PRIVATE);
    }

    public String getValue(String keyName) {
        return sharedPreferences.getString(keyName, "");
    }

    public void saveKey(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }


}
