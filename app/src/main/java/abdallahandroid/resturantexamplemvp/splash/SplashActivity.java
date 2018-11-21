package abdallahandroid.resturantexamplemvp.splash;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.splash.presenter.PresenterSplash;
import abdallahandroid.resturantexamplemvp.splash.view.ISplash;
import abdallahandroid.resturantexamplemvp.OnBoard.onBoradActivity;
import abdallahandroid.resturantexamplemvp.OnBoard.onBoradActivity;
import abdallahandroid.resturantexamplemvp.splash.presenter.PresenterSplash;

public class SplashActivity extends AppCompatActivity implements ISplash {

    Context mContext;
    Activity mActivity;

    PresenterSplash presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext = getBaseContext();
        mActivity = this;

        //presenter
        presenter = new PresenterSplash(mActivity, this);



    }



    @Override
    public void handlerToOpenNextPage() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity);
                    Intent i = new Intent(mContext, onBoradActivity.class);
                    startActivity(i, options.toBundle());
                    finish();
                } else {
                    Intent i = new Intent(mContext, onBoradActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 1000);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    // permission denied, boo! Disable the
                    Toast.makeText(this, "لقد رفضت أذونات التي يحتاجها البرنامج قد لا يعمل البرنامج بشكل جيد. ", Toast.LENGTH_LONG ).show();
                }
                return;
            }
        }
    }



}
