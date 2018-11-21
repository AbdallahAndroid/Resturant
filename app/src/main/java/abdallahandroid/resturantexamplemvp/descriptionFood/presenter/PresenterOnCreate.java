package abdallahandroid.resturantexamplemvp.descriptionFood.presenter;

import android.app.Activity;

import abdallahandroid.resturantexamplemvp.descriptionFood.model.DataSelectedByUser;
import abdallahandroid.resturantexamplemvp.descriptionFood.view.IOnCreate;
import abdallahandroid.resturantexamplemvp.descriptionFood.model.DataSelectedByUser;

public class PresenterOnCreate  implements IPresenterOnCreate {

    IOnCreate iOnCreate;
    Activity mActivity;
    DataSelectedByUser selected = new DataSelectedByUser();


    public PresenterOnCreate(Activity mActivity, IOnCreate iOnCreate){
        this.mActivity = mActivity;
        this.iOnCreate = iOnCreate;

        alpha();
        animation();
        showDataSelected();
    }

    @Override
    public void alpha() {
        iOnCreate.alpah();
    }

    @Override
    public void animation() {
        iOnCreate.animation();
    }

    @Override
    public void fontsIntitlzie() {
        iOnCreate.fonts();
    }

    @Override
    public void showDataSelected() {
        // get seleected data
        iOnCreate.setDataOfThisDescription(selected.getImageUrl(), selected.getCategeroyName(),
                selected.getDescription(), selected.getItemCounter() );
    }



}
