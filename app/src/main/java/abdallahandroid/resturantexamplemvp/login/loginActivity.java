package abdallahandroid.resturantexamplemvp.login;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.FoodCategoryActivity;
import abdallahandroid.resturantexamplemvp.login.view.IDownload;
import abdallahandroid.resturantexamplemvp.login.presenter.PresenterOnCreate;
import abdallahandroid.resturantexamplemvp.login.presenter.PresenterDownloadData;
import abdallahandroid.resturantexamplemvp.login.view.IAuthentication;
import abdallahandroid.resturantexamplemvp.login.view.onCreateLogin;
import es.dmoral.toasty.Toasty;

public class loginActivity extends AppCompatActivity implements
        onCreateLogin,
        IAuthentication, IDownload {

    Context mContext;
    Activity mActivity;

    Button btLogin;
    EditText edEmail ;
    ProgressBar progress;
    EditText edPass;
    LinearLayout layoutButtons;

    PresenterOnCreate prestOnCreate;
    PresenterDownloadData prestDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = getBaseContext();
        mActivity = this;
        edEmail = findViewById(R.id.edEmail);
        edPass = findViewById(R.id.edPass);
        btLogin = findViewById(R.id.btLogin);
        layoutButtons = findViewById(R.id.layoutButtons);
        progress = findViewById(R.id.progress);

        //onCreate login
        prestOnCreate = new PresenterOnCreate(this);

        //downlaod data to make autentication
        prestDownload = new PresenterDownloadData(mContext, this, this);


        buttonLogin();
    }

    private void buttonLogin() {
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteryEmail = edEmail.getText().toString();
                String enteryPass = edPass.getText().toString();
                prestDownload.checkAuthenticationToCanStartDownloadData(enteryEmail, enteryPass);

            }
        });
    }

    /////////////////////////////////////////////////////// method of interface:  onCreateLogin

    @Override
    public void animationSlide() {
        //animation
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition( new Slide(Gravity.RIGHT).setDuration(600) ); //set duration وقت التحرك
            getWindow().setExitTransition(new Slide(Gravity.LEFT).setDuration(600));  //when exist activity go right not left
        }
    }

    @Override
    public void getOldDataEnteredByUserToBeSetInsideEditText() {
       edEmail.setText("test@gmail.com");
        edPass.setText("123456");
    }

    /////////////////////////////////////////////////////// method of interface:  IDownload

    @Override
    public void progressbarVisible_whileLoading() {
        //visibily wedgits
        layoutButtons.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void progressBarGone_afterFinishDownload() {
        // make edittext pass and email be visible agin
        layoutButtons.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);
    }

    @Override
    public void emailEmpty() {
        Animation hyperspaceJump = AnimationUtils.loadAnimation(mContext, R.anim.translate_button);
        edEmail.startAnimation(hyperspaceJump);
    }

    @Override
    public void passEmpty() {
        Animation hyperspaceJump = AnimationUtils.loadAnimation(mContext, R.anim.translate_button);
        edPass.startAnimation(hyperspaceJump);
    }


    @Override
    public void messageNoInterenetConnection() {
        Toast.makeText(mContext, "No internet connection !", Toast.LENGTH_SHORT).show();
    }

    /////////////////////////////////////////////////////// method of interface:  IAuthentication
    @Override
    public void successAuth(String mess) {
        Toasty.success(mContext, mess, Toast.LENGTH_SHORT, true).show();
        //open image of food activity
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity);
            Intent i = new Intent(mContext, FoodCategoryActivity.class);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(mContext, FoodCategoryActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void faildAuth(String mess) {

        Toasty.error(mContext, mess, Toast.LENGTH_SHORT, true).show();

    }



}
