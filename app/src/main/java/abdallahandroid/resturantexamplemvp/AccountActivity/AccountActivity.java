package abdallahandroid.resturantexamplemvp.AccountActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.AccountActivity.presenter.PresenterCameraTaken;
import abdallahandroid.resturantexamplemvp.AccountActivity.presenter.PresenterWriteProfielData;
import abdallahandroid.resturantexamplemvp.AccountActivity.view.IWriteProfiel;
import abdallahandroid.resturantexamplemvp.AccountActivity.view.Ibuttons;

public class AccountActivity extends AppCompatActivity
        implements IWriteProfiel, Ibuttons {

    PresenterWriteProfielData presenter;
    PresenterCameraTaken prsenterCamera;
    Activity mActivity;

    ImageView imCancel, imYourImage, takeImage;
    TextView tvUserName, tvEmail, tvPhone, tvId, tvResturantName, tvThemeColor, tvThemeAccent;
    de.hdodenhof.circleimageview.CircleImageView  profile_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_account);
        mActivity =this;
        imCancel = findViewById(R.id.imCancel);
        takeImage = findViewById(R.id.takeImage);
        imYourImage = findViewById(R.id.imYourImage);
        tvUserName = findViewById(R.id.tvUserName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvId = findViewById(R.id.tvId);
        tvResturantName = findViewById(R.id.tvResturantName);
        tvThemeColor = findViewById(R.id.tvThemeColor);
        tvThemeAccent = findViewById(R.id.tvThemeAccent);
        profile_image = findViewById(R.id.profile_image);




        presenter = new PresenterWriteProfielData (mActivity, this);

        prsenterCamera = new PresenterCameraTaken(this);
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
        String fontName = "waltographUI.ttf";
        tvUserName.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
        tvEmail.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
        tvPhone.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
        tvId.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
        tvResturantName.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
        tvThemeColor.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
        tvThemeAccent.setTypeface(Typeface.createFromAsset(getAssets(),fontName));
    }


    @Override
    public void alpha() {

    }

    @Override
    public void setImageAccount(Drawable drawable) {
        System.out.println("setImageAccount - drawable: " + drawable);
//        imYourImage.setImageDrawable(drawable);
        profile_image.setImageDrawable(drawable);
        profile_image.setVisibility(View.VISIBLE);
        imYourImage.setVisibility(View.GONE);
    }



    @Override
    public void setTextviewOfDialog(String name, String email, String phone, String id, String resturantName,
                                    String themeColor, String themeAccentColor) {
        tvUserName.setText(name);
        tvEmail.setText(email);
        tvPhone.setText(phone);
        tvId.setText(id);
        tvResturantName.setText(resturantName);
        tvThemeColor.setBackgroundColor(Color.parseColor(themeColor));
        tvThemeColor.setText(themeColor);
        tvThemeAccent.setBackgroundColor(Color.parseColor(themeAccentColor));
        tvThemeAccent.setText(themeAccentColor);
    }

    @Override
    public void buttonCancel() {
        imCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private static final int CAMERA_REQUEST_code = 1888;  //code used insdie Intent

    @Override
    public void buttonCamera() {
        takeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, CAMERA_REQUEST_code);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_code) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");                                    //this IM line to get Bitmap data
            prsenterCamera.returnBitmapFromActivityResult(bitmap);
        }
    }

    @Override
    public void takeImage(Bitmap bitmap) {
        imYourImage.setVisibility(View.GONE);
        profile_image.setVisibility(View.VISIBLE);
        profile_image.setImageBitmap(bitmap);
    }


}
