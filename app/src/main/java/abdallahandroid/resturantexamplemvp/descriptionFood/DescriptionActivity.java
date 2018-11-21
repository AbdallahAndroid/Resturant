package abdallahandroid.resturantexamplemvp.descriptionFood;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.descriptionFood.presenter.PresenterOnCreate;
import abdallahandroid.resturantexamplemvp.descriptionFood.view.IOnCreate;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import abdallahandroid.resturantexamplemvp.descriptionFood.presenter.PresenterOnCreate;
import abdallahandroid.resturantexamplemvp.descriptionFood.view.IOnCreate;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class DescriptionActivity extends AppCompatActivity
        implements IOnCreate {


    TextView tvDescription, tvItemCounter, tvNameCategory, tvResturantName;
    PresenterOnCreate presentOnCreate;
    public Context mContext;
    public Activity mActivity;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mContext = getBaseContext();
        mActivity = this;
        tvDescription = findViewById(R.id.tvDescription);
        tvItemCounter = findViewById(R.id.tvItemCounter);
        tvNameCategory = findViewById(R.id.tvNameCategory);
        tvResturantName = findViewById(R.id.tvResturantName);
        image = findViewById(R.id.image);


        //onCreate
        presentOnCreate = new PresenterOnCreate(mActivity, this);

    }

    @Override
    public void alpah() {
        // alpha bar board of image point
        LinearLayout layoutTitleResturantName = findViewById(R.id.layoutTitleResturantName);
        layoutTitleResturantName.getBackground().setAlpha(10);
        //alpha layoutDescritpion
        RelativeLayout layoutDescritpion = findViewById(R.id.layoutDescritpion);
        layoutDescritpion.getBackground().setAlpha(40);
    }

    @Override
    public void animation() {
        //animation
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition( new Slide(Gravity.RIGHT).setDuration(600) ); //set duration وقت التحرك
            getWindow().setExitTransition(new Slide(Gravity.LEFT).setDuration(600));  //when exist activity go right not left
        }
    }


    @Override
    public void fonts() {
        //font restaurant name
        tvResturantName.setTypeface(Typeface.createFromAsset(getAssets(),"DancingScript-Regular.ttf"));
        //font initlizer library    Calligraphy
        String fontPathFolder = "fonts/Shoroq-Font.ttf" ;
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(fontPathFolder).   //example: "fonts/Shoroq-Font.ttf"
                setFontAttrId(R.attr.fontPath).build());
    }


    @Override
    protected void attachBaseContext(Context newBase) {             ///for library   Calligraphy
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void setDataOfThisDescription(String imageUrl, String name, String description,  String itemCounter) {
        tvResturantName.setText(GeneralData.resturantName);
        tvNameCategory.setText(name);
        tvDescription.setText(description);
        tvItemCounter.setText("item Counter : " + itemCounter);

        //set image url
        System.out.println("imageDonwoald - imageUrl: "  + imageUrl );
        String baseUrlWithImageUrl =   imageUrl;
        Glide.with(mActivity).load(baseUrlWithImageUrl).into( new SimpleTarget() {
            @Override
            public void onResourceReady(Object resource, GlideAnimation glideAnimation) {
                try {
                    Drawable drawableFromGlide = (Drawable) resource;
                    image.setBackground(drawableFromGlide);
                    System.out.println("imageDonwoald -  ok drawableFromGlide: "  + drawableFromGlide );
                }catch (Exception e){
                }
            }
        } );

    }
}
