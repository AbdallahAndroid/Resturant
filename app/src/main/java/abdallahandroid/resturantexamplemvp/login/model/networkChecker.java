package abdallahandroid.resturantexamplemvp.login.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class networkChecker {

    public static boolean isNetworkAvailable(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean result =  activeNetworkInfo != null && activeNetworkInfo.isConnected();
        return result;
    }

}
