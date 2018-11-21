package abdallahandroid.resturantexamplemvp.DialogLanguage.presenter;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import abdallahandroid.resturantexamplemvp.DialogLanguage.model.DataDialog;
import abdallahandroid.resturantexamplemvp.DialogLanguage.view.IDialog;
import abdallahandroid.resturantexamplemvp.R;

public class Presenter implements  IPresenter{


    IDialog iDialog;
    Activity mActivity;
    DataDialog mod ;

    public Presenter(Activity mActivity, IDialog iDialog){
        this.mActivity = mActivity;
        this.iDialog = iDialog;
        mod = new DataDialog();

        //onCreate then
        iDialog.animation();
        startShowDialog();
    }

    @Override
    public void startShowDialog() {
        ListView listview = (ListView) mActivity.findViewById(R.id.list);
        //initliz values
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(DataDialog.normalArray));
        System.out.println("mvp - dialog - arrayList: " + arrayList);
        //create apater
        ArrayAdapter<String > adapter = new ArrayAdapter<String>(mActivity, android.R.layout.simple_list_item_1, arrayList);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                iDialog.itemSelected(position);
            }
        });

    }

    @Override
    public void afterChoosedLanguage(String lang) {
        //set selected data
        DataDialog.setSelectedDialogLanuage(lang);
        //Done
        iDialog.choosedDone(lang);
    }
}
