package abdallahandroid.resturantexamplemvp.login.presenter;

import android.app.Activity;
import android.view.View;

import abdallahandroid.resturantexamplemvp.login.view.onCreateLogin;

public class PresenterOnCreate implements  IPresenterOnCreate {

    onCreateLogin onCreate;
    public PresenterOnCreate(onCreateLogin onCreate ){

        this.onCreate = onCreate;

        onCreate();
    }



    @Override
    public void onCreate() {
        onCreate.animationSlide();;
        onCreate.getOldDataEnteredByUserToBeSetInsideEditText();
    }
}
