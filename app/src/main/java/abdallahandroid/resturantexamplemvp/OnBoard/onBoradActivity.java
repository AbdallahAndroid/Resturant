package abdallahandroid.resturantexamplemvp.OnBoard;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import abdallahandroid.resturantexamplemvp.OnBoard.presenter.PresenterDone;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.PresenterOnCreateBoard;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.PresenterPageChangeImagePoint;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.MyPagerAdapter;
import abdallahandroid.resturantexamplemvp.OnBoard.view.IDone;
import abdallahandroid.resturantexamplemvp.OnBoard.view.IOnCreateBoard;
import abdallahandroid.resturantexamplemvp.OnBoard.view.IPageChangeTheImagePoint;
import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.login.loginActivity;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.MyPagerAdapter;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.PresenterDone;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.PresenterOnCreateBoard;
import abdallahandroid.resturantexamplemvp.OnBoard.presenter.PresenterPageChangeImagePoint;
import abdallahandroid.resturantexamplemvp.OnBoard.view.IDone;
import abdallahandroid.resturantexamplemvp.OnBoard.view.IOnCreateBoard;
import abdallahandroid.resturantexamplemvp.OnBoard.view.IPageChangeTheImagePoint;

public class onBoradActivity extends AppCompatActivity implements
        IOnCreateBoard, IPageChangeTheImagePoint, IDone {

    public static Context mContext;
    Activity mActivity;


    ImageView imPoint1, imPoint2, imPoint3, imPoint4, imPoint5;

    PresenterOnCreateBoard presOnCreate;
    PresenterPageChangeImagePoint presentPoint;
    PresenterDone presentDone;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_borad);
        mContext = getBaseContext();
        mActivity = this;
        imPoint1 = findViewById(R.id.im1);
        imPoint2 = findViewById(R.id.im2);
        imPoint3 = findViewById(R.id.im3);
        imPoint4 = findViewById(R.id.im4);
        imPoint5 = findViewById(R.id.im5);
        pager = (ViewPager) findViewById(R.id.viewPager);

        //on create presenter
        presOnCreate = new PresenterOnCreateBoard(mActivity, this);

        // presenter animation in image point of board
        presentPoint = new PresenterPageChangeImagePoint(mActivity, this);

        //Done text selected
        presentDone = new PresenterDone(this);

    }

    //////////////////////////////////////////////////////////////////// interface: IOnCreateBoard

    @Override
    public void animationSlide() {
        //animation
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition( new Slide(Gravity.RIGHT).setDuration(600) ); //set duration وقت التحرك
            getWindow().setExitTransition(new Slide(Gravity.LEFT).setDuration(600));  //when exist activity go right not left
        }
    }

    @Override
    public void alpha() {
        // alpha bar board of image point
        LinearLayout layoutLinner2 = findViewById(R.id.layoutLinner2);
        layoutLinner2.getBackground().setAlpha(70);
    }

    @Override
    public void buttonDONE_initialize() {
        TextView tvDone = findViewById(R.id.tvDone);
        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentDone.whenDoneClickedByUser();
            }
        });
    }

    @Override
    public void fragmentShow() {
        FragmentManager fm = getSupportFragmentManager();
        MyPagerAdapter objAdapter = new MyPagerAdapter( mActivity, mContext, fm);
        pager.setAdapter(objAdapter);
        System.out.println("onBoard - " + fm + " /ObjAdpater: " + objAdapter);

    }



    ///////////////////////////////////////////////////////// interface: Done click

    @Override
    public void DoneClicked() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity);
            Intent i = new Intent(mContext, loginActivity.class);
            startActivity(i, options.toBundle());
            finish();
        } else {
            Intent i = new Intent(mContext, loginActivity.class);
            startActivity(i);
            finish();
        }
    }
    //////////////////////////////////////////////////////////////////// interface: IPageChangeTheImagePoint

    @Override
    public void firstImagepoint_makeItLarge() {
        imPoint1.setImageResource(R.drawable.cirecle_big);
        imPoint1.animate().scaleX(2).scaleY(2).setDuration(500);
    }

    @Override
    public void smallAllPoint_toOrginalSize() {
        //reset all image agin bar point to gray
        imPoint1.setImageResource(R.drawable.cirecle_small);
        imPoint1.animate().scaleX(1).scaleY(1);     //orginal size
        imPoint2.setImageResource(R.drawable.cirecle_small);
        imPoint2.animate().scaleX(1).scaleY(1);
        imPoint3.setImageResource(R.drawable.cirecle_small);
        imPoint3.animate().scaleX(1).scaleY(1);
        imPoint4.setImageResource(R.drawable.cirecle_small);
        imPoint4.animate().scaleX(1).scaleY(1);
        imPoint5.setImageResource(R.drawable.cirecle_small);
        imPoint5.animate().scaleX(1).scaleY(1);
    }

    @Override
    public void makeThisImageLarge(int  position) {
        ImageView [] arrayImage = {imPoint1, imPoint2, imPoint3, imPoint4, imPoint5 };
        arrayImage[position].setImageResource(R.drawable.cirecle_big);
        arrayImage[position].animate().scaleX(2).scaleY(2).setDuration(500);
    }

}
