package abdallahandroid.resturantexamplemvp.imageFoodsCategory;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wooplr.spotlight.SpotlightView;
import com.wooplr.spotlight.utils.SpotlightListener;

import abdallahandroid.resturantexamplemvp.AccountActivity.AccountActivity;
import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.descriptionFood.DescriptionActivity;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter.PresenterDialogAccount;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter.PresenterDrawingList;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter.PresenterOnItemSelected;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter.PresenterShowCase;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter.presenterOnCreateFood;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter.recyclerViewAdapter;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IDialogAccount;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IDialogLanguage;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IOnCreateFood;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IDrawing;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IOnItemSelected;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IShowCase;
import abdallahandroid.resturantexamplemvp.DialogLanguage.DialogActivity;

import es.dmoral.toasty.Toasty;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FoodCategoryActivity extends Activity implements
        IOnCreateFood, IShowCase, IDialogLanguage, IDialogAccount, IDrawing, IOnItemSelected {

    Context mContext;
    Activity mActivity;

    TextView tvRestName;
    ImageView imLanguage,   imAccount, imageLogo;

    PresenterShowCase presenterShowCase;
    presenterOnCreateFood presenterOnCreate;
    PresenterDrawingList presenterDraw;
    PresenterOnItemSelected presentOnItemSelect;
    PresenterDialogAccount presenterDialogAccount;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
        mContext = getBaseContext();
        mActivity = this;
        tvRestName = findViewById(R.id.tvRestName);
        imLanguage = findViewById(R.id.imLanguage);
        imAccount = findViewById(R.id.imAccount);
        imageLogo = findViewById(R.id.imageLogo);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        //onCreate presenter
        presenterOnCreate = new presenterOnCreateFood(mActivity,this);

        //presenter drawing list :  image with name of food
        presenterDraw = new PresenterDrawingList(this);

        //prsenter on item selected of category
        presentOnItemSelect = new PresenterOnItemSelected(mActivity, this);

        //buttons admin
        buttonAccountClicked();

        //button language
        buttonLanguageClick();

        //dialog language
        presenterDialogAccount = new PresenterDialogAccount(this);

        ///////////////// AFTER INTILZE ALL THING button THEN SHOW CASE NOW
        //show case presenter
        presenterShowCase = new PresenterShowCase(mActivity, mContext, this, this, presenterDialogAccount);



    }



    //////////////////////////////////////////////////////////////////// button click listener

    private void buttonLanguageClick() {
        imLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aniamtion now
                Animation hyperspaceJump = AnimationUtils.loadAnimation(mContext, R.anim.translate_button);
                imLanguage.startAnimation(hyperspaceJump);
                //wait 400 milisecond whilie end aniamtion then open activity dialog
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        openDialogLanguage();
                    }
                }, 400);

            }
        });
    }

    private void buttonAccountClicked() {
        imAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aniamtion now
                Animation hyperspaceJump = AnimationUtils.loadAnimation(mContext, R.anim.translate_button);
                imAccount.startAnimation(hyperspaceJump);
                //open image of foods
                presenterDialogAccount.checkDownloadDataCompelteToCanOpenDialog();
            }
        });
    }

    @Override
    public void openDialogAccount() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity);
            Intent i = new Intent(mContext, AccountActivity.class);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(mContext, AccountActivity.class);
            startActivity(i);
        }
    }

    @Override
    public void messagaPleazeWaitWhileDownloadComplete() {
        Toasty.info(mContext , "pleaze wait while download complete then try agin.");
    }

    //////////////////////////////////////////////////////////////////// interface :  IOnCreateFood

    @Override
    public void animation() {

        //animation slide
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide sl = new Slide(Gravity.RIGHT);  //setDuration(600);
            Transition tra = sl.setDuration(600);
            getWindow().setEnterTransition( tra ); //set duration وقت التحرك
//            getWindow().setExitTransition(new Slide(Gravity.LEFT).setDuration(600));  //when exist activity go right not left

            tra.addListener(new Transition.TransitionListener() {
                @Override
                public void onTransitionStart(Transition transition) {
                    // showCase_1();
                    System.out.println("tarnsition - onStart");
                }
                @Override
                public void onTransitionEnd(Transition transition) {
                    System.out.println("tarnsition - onEnd");
                    presenterShowCase.afterTransitionSlideHaveBeenEnded(inBackgroudnNow);
                }
                @Override
                public void onTransitionCancel(Transition transition) {
                }
                @Override
                public void onTransitionPause(Transition transition) {
                }
                @Override
                public void onTransitionResume(Transition transition) {
                }
            });
        }

    }


    @Override
    public void alphaBackgroudImage() {
        //alpha
        LinearLayout layoutHome = findViewById(R.id.layoutHome);
        layoutHome.getBackground().setAlpha(30);
    }

    @Override
    public void fonts() {
        //font restaurant name
        tvRestName.setTypeface(Typeface.createFromAsset(getAssets(),"DancingScript-Regular.ttf"));
        //font initlizer library    Calligraphy
        String fontPathFolder = "fonts/Shoroq-Font.ttf" ;
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(fontPathFolder).   //example: "fonts/Shoroq-Font.ttf"
                setFontAttrId(R.attr.fontPath).build());
    }

    @Override
    public void smallScreenSize() {
        //tv restuant small size text
        RelativeLayout.LayoutParams lptv = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lptv.setMargins(10 , 10 , 10, 50 );
        tvRestName.setLayoutParams(lptv);
        tvRestName.setTextSize(30);
        //image logo gone
        imageLogo.setVisibility(View.GONE);
        //image languag
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(50, 50);
        lp.setMargins(600, 10, 10, 0);
        imLanguage.setLayoutParams(lp);
        //image account
        RelativeLayout.LayoutParams lp2 = new RelativeLayout.LayoutParams(50, 50);
        lp2.setMargins(700, 10, 10, 0);
        imAccount.setLayoutParams(lp2);
    }

    @Override
    protected void attachBaseContext(Context newBase) {             ///for library   Calligraphy
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


    ///////////////////////////////////////////////////////////////////////// interface:  IShowCase

    @Override
    public void showCase_1(final int uniqueId) {
        SpotlightView material = new SpotlightView.Builder(mActivity)
                .introAnimationDuration(400)
                .enableRevealAnimation(true)
                .performClick(true)
                .fadeinTextDuration(400)
                .headingTvColor(Color.parseColor("#FFEB3B"))
                .headingTvSize(32)
                .headingTvText("Language")
                .subHeadingTvColor(Color.parseColor("#ffffff"))
                .subHeadingTvSize(16)
                .subHeadingTvText("Tab here to choose \nyour language.")
                .maskColor(Color.parseColor("#dc000000"))
                .target( imLanguage )
                .lineAnimDuration(400)
                .lineAndArcColor(Color.parseColor("#eb273f"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
                .usageId("UNIQUE ID " + uniqueId + " one")
                .setListener(new SpotlightListener() {
                    @Override
                    public void onUserClicked(String s) {
                        presenterShowCase.afterDismisShowCase1(inBackgroudnNow, uniqueId);
                    }
                })
                .show();
    }

    @Override
    public void showCase_2(final int uniqueId) {
        SpotlightView material = new SpotlightView.Builder(mActivity)
                .introAnimationDuration(400)
                .enableRevealAnimation(true)
                .performClick(true)
                .fadeinTextDuration(400)
                .headingTvColor(Color.parseColor("#FFEB3B"))
                .headingTvSize(32)
                .headingTvText("Admin")
                .subHeadingTvColor(Color.parseColor("#ffffff"))
                .subHeadingTvSize(16)
                .subHeadingTvText("Tab here to see \nyour profile.")
                .maskColor(Color.parseColor("#dc000000"))
                .target( imAccount )
                .lineAnimDuration(400)
                .lineAndArcColor(Color.parseColor("#eb273f"))
                .dismissOnTouch(true)
                .dismissOnBackPress(true)
                .enableDismissAfterShown(true)
                .usageId("UNIQUE ID " + uniqueId + " two")
                .setListener(new SpotlightListener() {
                    @Override
                    public void onUserClicked(String s) {
                        System.out.println("showCase - click  " + s);
                        presenterShowCase.afterDismisShowCase2(inBackgroudnNow, uniqueId);
                    }
                })
                .show();
    }


    /////////////////////////////////////////////////////////////////// ////  backgroud life cycle

    boolean inBackgroudnNow = false;
    @Override
    protected void onStop() {
        super.onStop();
        inBackgroudnNow = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        inBackgroudnNow = false;
    }

    ///////////////////////////////////////////////////////////////////////// interface:  IDialogLanguage

    int languageCode = 211;

    @Override
    public void openDialogLanguage() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity);
            Intent i = new Intent(mContext, DialogActivity.class);
            mActivity.startActivityForResult(i, languageCode, options.toBundle() );
        } else{
            Intent i = new Intent(mContext, DialogActivity.class);
            mActivity.startActivityForResult(i, languageCode);
        }
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("dialog selected RESULT_OK: " + RESULT_OK);
        if (resultCode == RESULT_OK) {
            //when change language
            if (requestCode == languageCode) {
               //agin reItnlzie
                String langIs = data.getStringExtra("languageChoosed");
                System.out.println("dialog selected Lang: " + langIs );
                if (langIs != null ) presenterDraw.drawThisLanguage(langIs);
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////// interface:  IRecyclerView

    @Override
    public void drawNow(String [] nameArray, String [] imageArray) {
        System.out.println("dialog - draw now inside activity foodcategory");
        new recyclerViewAdapter(mActivity, mContext, nameArray, imageArray);
    }

    @Override
    public void setNameOfResturant(String nameOfResturant) {
        if (nameOfResturant != null ){
            tvRestName.setText(nameOfResturant);
        } else {
            tvRestName.setText("");
        }
    }

    /////////////////////////////////////////////////////////////////////////// interface: on item selected
    @Override
    public void categorySelected() {
        //open description page
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(mActivity);
            Intent i = new Intent(mContext, DescriptionActivity.class);
            startActivity(i, options.toBundle());
        } else {
            Intent i = new Intent(mContext, DescriptionActivity.class);
            startActivity(i);
        }

    }


}
