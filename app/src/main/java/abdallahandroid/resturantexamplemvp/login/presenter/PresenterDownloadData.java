package abdallahandroid.resturantexamplemvp.login.presenter;

import android.content.Context;
import android.os.Handler;

import abdallahandroid.resturantexamplemvp.login.model.AuthenticaitonData;
import abdallahandroid.resturantexamplemvp.login.model.networkChecker;
import abdallahandroid.resturantexamplemvp.login.model.waitingForDownload;
import abdallahandroid.resturantexamplemvp.login.view.IAuthentication;
import abdallahandroid.resturantexamplemvp.login.view.IDownload;


public class PresenterDownloadData implements IPresenterDonwloadDownload {

    IDownload IDown ;
    Context mContext;
    private networkChecker internet;
    IAuthentication iAuth;
    AuthenticaitonData  authData;
    waitingForDownload wait;


    public PresenterDownloadData(Context ctx, IDownload IDown, IAuthentication iAuth){
        this.IDown = IDown;
        mContext = ctx;
        internet = new networkChecker();
        this.iAuth = iAuth;
        authData = new AuthenticaitonData();
        wait = new waitingForDownload(mContext, this);
    }


    @Override
    public void checkAuthenticationToCanStartDownloadData(String enteryEmail , String enteryPass) {
        boolean checkEmail = ( enteryEmail != null   ) && ( enteryEmail.length() > 1 );
        boolean checkPass = ( enteryPass != null   ) && ( enteryPass.length() > 1 );
        if  ( checkEmail && checkPass){
            if (internet.isNetworkAvailable(mContext ) ){
                IDown.progressbarVisible_whileLoading();
                authData.checkAuthentication(this, enteryEmail, enteryPass);

            } else{
                IDown.messageNoInterenetConnection();
            }
            //print message entery is null
        } else if (! checkEmail ){
            IDown.emailEmpty();
        } else if ( ! checkPass  ){
            IDown.passEmpty();
        }
    }

    @Override
    public void startDownload() {
        //waiting for download
        wait.startDownloadAllData_nameAndImage();
        wait.waitingForDownloadComplete( );
    }

    @Override
    public void completeDownload(boolean AuthenticationOk, String mess) {
        //open next page when IAuthentication ok
        System.out.println("presenterDownload - auth: " + AuthenticationOk);
        if (AuthenticationOk){
            iAuth.successAuth(mess);
            //visibily wedgits  wait to go to next slide
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    IDown.progressBarGone_afterFinishDownload();
                }
            }, 2000);

        //faild auth
        } else {
            IDown.progressBarGone_afterFinishDownload();
            iAuth.faildAuth(mess);
        }


    }
}
