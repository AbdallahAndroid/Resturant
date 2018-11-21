package abdallahandroid.resturantexamplemvp.AccountActivity.presenter;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import abdallahandroid.resturantexamplemvp.AccountActivity.model.DataProfiel;
import abdallahandroid.resturantexamplemvp.AccountActivity.view.IWriteProfiel;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;

public class PresenterWriteProfielData implements  IPrsenterProfiel {

    IWriteProfiel iProfiel;
    Activity mActivity;
    public PresenterWriteProfielData(Activity mActivity, IWriteProfiel iProfiel ){
        this.iProfiel = iProfiel;
        this.mActivity = mActivity;

        iProfiel.alpha();
        iProfiel.animation();
        iProfiel.buttonCamera();
        iProfiel.buttonCancel();
        iProfiel.fonts();


        //get data from JSON and imageUrl download
        downloadImageAccount();
        getDataToBeSetInsideDialoag();
    }

    @Override
    public void downloadImageAccount() {
        //set image url
        String baseUrlWithImageUrl =  DataProfiel.profiel_imageUrl;
        System.out.println("setImageAccount - url: " + baseUrlWithImageUrl);
        Glide.with(mActivity).load(baseUrlWithImageUrl).into(new SimpleTarget() {
            @Override
            public void onResourceReady(Object resource, GlideAnimation glideAnimation) {
                try {
                    Drawable drawableFromGlide = (Drawable) resource;
                    iProfiel.setImageAccount(drawableFromGlide);
                    System.out.println("setImageAccount - glide ok: " + drawableFromGlide );
                }catch (Exception e){
                }
            }
        } );
    }



    @Override
    public void getDataToBeSetInsideDialoag() {
        iProfiel.setTextviewOfDialog(DataProfiel.profiel_userName, DataProfiel.profiel_email, DataProfiel.profiel_phone,
                DataProfiel.profiel_refrenceId, DataProfiel.resturantName, DataProfiel.profiel_themeColor,
                DataProfiel.profiel_themeAccent);
    }



}
