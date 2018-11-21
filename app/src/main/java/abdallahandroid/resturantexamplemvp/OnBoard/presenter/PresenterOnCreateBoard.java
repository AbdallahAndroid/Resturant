package abdallahandroid.resturantexamplemvp.OnBoard.presenter;

import android.app.Activity;
import android.util.DisplayMetrics;

import abdallahandroid.resturantexamplemvp.OnBoard.view.IOnCreateBoard;

public class PresenterOnCreateBoard implements IPresenterOnCreate {

    Activity mActivity ;
    IOnCreateBoard iOnCreateBoard;
    public PresenterOnCreateBoard(Activity mAct, IOnCreateBoard iOnCreateBoard){
        mActivity = mAct;
        this.iOnCreateBoard = iOnCreateBoard;

        onFirstCreated();

    }


    @Override
    public void onFirstCreated() {
        iOnCreateBoard.alpha();
        iOnCreateBoard.alpha();
        iOnCreateBoard.buttonDONE_initialize();
        iOnCreateBoard.firstImagepoint_makeItLarge();
        iOnCreateBoard.fragmentShow();
    }




}
