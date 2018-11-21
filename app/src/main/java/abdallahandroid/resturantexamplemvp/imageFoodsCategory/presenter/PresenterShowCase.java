package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.MyShareObject;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IDialogLanguage;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IShowCase;

public class PresenterShowCase implements  IPresenterShowCase {


    IShowCase IShow;
    Context mContext;
    Activity mActivity;
    MyShareObject s = new MyShareObject();
    IDialogLanguage IDialogLanguage;
    PresenterDialogAccount prsenterDialoagAccount;

    boolean finishAnimationTransition = false;

    public PresenterShowCase(Activity mActivity, Context mContext, IShowCase IShow,
                             IDialogLanguage IDialog, PresenterDialogAccount prsenterDialoagAccount){
        this.mActivity = mActivity;
        this.mContext = mContext;
        this.IShow = IShow;
        this.IDialogLanguage = IDialog;
        this.prsenterDialoagAccount = prsenterDialoagAccount;

        //start waiting now
        waitForFinishTransationAnimationThenDoShowCase();
    }




    @Override
    public void afterTransitionSlideHaveBeenEnded(final boolean inBackgroudnNow) {
        finishAnimationTransition = true;

    }

    @Override
    public void waitForFinishTransationAnimationThenDoShowCase() {
        ////////////////broad show case
        //generate new uniueId every time
        int uniqueId = 10 ;
        try {
            uniqueId = s.getDataBySharedObject_int(mContext, "uniqueId");
            //incremnt next time
            int increment = 1 + uniqueId;
            s.setDataBySharedObject(mContext , "uniqueId", increment);
        } catch (Exception e){
            uniqueId = 1000;
        }

        //show now  case 1
        final  int uniqueId_final = uniqueId;
        final Handler handler = new Handler();
        final Runnable runAble = new Runnable() {
            @Override
            public void run() {
                //animation end then show case 1
                if (finishAnimationTransition) {
                    IShow.showCase_1(uniqueId_final);


                    //else not finish animation then try agin
                } else {
                    handler.postDelayed(this, 100);  //infinity invoke code there
                }
            }
        };
        handler.post(runAble); //end handler
    }

    @Override
    public void afterDismisShowCase0(boolean inBackgroudnNow, int uniqueId) {
        //open next case
        IShow.showCase_1(uniqueId  );
    }

    @Override
    public void afterDismisShowCase1(boolean inBackgroudnNow, int uniqueId) {
        //open next case
        IShow.showCase_2(uniqueId  );
    }

    @Override
    public void afterDismisShowCase2(boolean inBackgroudnNow, int uniqueId) {

    }




}
