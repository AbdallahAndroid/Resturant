package abdallahandroid.resturantexamplemvp.login.model;

import android.content.Context;

import abdallahandroid.resturantexamplemvp.login.presenter.IPresenterDonwloadDownload;
import abdallahandroid.resturantexamplemvp.login.view.IAuthentication;
import abdallahandroid.resturantexamplemvp.login.view.IDownload;
import abdallahandroid.resturantexamplemvp.login.presenter.IPresenterDonwloadDownload;

public interface IWaiting {

    void startDownloadAllData_nameAndImage( );
    void downloadNameArray();
    void downloadImageArray();
    void downloadNameArabic();
    void downloadDescriptionEnglish();

    void waitingForDownloadComplete( );
    boolean checkArraylistIntitlizeComplete();
}
