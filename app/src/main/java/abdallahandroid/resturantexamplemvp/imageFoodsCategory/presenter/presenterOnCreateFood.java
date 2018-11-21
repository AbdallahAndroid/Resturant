package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import android.app.Activity;
import android.util.DisplayMetrics;

import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IOnCreateFood;

public class presenterOnCreateFood  implements  IPresenterOnCreateFood{

    IOnCreateFood ICreate;
    Activity mActivity;
    public presenterOnCreateFood(Activity mAct, IOnCreateFood iCreateFood){
        mActivity = mAct;
        ICreate = iCreateFood;

        startAllMethodOfInterfaceOnCreateNow();
        calculateSizeOFScreenSize_toGoneTheOkMenuLogo();
    }


    @Override
    public void startAllMethodOfInterfaceOnCreateNow() {
        ICreate.alphaBackgroudImage();
        ICreate.animation();
        ICreate.fonts();

    }

    @Override
    public void calculateSizeOFScreenSize_toGoneTheOkMenuLogo() {
        DisplayMetrics metrics = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int wid = metrics.widthPixels;
        System.out.println("width is " +  wid);
        if (wid < 900 ) ICreate.smallScreenSize();
    }


}
