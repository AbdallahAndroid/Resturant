package abdallahandroid.resturantexamplemvp.AccountActivity.presenter;

import android.graphics.Bitmap;

import abdallahandroid.resturantexamplemvp.AccountActivity.view.Ibuttons;

public class PresenterCameraTaken implements IPresenterTakenCapture{

    Ibuttons iButton;
    public PresenterCameraTaken(Ibuttons iButton){
        this.iButton = iButton;
    }

    @Override
    public void returnBitmapFromActivityResult(Bitmap bitmap) {
        iButton.takeImage(bitmap);
    }
}
