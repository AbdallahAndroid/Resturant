package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import java.util.Map;

import abdallahandroid.resturantexamplemvp.DialogLanguage.model.DataDialog;
import abdallahandroid.resturantexamplemvp.R;
import abdallahandroid.resturantexamplemvp.descriptionFood.model.DataSelectedByUser;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IOnItemSelected;

public class PresenterOnItemSelected implements IPresenterOnItemSelected {


    DataSelectedByUser select = new DataSelectedByUser();
    Activity mActivity;
    static IOnItemSelected iItemSelected;


    //listenner item selected
    public PresenterOnItemSelected () {} //default Consturctor to be used from class "GridViewMyAdapter.class"



    public PresenterOnItemSelected(Activity mAct, IOnItemSelected iSelect) {
        this.iItemSelected = iSelect;
        mActivity = mAct;

    }

    @Override
    public void setDataSelectedToClassData(int position) {
        /////////set data selected by user
        //set image url
        String imageUrl = GeneralData.imageUrl_list.get(position);
        select.setImageUrl( imageUrl);
        //set category name
        String categoryName = GeneralData.nameEnglish_list.get(position) ;
        select.setCategeroyName( categoryName);
        //set description
        select.setDescription( GeneralData.description_list.get(position));  // as  "good food"
        //set itemcounter
        select.setItemCounter( "" + position );

        /////////////// now open view
        iItemSelected.categorySelected();
    }



}
