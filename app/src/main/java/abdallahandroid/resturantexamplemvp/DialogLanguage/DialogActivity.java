package abdallahandroid.resturantexamplemvp.DialogLanguage;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import abdallahandroid.resturantexamplemvp.DialogLanguage.model.DataDialog;
import abdallahandroid.resturantexamplemvp.DialogLanguage.presenter.Presenter;
import abdallahandroid.resturantexamplemvp.DialogLanguage.view.IDialog;
import abdallahandroid.resturantexamplemvp.R;

public class DialogActivity extends AppCompatActivity implements IDialog {


    ListView listview;

    Presenter pres ;
    Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_language);
        listview = (ListView) findViewById(R.id.list);

        mActivity = this;


        //presenter start dialog
        pres = new Presenter(mActivity, this);

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
    public void itemSelected(int position) {
        String whatLang = DataDialog.normalArray[position];
        pres.afterChoosedLanguage(whatLang);
    }

    @Override
    public void choosedDone(String whatLang) {
        //finish activity with
        Intent returnIntent = new Intent();
        setResult(Activity.RESULT_OK, returnIntent);
        returnIntent.putExtra("languageChoosed", whatLang );
        finish();
        System.out.println("dialog choosedDone   whatLang: " + whatLang);
    }

}
