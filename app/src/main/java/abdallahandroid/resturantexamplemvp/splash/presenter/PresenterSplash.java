package abdallahandroid.resturantexamplemvp.splash.presenter;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.ActivityCompat;

import abdallahandroid.resturantexamplemvp.splash.view.ISplash;

public class PresenterSplash implements  IPresenterSplash{

    ISplash iSplash;
    Activity mActivity;
    public PresenterSplash(Activity mActivity, ISplash iSplash){
        this.mActivity = mActivity;
        this.iSplash = iSplash;

        startPermission();
        openAfterHandler();
    }


    @Override
    public void startPermission() {
        try{
            String [] arrayPermision_projectAcademy  = new String [] {Manifest.permission.ACCESS_NETWORK_STATE, Manifest.permission.INTERNET};
            ActivityCompat.requestPermissions(mActivity  , arrayPermision_projectAcademy, 1);
        } catch (Exception e){
            e.printStackTrace();
        } catch ( Error e){
            e.printStackTrace();
        }

    }

    @Override
    public void openAfterHandler() {
        iSplash.handlerToOpenNextPage();
    }
}
